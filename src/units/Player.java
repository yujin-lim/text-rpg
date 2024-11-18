package units;

public class Player extends Unit{
	
	static Guild guild = new Guild();
	static Inventory inventory = new Inventory();
	static int money = 100000;
	
	public Player() {
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

}
