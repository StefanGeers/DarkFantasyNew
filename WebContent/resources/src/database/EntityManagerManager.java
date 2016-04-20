package database;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

@WebListener
public class EntityManagerManager implements ServletContextListener, ServletContainerInitializer {

	private static EntityManagerFactory emfa; 
	private static EntityManagerFactory emfp;
	
	private static EntityManagerFactory getEMFA(){
		if(emfa == null){
			emfa = Persistence.createEntityManagerFactory("accounts");
		}
		return emfa;
	}
	
	private static EntityManagerFactory getEMFP(){
		if(emfp == null){
			emfp = Persistence.createEntityManagerFactory("players");
		}
		return emfp;
	}
	
	public static EntityManager getAccountEntityManager(){
		return getEMFA().createEntityManager();
	}
	
	public static EntityManager getPlayerEntityManager(){
		return getEMFP().createEntityManager();
	}
	
	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext arg1) throws ServletException {}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if(emfa != null){
			System.out.println("Closing AccountManagerFactory");
			emfa.close();
		}
		if(emfp != null){
			System.out.println("Closing PlayerManagerFactory");
			emfp.close();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
