package characterclasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import database.Account;

@Entity
public class Player {
	private String name;
	private Account account;
	private Long id;
	private String sex;	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}
	
	@OneToOne (mappedBy="player")
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		if(this.account==null){this.account = account;}
	}
	
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(this.name == null){this.name = name;}
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		if(this.sex == null){this.sex = sex;}
	}

}
