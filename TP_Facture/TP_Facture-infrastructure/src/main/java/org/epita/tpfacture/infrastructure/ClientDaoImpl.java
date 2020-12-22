package org.epita.tpfacture.infrastructure;

import java.util.List;

import javax.persistence.Query;

import org.epita.tpfacture.domaine.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl implements ClientDao {

	public void create(Client client) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(client);
		session.getTransaction().commit();
		session.close();	

	}

	public Client getClientByNom(String nom) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("SELECT c FROM Client c WHERE c.nom=:nom");
		q.setParameter("nom", nom);
		List<Client> clients = (List<Client>) q.getResultList();
		if (clients != null && clients.size() != 0) {
			return clients.get(0);
		}
		return null;
	}

}
