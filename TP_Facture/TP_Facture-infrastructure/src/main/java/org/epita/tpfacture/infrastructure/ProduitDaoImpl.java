package org.epita.tpfacture.infrastructure;

import java.util.List;

import javax.persistence.Query;

import org.epita.tpfacture.domaine.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProduitDaoImpl implements ProduitDao {

	public void create(Produit produit) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(produit);
		session.getTransaction().commit();
		session.close();	

	}
	
	public Produit getProduitByCode(String codeProduit) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("SELECT p FROM Produit p WHERE p.codeProduit=:codeProduit");
		q.setParameter("codeProduit", codeProduit);
		List<Produit> produits = (List<Produit>)q.getResultList();
		session.close();
		if (produits != null && produits.size() != 0 ) {
			return produits.get(0);
		}
		return null;
	}

}
