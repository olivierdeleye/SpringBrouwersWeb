package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {

	private final BrouwerService brouwerService;
	private final char[] alfabet;
	
	@Autowired 
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		alfabet = new char[('Z'-'A') + 1];
		for(char letter='A';letter <= 'Z';letter++) {
			alfabet[letter - 'A'] = letter;
		}
		
	}
	
	@RequestMapping(value = "brouwersopalfabet", method = RequestMethod.GET)
	public ModelAndView brouwersOpAlfabetLinks() {
		
		return new ModelAndView("brouwers/brouwersopalfabet","alfabet",alfabet);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "letter")
	public ModelAndView brouwersOpAlfabetResults(@RequestParam String letter) {
		ModelAndView modelAndView = new ModelAndView("brouwers/brouwersopalfabet","brouwers",brouwerService.findByNaamStartingWith(letter));
		modelAndView.addObject("alfabet", alfabet);
		return modelAndView;
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView findAll() {
		return new ModelAndView("brouwers/brouwers","brouwers",brouwerService.findAll());
	}
	
	@RequestMapping(value="brouwersopnaam", method = RequestMethod.GET)
	public ModelAndView brouwersOpNaam() {
		 ModelAndView modelAndView = new ModelAndView("brouwers/brouwersopnaam");
		 modelAndView.addObject("beginVanNaamForm", new BeginVanNaamForm("Olivier"));
		 return modelAndView;
	}
	
	@RequestMapping(value="brouwersopnaam", method = RequestMethod.GET, params="naam")
	public ModelAndView brouwersOpNaam(@Valid BeginVanNaamForm beginVanNaamForm, BindingResult bindingResult) {
		 ModelAndView modelAndView = new ModelAndView("brouwers/brouwersopnaam");
		 if ( ! bindingResult.hasErrors()) {
			 modelAndView.addObject("brouwers", brouwerService.findByNaam(beginVanNaamForm.getNaam()));
		 }
		 return modelAndView;
	}
	
	//LEGE FORM OM BROUWER TOE TE VOEGEN
	@RequestMapping(value= "toevoegen", method = RequestMethod.GET)
	public ModelAndView createForm() {
		return new ModelAndView("brouwers/toevoegen","brouwer",new Brouwer());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String create( @Valid Brouwer brouwer,BindingResult bindingResult) {
		if( ! bindingResult.hasErrors()){
		    brouwerService.create(brouwer);
		    return "redirect:/";
		}
		return "brouwers/toevoegen";
	}
	
	//VALIDATIE INVOERVAKKEN BROUWER
	@InitBinder("brouwer") //naam van de form
	public void initBinderBrouwer(DataBinder dataBinder) { 
	 Brouwer brouwer = (Brouwer)dataBinder.getTarget(); // geeft command object als type Object
	 if (brouwer.getAdres() == null) { // bij creatie van nieuw filiaal is adres null
		brouwer.setAdres(new AdresForm());
	 }
	 else {
		brouwer.setAdres(new AdresForm(brouwer.getAdres()));
	 }
	}
}
