package org.epita.tpfacture.infrastructure;

import org.epita.tpfacture.domaine.Client;

public interface ClientDao {

	void create(Client client);
	
	Client getClientByNom(String nom);
}
