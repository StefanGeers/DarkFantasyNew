package frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import database.AccountDao;

@Controller
public class GameController {
	
	@RequestMapping (value="/", method=RequestMethod.GET)
	public String DarkFantasyNew(){
		return "frontpage";
	}
	
	@RequestMapping (value="/register", method=RequestMethod.GET)
	public String Register(){
		return "register";
	}
	
	@RequestMapping (value="/login", method=RequestMethod.GET)
	public String Login(RedirectAttributes redirectAttrs){
		if(redirectAttrs.containsAttribute("user")){
			return "welcome";	
		}
		return "frontpage";
	}
	
	@RequestMapping (value="/welcome", method=RequestMethod.GET)
	public String Welcome(RedirectAttributes redirectAttrs){
		if(redirectAttrs.containsAttribute("user")){
			return "welcome";	
		}
		return "frontpage";
	}
	
	@RequestMapping (value="/charactercreation", method=RequestMethod.GET)
	public String CharacterCreation(){
		return "charactercreation";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String nieuw(String username, String password){
		AccountDao.createAccount(username, password);
		return "redirect:/charactercreation";
	}

}
