package be.vdab.services;

import be.vdab.entities.Brouwer;

public interface BrouwerService {

	void create(Brouwer brouwer);
	Brouwer read(long brouwerNr);
	void update(Brouwer brouwer);
	void delete(long brouwerNr);
	Iterable<Brouwer> findAll();
	Iterable<Brouwer> findByNaamStartingWith(String beginNaam);
	Iterable<Brouwer> findByNaam(String naam);
	long findAantalBrouwers();
	
}
