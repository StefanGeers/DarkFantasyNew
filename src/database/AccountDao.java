package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

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
	
	public static Player createPlayer(Account account, String sex, String name){
		Player player = new Player();
		player.setName(name);
		player.setSex(sex);
		player.setAccount(account);
		
		EntityManager em = EntityManagerManager.getPlayerEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(player); 
		
		em.find(Account.class, account.getId()).setPlayer(player);
		
		t.commit();
		em.close();
		
		return player;
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
		Account account;
		try{account = (Account) em.createQuery("select account from Account as account where username = ?1").setParameter(1, username).getSingleResult();}
		catch(NoResultException e){account = null;}
		//Account account = (Account) accounts.get(0);
		t.commit();
		em.close();
		return account;
	}
	
	@SuppressWarnings("unchecked")
	public static Account findAccountByPassword(String password, String username){
		EntityManager em = EntityManagerManager.getAccountEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Account account = null;
		List<Account> accounts = null;
		try{accounts = em.createQuery("select account from Account as account where password = ?1").setParameter(1, password).getResultList();}
		catch(NoResultException e){}
		for(int i = 0; i < accounts.size(); i++){
			if(accounts.get(i).getUsername().equals(username)){
				account = accounts.get(i);
				break;
			}
		}
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
	
	public static Player findPlayer(String username){
		EntityManager em = EntityManagerManager.getAccountEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Player player;
		try{player = (Player)em.createQuery("select player from Player as player where name = ?1").setParameter(1, username).getSingleResult();}
		catch(NoResultException e){player = null;}
		//Player player = (Player) players.get(0);
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
