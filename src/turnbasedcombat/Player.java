package turnbasedcombat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import database.Account;
import items.Sword;
import items.Weapon;
import characterclasses.Character;

public class Player extends Character{
	private String playerName;
	private Account account;
	private Long id;
	private String sex;
	
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
	
	private void setPlayerName(String PC_name) {
		this.playerName = PC_name;
	}
	
	@Override
	public void setName(String name){
		this.playerName = name;
	}

	@Override
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

	public Account getAccount(){
		return account;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
