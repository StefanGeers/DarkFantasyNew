package frontend;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import characterclasses.Player;
import database.Account;
import database.AccountDao;

@Controller
public class GameController {
	
	@RequestMapping (value="/", method=RequestMethod.GET)
	public String DarkFantasyNew(Model model, HttpSession s){
		if(SessionCheck(s)){return "welcome";}
		else {return "frontpage";}
	}
	
	@RequestMapping (value="/register", method=RequestMethod.GET)
	public String Register(){
		return "register";
	}
	
	@RequestMapping (value="/logout", method=RequestMethod.GET)
	public String Logout(HttpSession s){
		if(s != null){
			s.invalidate();
		}
		return "redirect:/";
	}
	
	@RequestMapping (value="/login", method=RequestMethod.GET)
	public String Login(Model model, HttpSession s){
		if(SessionCheck(s)){
			return "welcome";
		} else {return "redirect:/";}
	}
	
	@RequestMapping (value="/welcome", method=RequestMethod.GET)
	public String Welcome(Model model, HttpSession s){
		if(!SessionCheck(s)){ return "redirect:/";}
		Account a = (Account)s.getAttribute("account");
		if(a.getPlayer() == null){
			return "redirect:/charactercreation";
		}
		return "redirect:/";
	}
	
	@RequestMapping (value="/charactercreation", method=RequestMethod.GET)
	public String CharacterCreation(Model model, HttpSession s){
		if(SessionCheck(s)){return "charactercreation";}
		else{return "redirect:/";}
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
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String login(@ModelAttribute("Account") @Valid Account account, BindingResult result, Model model, HttpSession session){
		
		Account accountpw = AccountDao.findAccountByPassword(new String(account.getPassword()),new String(account.getUsername()));
		if(accountpw == null){
			result.addError(new FieldError("account", "username", "No account found with that username/password combination."));
		}
		if (!result.hasErrors()) {
			session.setAttribute("account", accountpw);
			model.addAttribute(accountpw);
			return "redirect:/welcome";
		} else {
			System.out.println("test");
			return "frontpage";
		}
	}
	
	@RequestMapping (value="/charactercreation", method=RequestMethod.POST)
	public String CharacterCreated(@ModelAttribute("Player") @Valid Player player, BindingResult result, HttpSession s){
		if(!SessionCheck(s)){return "redirect:/";}
		
		if(player.getName() == null){
			result.addError(new FieldError("player", "name", "No character name entered. Please choose a name for your character."));
		}
		if(player.getSex() == null){
			result.addError(new FieldError("player", "sex", "No sex entered. Please choose a sex for your character."));
		}
		
		if(result.hasErrors()){return "redirect:/charactercreation";}
		
		Account a = (Account) s.getAttribute("account");
		if(a.getPlayer()!=null){return "redirect:/";}
		AccountDao.createPlayer(a, player.getName(), player.getSex());
		s.setAttribute("Player", player);
		return "redirect:/welcome";
	}
	
	@ModelAttribute("Account")
	public Account retrieveAccount(){
		return new Account();
	}
	
	@ModelAttribute("Player")
	public Player retrievePlayer(){
		return new Player();
	}
	
	private boolean SessionCheck(HttpSession s){
		try{ if(s == null || s.getAttribute("account").equals(null)){
			return false;	
			}
		} catch (NullPointerException e){ return false;}
		return true;
	}
	
	@RequestMapping (value="/map", method=RequestMethod.GET)
	public String Map(){
		return "map";
	}
	@RequestMapping (value="/CombatRuins", method=RequestMethod.GET)
	public String CombatRuins(){
		return "CombatRuins";
	}

}
