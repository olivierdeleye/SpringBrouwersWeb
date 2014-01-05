package be.vdab.web;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
class IndexController {

	
	private final String BEGROETING = "groet";
	
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView index() {
		 
		 ModelAndView modelAndView = new ModelAndView("index");
		 
		switch (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)){
		case 0: case 1: case 2: case 3: case 4: case 5: 
			modelAndView.addObject(BEGROETING, "goedenacht");
		break;
	    case 6: case 7: case 8: case 9: case 10: case 11: 
			modelAndView.addObject(BEGROETING, "goedemorgen");
		break;
	    case 12: case 13: case 14: case 15: case 16: case 17: 
			modelAndView.addObject(BEGROETING, "goedemiddag");
		break;
		default:
			modelAndView.addObject(BEGROETING, "goedeavond");
		}
		
		
		return modelAndView;
	 }
}
