package org.epita.tpfacture.application;

import org.epita.tpfacture.domaine.Devis;

public interface DevisService {

	void create(Devis devis);
	
//	Devis getByNumeroDevis(int numeroDevis);
	
	String sortirDevis(int numeroDevis);
	
	int transformDevisEnFacture(int numeroDevis);
}
