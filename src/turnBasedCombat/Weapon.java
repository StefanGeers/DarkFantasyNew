package turnBasedCombat;

import java.util.ArrayList;

public class Weapon {
	private String name;
	
	private int slashDMG;
	private int bashDMG;
	private int pierceDMG;
	private ArrayList<String> dmgType;
	
	public ArrayList<String> getDmgType() {
		return dmgType;
	}

	public void setDmgType(ArrayList<String> dmgType) {
		this.dmgType = dmgType;
	}

	public Weapon(String name, int slashDMG, int bashDMG, int pierceDMG){
		name = name;
		slashDMG = slashDMG;
		bashDMG = bashDMG;
		pierceDMG = pierceDMG;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSlashDMG() {
		return slashDMG;
	}

	public void setSlashDMG(int slashDMG) {
		this.slashDMG = slashDMG;
	}

	public int getBashDMG() {
		return bashDMG;
	}

	public void setBashDMG(int bashDMG) {
		this.bashDMG = bashDMG;
	}

	public int getPierceDMG() {
		return pierceDMG;
	}

	public void setPierceDMG(int pierceDMG) {
		this.pierceDMG = pierceDMG;
	}
	
	
	
}
