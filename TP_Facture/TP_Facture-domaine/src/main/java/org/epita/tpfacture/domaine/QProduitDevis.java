package org.epita.tpfacture.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QProduitDevis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int quantiteDevis;
	
	private String codeProduitDevis;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantiteDevis() {
		return quantiteDevis;
	}

	public void setQuantiteDevis(int quantiteDevis) {
		this.quantiteDevis = quantiteDevis;
	}

	public String getCodeProduitDevis() {
		return codeProduitDevis;
	}

	public void setCodeProduitDevis(String codeProduitDevis) {
		this.codeProduitDevis = codeProduitDevis;
	}

}
