package org.epita.tpfacture.application;

import org.epita.tpfacture.domaine.Produit;
import org.epita.tpfacture.infrastructure.ProduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitDao produitDao;
	
	public void create(Produit produit) {
		produitDao.create(produit);

	}

	public Produit getProduitByCode(String codeProduit) {
		
		return produitDao.getProduitByCode(codeProduit);
	}

}
