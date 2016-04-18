package database;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountRegistratie {

	/**
	 * Toon een overzicht van alle accounts
	 */
	@RequestMapping("/")
	public String overzicht(Model model) {
		model.addAttribute("accounts", AccountDao.allAccounts());
		return "frontpage";
	}
	
	/**
	 * Toon een detail-view van een enkele account
	 */
	@RequestMapping(value="/account/{id}")
	public String detailView(@PathVariable String id, Model model){
		Long key;
		try{
			key = Long.valueOf(id);
		}
		catch(NumberFormatException e){
			// id is geen getal? error 404
			return null;
		}
		Account account = AccountDao.findAccount(key);
		if(account == null){
			// geen account met gegeven id? error 404
			return null;
		} else {
			model.addAttribute("account", account);
			return "detail";
		}
	}
	
	
	/**
	 * Verwijdert gegeven account -- zonder om bevestiging te vragen ;)
	 */
	@RequestMapping(value="/delete/{id}")
	public String deleteView(@PathVariable String id){
		Long key;
		try{
			key = Long.valueOf(id);
		}
		catch(NumberFormatException e){
			// id is geen getal? error 404
			return null;
		}

		AccountDao.remove(key);
		return "redirect:/";
	}
	
	
	/*@RequestMapping(value="/register", method=RequestMethod.POST)
	public String nieuw(String username, String password){
		AccountDao.create(username, password);
		return "redirect:/charactercreation";
	}*/
	
	
}
