package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import characterclasses.Player;

public class AccountDao {

	/**
	 * Maak een nieuwe Account aan en sla die op in de database
	 */
	public static Account create(String username, String password, Long id){
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		account.setId(id);
		
		EntityManager em = EntityManagerManager.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(account);

		t.commit();
		em.close();
		
		return account;
	}
	
	/**
	 * Maak een nieuwe character en koppel die aan het account
	 */
	
	public static void addPlayer(Account account, Player player){
		account.setPlayer(player);
		player.setAccount(account);
	}
	
	/**
	 * Verwijder een account uit de database
	 */
	public static void remove(Long id){
		EntityManager em = EntityManagerManager.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Account account = em.find(Account.class, id);
		if(account != null){
			em.remove( account );
		}
		t.commit();
		em.close();
	}
	
	/**
	 * Haal een account op a.d.h.v. zijn id
	 */
	
	public static Account find(Long id){
		EntityManager em = EntityManagerManager.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Account account = em.find(Account.class, id);
		t.commit();
		em.close();
		return account;
	}
	
	/**
	 * Haal alle accounts op uit de database
	 */
	public static List<Account> all(){
		EntityManager em = EntityManagerManager.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<Account> accounts = em.createQuery("from Account", Account.class).getResultList();
		t.commit();
		em.close();
		return accounts;
	}
}
