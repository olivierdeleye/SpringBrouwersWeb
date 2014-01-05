package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import be.vdab.contraints.Postcode;

@Embeddable
public class Adres implements Serializable{

	  private static final long serialVersionUID = 1L;
	  @NotNull
	  @Size(min = 1, max = 50, message = "{Size.tekst}")
	  private String straat;
	  
	  @NotNull
	  @Size(min = 1, max = 7, message = "{Size.tekst}")
	  private String huisNr;
	  
	  @Postcode
	  private Integer postcode;
	  
	  @NotNull
	  @Size(min = 1, max = 50, message = "{Size.tekst}")
	  private String gemeente;

	 protected Adres() {
		//default constructor voor JPA
	 }
	 
	 public Adres(String straat,String huisNr,Integer postcode,String gemeente) {
	  this.straat = straat;
	  this.huisNr = huisNr;
	  this.postcode = postcode;
	  this.gemeente = gemeente;
	 }
	 
	 
	 public String getStraat() {
		return straat;
	}


	protected void setStraat(String straat) {
		this.straat = straat;
	}


	public String getHuisNr() {
		return huisNr;
	}

	protected void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}


	public Integer getPostcode() {
		return postcode;
	}


	protected void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}


	 public String getGemeente() {
		return gemeente;
	 }


	 public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	 }

	 @Override
	 public String toString() {
	   return String.format("%s %s %s %s", straat, huisNr, postcode, gemeente);
	 }
	
}
