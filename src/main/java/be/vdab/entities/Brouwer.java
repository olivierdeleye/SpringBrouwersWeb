package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name="brouwers")
public class Brouwer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
    private long brouwerNr;
    
    @NotNull
	@Size(min = 1, max = 50, message = "{Size.tekst}")
    private String naam;
    
    @NumberFormat(style = Style.NUMBER) 
	@NotNull
	@Min(0)
    private Integer omzet;
    
    @Valid
    @Embedded
    private Adres adres;
    
    public Brouwer() { //nodig om command object te kunnen maken
    }
    
    public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
		setBrouwerNr(brouwerNr);
		setNaam(naam);
		setOmzet(omzet);
		setAdres(adres);
	}
    
    public Brouwer (String naam, Integer omzet, Adres adres) {
    	setNaam(naam);
		setOmzet(omzet);
		setAdres(adres);
    	
    }

	public long getBrouwerNr() {
		return brouwerNr;
	}

	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
    
    
    
	
}
