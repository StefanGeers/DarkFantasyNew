package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import characterclasses.Player;

public class AccountDao {

	/**
	 * Maak een nieuwe Account aan en sla die op in de database
	 */
	public static Account createAccount(String username, String password){
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		
		EntityManager em = EntityManagerManager.getAccountEntityManager();
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
		EntityManager em = EntityManagerManager.getAccountEntityManager();
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
	
	public static Account findAccount(Long id){
		EntityManager em = EntityManagerManager.getAccountEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Account account = em.find(Account.class, id);
		t.commit();
		em.close();
		return account;
	}
	
	public static Account findAccount(String username){
		EntityManager em = EntityManagerManager.getAccountEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		//Query query = em.createQuery("SELECT * FROM darkfantasy.account WHERE username=" + username);
		Account account = (Account) em.f;
		t.commit();
		em.close();
		return account;
	}
	
	public static Player findPlayer(Long id){
		EntityManager em = EntityManagerManager.getPlayerEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Player player = em.find(Player.class, id);
		t.commit();
		em.close();
		return player;
	}
	
	/**
	 * Haal alle accounts op uit de database
	 */
	public static List<Account> allAccounts(){
		EntityManager em = EntityManagerManager.getAccountEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<Account> accounts = em.createQuery("from Account", Account.class).getResultList();
		t.commit();
		em.close();
		return accounts;
	}
	
	public static List<Player> allPlayers(){
		EntityManager em = EntityManagerManager.getPlayerEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<Player> players = em.createQuery("from Player", Player.class).getResultList();
		t.commit();
		em.close();
		return players;
	}
}
