package org.epita.tpfacture.application;

import javax.transaction.Transactional;

import org.epita.tpfacture.domaine.Client;
import org.epita.tpfacture.domaine.Devis;
import org.epita.tpfacture.domaine.Facture;
import org.epita.tpfacture.domaine.Produit;
import org.epita.tpfacture.domaine.QProduitDevis;
import org.epita.tpfacture.domaine.QProduitFacture;
import org.epita.tpfacture.infrastructure.ClientDao;
import org.epita.tpfacture.infrastructure.FactureDao;
import org.epita.tpfacture.infrastructure.ProduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	private FactureDao factureDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private ProduitDao produitDao;
	
	@Transactional
	public void create(Facture facture) {
		Client client = clientDao.getClientByNom(facture.getClientFacture().getNom());
		if (client == null ) {
			throw new NotFoundException("client non trouvé");
		}
		facture.getClientFacture().setId(client.getId());
		double total = 0;
		for (QProduitFacture qp : facture.getqProduitsFacture()) {
			Produit produit = produitDao.getProduitByCode(qp.getCodeProduitFacture());
			if (produit == null) {
				throw new NotFoundException("produit "+qp.getCodeProduitFacture()+" non trouve");
			}
			total += produit.getPrix() * qp.getQuantiteProduit();
		}
		facture.setTotalFacture(total);
		factureDao.create(facture);
	}

	public String sortirFacture(int numeroFacture) {
		Facture facture = factureDao.getFactureByNumero(numeroFacture);
		String factureFiche = "";
		double total = 0;
		factureFiche += "------------- CLIENT ------------\n";
		factureFiche += facture.getClientFacture().getNom()+" à l'adresse ";
		if (facture.getClientFacture().getAdressePostale() == null) {
			factureFiche += "inconnue\n";
		} else {
			factureFiche += facture.getClientFacture().getAdressePostale().getCodePostal()+" rue "+
						facture.getClientFacture().getAdressePostale().getNomRue()+"\n";
		}
		factureFiche+= "------------- LISTE PRODUITS ------------\n";
		factureFiche+= "La liste des produits : \n";
		for (QProduitFacture qp : facture.getqProduitsFacture()) {
			factureFiche+= "  - "+produitDao.getProduitByCode(qp.getCodeProduitFacture()).getDescription()+
							" pour un prix de "+produitDao.getProduitByCode(qp.getCodeProduitFacture()).getPrix()+" euros\n";
		}
		factureFiche+= "-------------------- TOTAL ------------------------\n";
		factureFiche+= "Total = "+facture.getTotalFacture();
		return factureFiche;
	}

}
