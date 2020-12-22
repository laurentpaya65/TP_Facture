package org.epita.tpfacture.exposition;

import org.epita.tpfacture.application.ProduitService;
import org.epita.tpfacture.domaine.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProduitController {
	
	@Autowired
	private ProduitService produitService;
	
//	{"codeProduit": "0002",
//		"description": "clavier",
//		"prix":10.0,
//		"quantiteStock":10
//		}	
	@PostMapping(value = {"/creerproduit"},consumes = {"application/json"})
	public void creerProduit(@RequestBody final Produit produit) {
		produitService.create(produit);
	}

}
