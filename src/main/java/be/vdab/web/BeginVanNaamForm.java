package be.vdab.web;

import javax.validation.constraints.Size;

class BeginVanNaamForm {

	@Size(max=50, message="{Size.tekst}")
	private String naam;
	
	BeginVanNaamForm() {
		
	}
	
    BeginVanNaamForm(String naam) {
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	@Override
	public String toString() {
		
		return naam;
	}
	
	
}
