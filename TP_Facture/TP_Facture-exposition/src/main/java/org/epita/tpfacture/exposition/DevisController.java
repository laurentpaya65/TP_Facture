package org.epita.tpfacture.exposition;

import org.epita.tpfacture.application.DevisService;
import org.epita.tpfacture.application.FactureService;
import org.epita.tpfacture.domaine.Devis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DevisController {
	
	@Autowired
	private DevisService devisService;
	@Autowired
	private FactureService factureService;
	
//	{"numeroDevis": 1,
//		"qProduitsDevis":[{"codeProduitDevis":"0001","quantiteDevis":10,
//		                    "codeProduitDevis":"0002","quantiteDevis":15,
//		                    "codeProduitDevis":"0003","quantiteDevis":20}],
//		"clientDevis": {"nom" : "jojo"}
//		}	
	@PostMapping(value = {"/creerdevis"},consumes = {"application/json"})
	public void creerDevis(@RequestBody final Devis devis) {
		devisService.create(devis);
	}

	@GetMapping(value = {"/devis/{numeroDevis}"})
	public String sortirDevis(@PathVariable("numeroDevis") final int numeroDevis) {
		return devisService.sortirDevis(numeroDevis);
	}
	@GetMapping(value = {"/transformdevis/{numeroDevis}"})
	public String transformDevis(@PathVariable("numeroDevis") final int numeroDevis) {
		int numFacture = devisService.transformDevisEnFacture(numeroDevis);
		System.out.println("numFacture avant edition="+numFacture);
		return factureService.sortirFacture(numFacture);
	}	
	
}
