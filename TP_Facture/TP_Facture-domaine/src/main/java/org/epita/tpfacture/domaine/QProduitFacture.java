package org.epita.tpfacture.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QProduitFacture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int quantiteProduit;
	
	private String codeProduitFacture;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantiteProduit() {
		return quantiteProduit;
	}

	public void setQuantiteProduit(int quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}

	public String getCodeProduitFacture() {
		return codeProduitFacture;
	}

	public void setCodeProduitFacture(String codeProduitFacture) {
		this.codeProduitFacture = codeProduitFacture;
	}


}
