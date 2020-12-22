package org.epita.tpfacture.exposition;

import org.epita.tpfacture.application.ClientService;
import org.epita.tpfacture.domaine.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

//	{"nom": "jojo",
//		"adressePostale": {"codePostal" : "78500" , "nomRue" : "rue paul"} 
//		}	
	@PostMapping(value = {"/creerclient"},consumes = {"application/json"})
	public void creerClient(@RequestBody final Client client) {
		clientService.create(client);
	}

}
