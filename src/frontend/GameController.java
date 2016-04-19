package frontend;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import database.Account;
import database.AccountDao;

@Controller
public class GameController {
	
	@RequestMapping (value="/", method=RequestMethod.GET)
	public String DarkFantasyNew(Model model, HttpSession s){
		try{ if(s == null || s.getAttribute("account").equals(null)){
				return "frontpage";	
			}
		} catch (NullPointerException e){ return "frontpage";}
		return "welcome";
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
		try{ if(s == null || s.getAttribute("account").equals(null)){
				return "redirect:/";	
			}
		} catch (NullPointerException e){ return "redirect:/";}
		return "welcome";
	}
	
	@RequestMapping (value="/welcome", method=RequestMethod.GET)
	public String Welcome(Model model, HttpSession s){
		try{ if(s == null || s.getAttribute("account").equals(null)){
				return "redirect:/";	
			}
		} catch (NullPointerException e){ return "redirect:/";}
		return "welcome";
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
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String login(@ModelAttribute("Account") @Valid Account account, BindingResult result, Model model, HttpSession session){
		Account accountpw = AccountDao.findAccountByPassword(new String(account.getPassword()),new String(account.getUsername()));
		if(accountpw.equals(null)){
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
	
	@ModelAttribute("Account")
	public Account retrieveAccount(){
		return new Account();
	}

}
