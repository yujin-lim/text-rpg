package units;

public abstract class Monster {

	private StringBuffer buffer = new StringBuffer();
	
	private String name;
	private int hp;
	private int maxhp;
	private int power;

	Monster() {

	}

	Monster(String name, int max , int power){
		this.name = name;
		this.hp = max;
		this.maxhp = max;
		this.power = power;
	}
	
	public void init(String name, int hp, int power) {
		this.name = name;
		this.hp = hp;
		this.power = power;
	}
	
	public void attack (Unit unit) {
		target.hp -= (power = target.damages);
		
		buffer.append("====================");
		buffer.append("["+name+"] [" +target.name+ "에게" + (power-target.damages)+ "의 상처를 입힙니다.]");
		if(target.hp <= 0) {
			buffer.append("[" + target.name + "을 제거했습니다]");
			target.hp = 0;
		}
	}
	
	public void printData() {
		buffer.append("["+ name +"]/["+ hp +  "/ "  +  maxhp +"]");
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

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	
}
