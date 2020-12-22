package org.epita.tpfacture.application;

import org.epita.tpfacture.domaine.Client;
import org.epita.tpfacture.infrastructure.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	
	public void create(Client client) {
		clientDao.create(client);

	}

	public Client getClientByNom(String nom) {
		// TODO Auto-generated method stub
		return clientDao.getClientByNom(nom);
	}

}
