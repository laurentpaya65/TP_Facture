package org.epita.tpfacture.exposition;

import org.epita.tpfacture.application.FactureService;
import org.epita.tpfacture.domaine.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FactureController {
	
	@Autowired
	private FactureService factureService;
	
//	{"numeroFacture": 2,
//		"qProduitsFacture":[{"codeProduitFacture":"0001","quantiteProduit":10},
//		                   { "codeProduitFacture":"0002","quantiteProduit":15},
//		                    {"codeProduitFacture":"0003","quantiteProduit":20}],
//		"clientFacture": {"nom" : "jiji"}
//		}	
	@PostMapping(value = {"/creerfacture"},consumes = {"application/json"})
	public void creerFacture(@RequestBody final Facture facture) {
		factureService.create(facture);
	}

	@GetMapping(value = {"/facture/{numeroFacture}"})
	public String sortirFacture(@PathVariable("numeroFacture") final int numeroFacture) {
		return factureService.sortirFacture(numeroFacture);
	}
}
