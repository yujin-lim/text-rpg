package units;

import java.util.Random;
import java.util.Vector;

public class UnitManager {

	public static UnitManager instance = new UnitManager();
	private Random ran = new Random();
	
	Vector<Player>playerlist = new Vector<Player>();
	public Vector<Monster>monsterlist = new Vector<Monster>();
	
	String monsters[] = { "Wolf", "Oak", "Golem"};
	
	public Player player;
	
	public void init () {
		Player.init();
	}
 	
	public void random_monster_set(int size) {
		for(int i = 0; i < size; i ++) {
			int ranIdx = ran.nextInt(monsters.length);
			
			try {
				Class<?>clazz = Class.forName(monsters[ranIdx]);
				
				Object obj  = clazz;
				Monster temp = (Monster) obj;
				String name = null;
				int hp = ran.nextInt(100)+100;
				int power = ran.nextInt(100)+100;
				temp.init(name,hp,power);
				monsterlist.add(temp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	public void Guild() {
		// TODO Auto-generated method stub
		
	}

	public void Inventory() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
