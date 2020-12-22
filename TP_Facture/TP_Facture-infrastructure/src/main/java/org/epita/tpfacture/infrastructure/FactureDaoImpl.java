package org.epita.tpfacture.infrastructure;

import java.util.List;

import javax.persistence.Query;

import org.epita.tpfacture.domaine.Facture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class FactureDaoImpl implements FactureDao {

	public void create(Facture facture) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(facture);
		session.getTransaction().commit();
		session.close();

	}

	public Facture getFactureByNumero(int numeroFacture) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("SELECT f FROM Facture f WHERE f.numeroFacture=:numeroFacture");
		q.setParameter("numeroFacture", numeroFacture);
		List<Facture> factures = q.getResultList();
		session.close();
		if (factures != null && factures.size() != 0) {
			return factures.get(0);
		}
		return null;
	}

	public int getMaxNumeroFacture() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("SELECT MAX(f.numeroFacture) FROM Facture f ");
		Integer max = (Integer) q.getSingleResult();
		session.close();
		return max+1;
	}

}
