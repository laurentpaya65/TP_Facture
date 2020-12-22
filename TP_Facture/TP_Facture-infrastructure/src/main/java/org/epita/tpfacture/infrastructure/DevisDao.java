package org.epita.tpfacture.infrastructure;

import org.epita.tpfacture.domaine.Devis;

public interface DevisDao {
	
	void create(Devis devis);
	
	Devis getByNumeroDevis(int numeroDevis);

}
