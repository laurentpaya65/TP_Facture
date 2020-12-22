package org.epita.tpfacture.application;

import org.epita.tpfacture.domaine.Client;

public interface ClientService {

	void create(Client client);
	
	Client getClientByNom(String nom);
}
