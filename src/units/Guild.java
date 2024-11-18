package units;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Vector;

public class Guild {
	
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
	private Random ran = new Random();
	
	private final int party_Size = 2;
	public Vector<Player>guildlist = new Vector<>();
	public Unit [] partyList;
	
	public void setGuild() {
		guildlist.add(new Player("전사", 300, 100, 100, 100, 2));
		guildlist.add(new Player("마법사", 250, 200, 150, 100, 3));

		for (int i = 0; i < party_Size; i++) {
			guildlist.get(i).party = true;
		}
		partyList = new Unit[party_Size];

		int n = 0;
		for (int i = 0; i < guildlist.size(); i++) {
			if (guildlist.get(i).party == true) {
				partyList[n] = guildlist.get(i);
				n += 1;
			}
		}
	}
	Player GetGuildUnit(int num) {
		return guildlist.get(num);
	}
	
	public void printAllGuildUnit() {
		buffer.append("=============");
		buffer.append("[골드 : " + Player.money + "골드]");
		buffer.append("=============");
		for(int i = 0; i < guildlist.size(); i ++) {
			buffer.append("["+ i + "번]");
			buffer.append("[이름 : "+ guildlist.get(i).name + "]");
			buffer.append("[체력 : "+ guildlist.get(i).hp + "]");
			buffer.append("[마력 : "+ guildlist.get(i).mp + "]");		
			buffer.append("[공격력 : "+ guildlist.get(i).power + "]");
			buffer.append("[방어력 : "+ guildlist.get(i).shield + "]");
			buffer.append("[스킬 : "+ guildlist.get(i).skill + "]");
			buffer.append("[파티중 : "+ guildlist.get(i).party + "]");
			buffer.append("=============");
		}
		buffer.append("=============");
	}

	public void printUnit(int selUnit) {
		guildlist.get(selUnit).printAllUnit();
	}
	
	public void printUnitItem(int selUnit) {
		guildlist.get(selUnit).pritnAllUnitItem();
	}

	public void printGuidMenu() {
		while(true) {
			buffer.append("====길드메뉴====");
			buffer.append("[1.길드원추가]\t\t[2.길드원삭제]");
			buffer.append("[3.길드목록]\t\t[4.파티원교체]");	
			buffer.append("[0.종료]");
			buffer.append("=============");
			
			String input = buffer.toString();
		
			
			if(input.equals("길드원추가")) {
				addGuild();
			}
			else if(input.equals("길드원삭제")) {
				removeGuild();
			}
			else if(input.equals("길드목록")) {
				printAllGuildUnit();
			}
			else if(input.equals("파티원교체")) {
				partyChange();
			}
			else if(input.equals("종료")) {
				return;
			}
		}
	}
	
	public void addGuild() {
		if(Player.money < 60000) {
			return;
		}
					
		String []name1 = {"김","이","박","정","최","강"};
		String []name2 = {"민","서","도","예","지","하"};
		String []name3 = {"준","윤","주","호","원","현"};
		
		String name = name1[ran.nextInt(name1.length)];
		name += name2 [ran.nextInt(name2.length)];
		name += name3 [ran.nextInt(name3.length)];
		
		int rNum = ran.nextInt(2)+8;
		int hp = rNum * 5;
		int mp = rNum * 5;
		int power = rNum * 5;
		int shield = rNum * 5;
		int skill = 2;
		
		Player temp = new Player(name, hp,mp,power,shield,skill,true);
		buffer.append("=====길드원=====");
		buffer.append("[이름  :" + name + "]");
		buffer.append("[체력  :" + hp + "]");
		buffer.append("[마력  :" + mp + "]");
		buffer.append("[공격력  :" + power + "]");
		buffer.append("[방어력  :" + shield + "]");
		buffer.append("[스킬  :" + skill + "]");
		buffer.append("==길드원이 추가되었습니다.==");
		buffer.append("=============");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		guildlist.add(temp);
		Player.money -= 60000;
		
	}

	public void removeGuild() {
		printAllGuildUnit();
		buffer.append("제거할 길드원을 입력해주세요");

		String input = buffer.toString();
		int value = Integer.parseInt(input);

		buffer.append("=====길드원=====");
		for (int i = 0; i < guildlist.size(); i++) {
			if (value == i) {
				buffer.append("[이름 : " + guildlist.get(i).name + "]");
			}
			buffer.append("==길드원을 제거했습니다.==");
			buffer.append("=============");
			guildlist.remove(value);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void partyChange() {
		
		
	}
	
	
}
