package characterclasses;

import java.util.ArrayList;

public class Character {

	//general stats (for story purposes mostly)
	private String name;
	private String profession;
	private String thoughtDescription;
	private String armorDescription;
	private int mana;


	//Offensive stats
	private int damage;
	private ArrayList<String> dmgType;
	private String attackDescription;
	
	//Defensive stats
	private int maxHP;
	private int currentHP;
	private int dodge;
	private int parry;
	
	//armor resistance
	private double piercingRes, bashingRes, slashingRes, blastRes;
	
	//elemental resistance
	private double fireRes, elecRes, iceRes, earthRes, darkRes, holyRes, natureRes, spiritRes;
	
	public Character(int maxHealth, int currentHealth){
		maxHP = maxHealth;
		currentHP = currentHealth;
		//sets all resistance multipliers to 1.0
		piercingRes = bashingRes = slashingRes = blastRes = fireRes = elecRes = iceRes = earthRes = darkRes = holyRes = natureRes = spiritRes = 1.0;
	}
	
	//getter en setter functies start here
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public ArrayList<String> getDmgType() {
		return dmgType;
	}
	public void setDmgType(ArrayList<String> dmgType) {
		this.dmgType = dmgType;
	}
	public String getAttackDescription() {
		return attackDescription;
	}
	public void setAttackDescription(String attackDescription) {
		this.attackDescription = attackDescription;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public int getDodge() {
		return dodge;
	}
	public void setDodge(int dodge) {
		this.dodge = dodge;
	}
	public int getParry() {
		return parry;
	}
	public void setParry(int parry) {
		this.parry = parry;
	}
	public double getPiercingRes() {
		return piercingRes;
	}
	public void setPiercingRes(double piercingRes) {
		this.piercingRes = piercingRes;
	}
	public double getBashingRes() {
		return bashingRes;
	}
	public void setBashingRes(double bashingRes) {
		this.bashingRes = bashingRes;
	}
	public double getSlashingRes() {
		return slashingRes;
	}
	public void setSlashingRes(double slashingRes) {
		this.slashingRes = slashingRes;
	}
	public double getBlastRes() {
		return blastRes;
	}
	public void setBlastRes(double blastRes) {
		this.blastRes = blastRes;
	}
	public double getFireRes() {
		return fireRes;
	}
	public void setFireRes(double fireRes) {
		this.fireRes = fireRes;
	}
	public double getElecRes() {
		return elecRes;
	}
	public void setElecRes(double elecRes) {
		this.elecRes = elecRes;
	}
	public double getIceRes() {
		return iceRes;
	}
	public void setIceRes(double iceRes) {
		this.iceRes = iceRes;
	}
	public double getEarthRes() {
		return earthRes;
	}
	public void setEarthRes(double earthRes) {
		this.earthRes = earthRes;
	}
	public double getDarkRes() {
		return darkRes;
	}
	public void setDarkRes(double darkRes) {
		this.darkRes = darkRes;
	}
	public double getHolyRes() {
		return holyRes;
	}
	public void setHolyRes(double holyRes) {
		this.holyRes = holyRes;
	}
	public double getNatureRes() {
		return natureRes;
	}
	public void setNatureRes(double natureRes) {
		this.natureRes = natureRes;
	}
	public double getSpiritRes() {
		return spiritRes;
	}
	public void setSpiritRes(double spiritRes) {
		this.spiritRes = spiritRes;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getThoughtDescription() {
		return thoughtDescription;
	}

	public void setThoughtDescription(String thoughtDescription) {
		this.thoughtDescription = thoughtDescription;
	}

	public String getArmorDescription() {
		return armorDescription;
	}

	public void setArmorDescription(String armorDescription) {
		this.armorDescription = armorDescription;
	}
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
}
