package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Service
@Transactional(readOnly = true) 
class BrouwerServiceImpl implements BrouwerService {

	private final BrouwerDAO brouwerDAO;
	
	@Autowired 
	public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO = brouwerDAO;
	}
	
	//CREATE
	@Override
	@Transactional(readOnly = false)
	public void create(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
		
	}

	//FINDALL
	@Override
	public Iterable<Brouwer> findAll() {
		return brouwerDAO.findAll();
	}

	//FIND BY NAAM DIE BEGINT MET
	@Override
	public Iterable<Brouwer> findByNaamStartingWith(String beginNaam) {
		return brouwerDAO.findByNaamStartingWith(beginNaam);
	}
    
	//FIND BY NAAM
	@Override
	public Iterable<Brouwer> findByNaam(String Naam) {
		return brouwerDAO.findByNaamStartingWith(Naam);
	}
	
	//FIND AANTAL BROUWERS
	@Override
	public long findAantalBrouwers() {
		return brouwerDAO.count();
	}
	
	//READ
	@Override
	public Brouwer read(long brouwerNr) {
		return brouwerDAO.findOne(brouwerNr);
	}
	
	//UPDATE
	@Override
	@Transactional(readOnly = false)
	public void update(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
		
	}
	
	//DELETE
	@Override
	@Transactional(readOnly = false)
	public void delete(long brouwerNr) {
		brouwerDAO.delete(brouwerNr);
		
	}

}
