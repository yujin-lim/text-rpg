package units;

abstract public class Unit {

	private String name;
	private int hp;
	private int maxhp;
	private int mp;
	private int power;
	private int shield;
	private int skill;
	private boolean party;
	private int WEAPON;
	private int ARMOR;
	private int POTION;
	
    public Unit (){}

	public Unit(String name, int hp, int maxhp, int mp, int power, int shield, int skill, boolean party,int WEAPON, int ARMOR, int POTION) {
		super();
		this.name = name;
		this.hp = hp;
		this.maxhp = maxhp;
		this.mp = mp;
		this.power = power;
		this.shield = shield;
		this.skill = skill;
		this.party = party;
		this.WEAPON = WEAPON;
		this.ARMOR = ARMOR;
		this.POTION = POTION ;
	}
	
	public Unit(String name, int hp, int mp, int power, int shield, int skill) {
		super();
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.power = power;
		this.shield = shield;
		this.skill = skill;
	}
	
	public Unit(String name, int hp, int mp, int power, int shield, int skill, boolean party) {
		super();
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.power = power;
		this.shield = shield;
		this.skill = skill;
		this.party = party;
	}
	
	public Unit (int WEAPON, int ARMOR, int POTION) {
		super();
		this.WEAPON = WEAPON;
		this.ARMOR = ARMOR;
		this.POTION = POTION ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxhp() {
		return maxhp;
	}
	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public abstract void attack (Unit unit);
	
}
