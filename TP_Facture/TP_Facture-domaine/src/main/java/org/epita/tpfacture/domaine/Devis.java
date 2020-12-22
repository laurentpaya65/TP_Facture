package org.epita.tpfacture.domaine;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Devis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int numeroDevis;
	
	private double totalDevis;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Client clientDevis;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<QProduitDevis> qProduitsDevis;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumeroDevis() {
		return numeroDevis;
	}

	public void setNumeroDevis(int numeroDevis) {
		this.numeroDevis = numeroDevis;
	}

	public double getTotalDevis() {
		return totalDevis;
	}

	public void setTotalDevis(double totalDevis) {
		this.totalDevis = totalDevis;
	}

	public Client getClientDevis() {
		return clientDevis;
	}

	public void setClientDevis(Client clientDevis) {
		this.clientDevis = clientDevis;
	}

	public Set<QProduitDevis> getqProduitsDevis() {
		return qProduitsDevis;
	}

	public void setqProduitsDevis(Set<QProduitDevis> qProduitsDevis) {
		this.qProduitsDevis = qProduitsDevis;
	}
	
	

}
