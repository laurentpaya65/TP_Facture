package org.epita.tpfacture.infrastructure;

import org.epita.tpfacture.domaine.Produit;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao {

	void create(Produit produit);
	
	Produit getProduitByCode(String codeProduit);
}
