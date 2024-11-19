package units;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import textrpg.Item;

abstract public class Unit {
	ArrayList<Item>itemlist = new ArrayList<>();
	
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(System.out));
	private BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	

	private String name;
	private int hp;
	private int maxhp;
	private int mp;
	private int power;
	private int shield;
	private int skill;
	private boolean party;
	private int weapon;
	private int armor;
	private int potion;
	
    public Unit (){}

	public Unit(String name, int hp, int maxhp, int mp, int power, int shield, int skill, boolean party,int weapon, int armor, int potion) {
		super();
		this.name = name;
		this.hp = hp;
		this.maxhp = maxhp;
		this.mp = mp;
		this.power = power;
		this.shield = shield;
		this.skill = skill;
		this.party = party;
		this.weapon = weapon;
		this.armor = armor;
		this.potion= potion;
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
	
	public Unit (int weapon, int armor, int potion) {
		super();
		this.weapon = weapon;
		this.armor = armor;
		this.potion= potion;
	}
	public int getWeapon() {
		return weapon;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getPotion() {
		return potion;
	}

	public void setPotion(int potion) {
		this.potion = potion;
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
	
	
	public void printStatus() {
		buffer.append("[이름 : " + name + "]");
		
		for(int i = 0; i < Player.getItemSize(); i ++) {
			if(Player.inventory.itemlist.get(getWeapon()) == null) {
				buffer.append("[무기  :  없음] ");
			}
			else {
				buffer.append("[무기  : " +  Player.inventory.itemlist.get(getWeapon()) + "]");
				buffer.append("[무기 공격력 증감: " +  Player.inventory.itemlist.get(getWeapon()).getPower() + "]");
			}
		}
		for(int i = 0; i < Player.getItemSize(); i ++) {
			if(Player.inventory.itemlist.get(getArmor()) == null) {
				buffer.append("[갑옷  :  없음] ");
			}
			else {
				buffer.append("[갑옷  : " +  Player.inventory.itemlist.get(getArmor()) + "]");
				buffer.append("[갑옷 공격력 증감: " +  Player.inventory.itemlist.get(getArmor()).getPower() + "]");
			}
		}
		for(int i = 0; i < Player.getItemSize(); i ++) {
			if(Player.inventory.itemlist.get(getPower()) == null) {
				buffer.append("[포션  :  없음] ");
			}
			else {
				buffer.append("[포션  : " +  Player.inventory.itemlist.get(getPotion()) + "]");
				buffer.append("[포션 공격력 증감: " +  Player.inventory.itemlist.get(getPotion()).getPower() + "]");
			}
		}
	}
	
	public void attack (Monster target) {
		target.setHp(target.getHp() -= attack);
		buffer.append("=====================");
		buffer.append("[" + name + "]가 [ "+ target.getName()+"에게 " + attack + "데미지를 입힙니다.");
		if(target.getHp() <= 0) {
			buffer.append("[" + target.getName() + "]을 처치했습니다.");
			target.setHp(target.getHp() == 0);
		}
	}
	
	public void printData() {
		buffer.append("[" + name + "]/[" + hp + "/ " + maxhp + "]/[" + attack + " ]");
	}

}
