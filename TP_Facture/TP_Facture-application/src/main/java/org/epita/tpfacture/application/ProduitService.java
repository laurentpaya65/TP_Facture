package org.epita.tpfacture.application;

import org.epita.tpfacture.domaine.Produit;

public interface ProduitService {

	void create(Produit produit);
	
	Produit getProduitByCode(String codeProduit);
}
