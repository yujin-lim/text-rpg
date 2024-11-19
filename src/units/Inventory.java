package units;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import textrpg.Item;

public class Inventory {
	
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(System.out));
	private BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	
	
	ArrayList<Item>itemlist = new ArrayList<>();

	public void addItem(Item item) {
		itemlist.add(item);
	}
	
	public void inventoryMenu() {
		while(true) {
			buffer.append("====인 벤 토 리====");
			buffer.append("[1.착용]");
			buffer.append("[2.판매]");
			buffer.append("[0.종료]");
			
			String input = buffer.toString();
			
			if(input.equals("착용")){
				equipMenu();
			}
			else if(input.equals("판매")) {
				sellequip();
			}
			else if(input.equals("종료")) {
				return;
			}	
		}
	}
	
	public void equipMenu() {
		
		Player.guild.printAllGuildUnit();
		buffer.append("아이템을 착용할 길드원을 선택하세요");
		String input = buffer.toString();
		int sel = Integer.parseInt(input);
		
		while(true) {
			Player.guild.printUnit(sel);
			Player.guild.printUnitItem(sel);
			printItemlist();

			buffer.append("착용할 아이템 번호를 입력하세요");
			input = buffer.toString();
			int selequip = Integer.parseInt(input);

			if (itemlist.get(selequip).getKind() == Item.getWeapon()) {
				if (Player.getGuildUnit(sel).weapon != null) {
					itemlist.add(Player.getGuildUnit(sel).weapon);
				}
				Player.getGuildUnit(sel).weapon = itemlist.get(selequip);
			} else if (itemlist.get(selequip).getKind() == Item.getArmor()) {
				if (Player.getGuildUnit(selequip).armor != null) {
					itemlist.add(Player.getGuildUnit(sel).armor);
				}
				Player.getGuildUnit(sel).armor = itemlist.get(selequip);
			} else if (itemlist.get(selequip).getKind() == Item.getPotion()) {
				if (Player.getGuildUnit(selequip).potion != null) {
					itemlist.add(Player.getGuildUnit(sel).potion);
				}
				Player.getGuildUnit(sel).potion = itemlist.get(selequip);
			}
			itemlist.remove(selequip);
		}
	}
	
	public void printItemlist() {
		buffer.append("==================");
		buffer.append("====[ 아이템 리스트 ]=====");
	    for(int i = 0; i < itemlist.size(); i ++) {
	    	buffer.append("[ "+ i + "]");
	    	buffer.append("[이름 : "+ itemlist.get(i).getName()+ "]");
	    	buffer.append("[공격력 : "+ itemlist.get(i).getPower()+ "]");
	    	buffer.append("[가격 : "+ itemlist.get(i).getPrice()+ "]");
	    	buffer.append("==================");
	    }
	    buffer.append("==================");
	}

	public void sellequip() {
		
		while (true) {
			printItemlist();
			buffer.append("[골드 : " + Player.getMoney() + "골드 ]");
			buffer.append("판매할 아이템 번호를 입력하세요");

			String input = buffer.toString();
			int sellnum = Integer.parseInt(input);

			buffer.append("[" + itemlist.get(sellnum).getName() + "을 판매합니다.]");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Player.money += itemlist.get(sellnum).getPrice();
			itemlist.remove(sellnum);
		}
	}
}
