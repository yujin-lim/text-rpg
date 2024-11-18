package textrpg;

public class Item {

	static final int WEAPON = 1;
	static final int ARMOR = 2;
	static final int POTION = 3;

	private int kind;
	private String name;
	private int price;
	private int power;
	
	public void setItem(int k, String n, int pr, int po) {
		k = kind;
		n = name;
		pr = price;
		po = power;
	}
	
}
