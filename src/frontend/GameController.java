package frontend;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import database.Account;
import database.AccountDao;

@Controller
public class GameController {
	
	@RequestMapping (value="/", method=RequestMethod.GET)
	public String DarkFantasyNew(RedirectAttributes redirectAttrs){
		if(redirectAttrs.containsAttribute("user")){
			return "welcome";	
		}
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
	public String nieuw(@ModelAttribute("Account") @Valid Account account, BindingResult result){
		if(AccountDao.findAccount(new String(account.getUsername()))!=null){
			result.addError(new FieldError("account", "username", "Username taken. Please choose a new username."));
		}
		
		if (!result.hasErrors()) {
			AccountDao.createAccount(account.getUsername(), account.getPassword());
			return "redirect:/charactercreation";
		} else {
			System.out.println("test");
			return "register";
		}
		
	}
	
	@RequestMapping(value="/frontpage", method=RequestMethod.POST)
	public String login(){
		return "redirect:/welcome";
	}
	
	@ModelAttribute("Account")
	public Account retrieveAccount(){
		return new Account();
	}

}
