package org.epita.tpfacture.infrastructure;

import javax.persistence.Query;

import org.epita.tpfacture.domaine.Devis;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DevisDaoImpl implements DevisDao {

	public void create(Devis devis) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(devis);
		session.getTransaction().commit();
		session.close();

	}

	public Devis getByNumeroDevis(int numeroDevis) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("SELECT d FROM Devis d WHERE d.numeroDevis = :numeroDevis");
		q.setParameter("numeroDevis", numeroDevis);
		Devis devis = (Devis) q.getSingleResult();
		return devis;
	}


}
