package textrpg;

public class Item {

	static final int WEAPON = 1;
	static final int ARMOR = 2;
	static final int POTION = 3;

	private int kind;
	private String name;
	private int price;
	private int power;
	
	public Item(int k, String n, int pr, int po) {
		kind = k;
		name = n;
		price = pr;
		power = po;
	}
	
	public void setItem(int k, String n, int pr, int po) {
		kind = k;
		name = n;
		price = pr;
		power = po;
	}
	
	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public static int getWeapon() {
		return WEAPON;
	}

	public static int getArmor() {
		return ARMOR;
	}

	public static int getPotion() {
		return POTION;
	}
	
	
	
}
