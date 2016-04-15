package characterclasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import database.Account;
import items.Sword;
import items.Weapon;

@Entity
public class Player extends Character{
	private String playerName;
	private Account account;
	private Long id;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}
	
	public Player(){super();}
	
	public Weapon Weapon = new Sword("sword", 40, 10, 25);

	public Player(String PC_name, int maxHealth, int currentHealth, int damageDealing){
		super(maxHealth, currentHealth);
		setPlayerName(PC_name);
		setDamage(damageDealing);
		setProfession("yourself");
	}
	
	public void setPlayerName(String name){
		this.playerName = name;
	}

	public String getName(){
		return this.playerName;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	public Account getAccount(){
		return account;
	}
}
