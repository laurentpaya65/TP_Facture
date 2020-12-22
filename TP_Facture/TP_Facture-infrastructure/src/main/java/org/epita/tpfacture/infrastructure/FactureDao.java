package org.epita.tpfacture.infrastructure;

import org.epita.tpfacture.domaine.Facture;

public interface FactureDao {

	void create(Facture facture);
	
	Facture getFactureByNumero(int numeroFacture);
	
	int getMaxNumeroFacture();
}
