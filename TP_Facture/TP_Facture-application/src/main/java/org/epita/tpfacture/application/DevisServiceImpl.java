package org.epita.tpfacture.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.epita.tpfacture.domaine.Client;
import org.epita.tpfacture.domaine.Devis;
import org.epita.tpfacture.domaine.Facture;
import org.epita.tpfacture.domaine.QProduitDevis;
import org.epita.tpfacture.domaine.QProduitFacture;
import org.epita.tpfacture.infrastructure.ClientDao;
import org.epita.tpfacture.infrastructure.DevisDao;
import org.epita.tpfacture.infrastructure.FactureDao;
import org.epita.tpfacture.infrastructure.ProduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevisServiceImpl implements DevisService {

	@Autowired
	private DevisDao devisDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private ProduitDao produitDao;
	@Autowired
	private FactureDao factureDao;
	
	public void create(Devis devis) {
		Client client = clientDao.getClientByNom(devis.getClientDevis().getNom());
		if (client == null) {
			throw new NotFoundException("Client non trouvé");
		}  
		double total = 0;
		for (QProduitDevis qp : devis.getqProduitsDevis()) {
			if (produitDao.getProduitByCode(qp.getCodeProduitDevis()) == null) {
				throw new NotFoundException("produit "+qp.getCodeProduitDevis()+" non trouvé");
			}
			total += produitDao.getProduitByCode(qp.getCodeProduitDevis()).getPrix() *
					qp.getQuantiteDevis();
		}
		devis.setTotalDevis(total);
		
		devis.setClientDevis(client);
		devisDao.create(devis);

	}

//	public Devis getByNumeroDevis(int numeroDevis) {
//		return devisDao.getByNumeroDevis(numeroDevis);
//	}

	public String sortirDevis(int numeroDevis) {
		Devis devis = devisDao.getByNumeroDevis(numeroDevis);
		String devisFiche = "";
		double total = 0;
		devisFiche += "------------- CLIENT ------------\n";
		devisFiche += devis.getClientDevis().getNom()+" à l'adresse ";
		if (devis.getClientDevis().getAdressePostale() == null) {
			devisFiche += "inconnue\n";
		} else {
			devisFiche += devis.getClientDevis().getAdressePostale().getCodePostal()+" rue "+
						devis.getClientDevis().getAdressePostale().getNomRue()+"\n";
		}
		devisFiche += "------------- LISTE PRODUITS ------------\n";
		devisFiche += "La liste des produits : \n";
		for (QProduitDevis qp : devis.getqProduitsDevis()) {
			devisFiche += "  - "+produitDao.getProduitByCode(qp.getCodeProduitDevis()).getDescription()+
							" pour un prix de "+produitDao.getProduitByCode(qp.getCodeProduitDevis()).getPrix()+" euros\n";
		}
		devisFiche += "-------------------- TOTAL ------------------------\n";
		devisFiche += "Total = "+devis.getTotalDevis();
		return devisFiche;
	}

	@Transactional
	public int transformDevisEnFacture(int numeroDevis) {
		Devis devis = devisDao.getByNumeroDevis(numeroDevis);
		if (devis == null) {
			throw new NotFoundException("Devis non trouvé");
		}
		Facture facture=new Facture();
		int numFacture = factureDao.getMaxNumeroFacture();
		System.out.println("numFacture="+numFacture);
		facture.setNumeroFacture(numFacture);
		facture.setTotalFacture(devis.getTotalDevis());
		Set<QProduitFacture> qps=new HashSet();
		for (QProduitDevis qpDevis : devis.getqProduitsDevis()) {
			QProduitFacture qp = new QProduitFacture();
			qp.setCodeProduitFacture(qpDevis.getCodeProduitDevis());
			qp.setQuantiteProduit(qpDevis.getQuantiteDevis());
			qps.add(qp);
		}
		facture.setqProduitsFacture(qps);
		facture.setClientFacture(devis.getClientDevis());
		factureDao.create(facture);
		return numFacture;
	}

}
