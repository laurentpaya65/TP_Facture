package org.epita.tpfacture.application;

import org.epita.tpfacture.domaine.Facture;

public interface FactureService {
	
	void create(Facture facture);
	
	String sortirFacture(int numeroFacture);

}
