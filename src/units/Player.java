package units;

import java.util.ArrayList;
import java.util.Vector;

import textrpg.Item;

public class Player extends Unit{
	
	static Guild guild = new Guild();
	public static Inventory inventory = new Inventory();
	static int money = 100000;
	

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}

	public Player(String name, int hp, int mp, int power, int shield, int skill) {
		super(name, hp, mp, power, shield, skill);
	}

	public Player(String name, int hp, int mp, int power, int shield, int skill, boolean party) {
		super(name, hp, mp, power, shield, skill, false);
	}

	public static void init() {
		money = 100000;
		guild.setGuild();

	}

	@Override
	public void attack(Unit unit) {
		// TODO Auto-generated method stub
		
	}

	public void printAllUnit() {
		// TODO Auto-generated method stub
		
	}

	public void pritnAllUnitItem() {
		// TODO Auto-generated method stub
		
	}

	public static Object getGuildUnit(int sel) {
		// TODO Auto-generated method stub
		return null;
	}

	
	void skill() {

	  }

	  // 길드 메뉴 메서드
	  public void guildMenu() {
	    guild.printGuidMenu();
	  }

	  // 인벤토리 메뉴 메서드
	  public void inventoryMenu() {
	    inventory.inventoryMenu();
	  }

	  // 길드 리스트 반환 메서드
	  static public Vector<Player> getGuildList() {
	    return guild.guildlist;
	  }

	  // 아이템 리스트 반환 메서드
	  static public ArrayList<Item> getItemlist() {
	    return inventory.itemlist;
	  }

	  // 길드원 반환 메서드
	  static public Player GetGuildUnit(int num) {
	    return guild. GetGuildUnit(num);
	  }

	  // 길드 크기 반환 메서드
	  static public int getGuildSize() {
	    return guild.guildlist.size();
	  }

	  // 아이템 크기 반환 메서드
	  static public int getItemSize() {
	    return inventory.itemlist.size();
	  }

	public void attack(Monster monster) {
		// TODO Auto-generated method stub
		
	}

	public void printData() {
		// TODO Auto-generated method stub
		
	}

}
