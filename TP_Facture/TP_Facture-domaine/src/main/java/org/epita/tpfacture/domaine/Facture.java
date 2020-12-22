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
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int numeroFacture;
	
	private double totalFacture;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<QProduitFacture> qProduitsFacture;
	
	@ManyToOne
	private Client clientFacture;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public double getTotalFacture() {
		return totalFacture;
	}

	public void setTotalFacture(double totalFacture) {
		this.totalFacture = totalFacture;
	}

	public Set<QProduitFacture> getqProduitsFacture() {
		return qProduitsFacture;
	}

	public void setqProduitsFacture(Set<QProduitFacture> qProduitsFacture) {
		this.qProduitsFacture = qProduitsFacture;
	}

	public Client getClientFacture() {
		return clientFacture;
	}

	public void setClientFacture(Client clientFacture) {
		this.clientFacture = clientFacture;
	}
	
	
}
