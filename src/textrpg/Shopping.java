package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import units.Player;

public class Shopping {

	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(System.out));
	private BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	
	ArrayList<Item>itemlist = new ArrayList<>();
	
	public void Shopping() {
		Item temp = new Item(1,"나무검", 1000, 100);
		itemlist.add(temp);

		temp = new Item(1, "철검", 2000, 150);
		itemlist.add(temp);

		temp = new Item(1, "다이아검", 5000, 500);
		itemlist.add(temp);

		temp = new Item(2, "나무갑옷", 1000, 100);
		itemlist.add(temp);

		temp = new Item(2, "철갑옷", 2000, 150);
		itemlist.add(temp);

		temp = new Item(2, "다이아갑옷", 5000, 500);
		itemlist.add(temp);

		temp = new Item(3, "공격력포션1", 500, 100);
		itemlist.add(temp);

		temp = new Item(3, "공격력포션2", 1000, 200);
		itemlist.add(temp);

		temp = new Item(3, "공격력포션3", 1500, 300);
		itemlist.add(temp);
	}
	
	public void shopTable() {
		while(true) {
			buffer.append("====상 점====");
			buffer.append("[1.무기]");
			buffer.append("[2.갑옷]");
			buffer.append("[3.포션]");
			
			String input = buffer.toString();
			int value = Integer.parseInt(input);
			
			if(input.equals("무기")){
				value = Item.WEAPON;
			}
			else if(input.equals("갑옷")) {
				value = Item.ARMOR;
			}
			else if(input.equals("포션")) {
				value = Item.POTION;
			}
			
			buffer.append("==================");
			buffer.append("[골드 : "+ Player.getMoney() + "골드 ]");
			buffer.append("==================");
			buffer.append("구매하시고 싶은 아이템 번호를 입력해주세요[0.뒤로가기]");

			input = buffer.toString();
			int number = Integer.parseInt(input);

			if (number == 0) {
				break;
			}
			int count = 0;
			for (int i = 0; i < itemlist.size(); i++) {
				if (itemlist.get(i).getKind() == value) {
					count += 1;

					if (count == number) {
						Player.inventory.addItem(itemlist.get(i));
						Player.setMoney(Player.getMoney() - itemlist.get(i).getPrice());
						buffer.append("[" + itemlist.get(i).getName() + "을 구매했습니다]");

						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
	}
	
	public void printItem(int kind) {
		int count = 0;
		for (int i = 0; i < itemlist.size(); i++) {
			if (itemlist.get(i).getKind() != kind) {

				buffer.append("[" + count + "번]");
				buffer.append("[이름 : " + itemlist.get(i).getName() + "]");
				buffer.append("[공격력 : " + itemlist.get(i).getPower() + "]");
				buffer.append("[가격 : " + itemlist.get(i).getPrice() + "]");
				buffer.append("=====================");
				count += 1;
			}
		}
	}	
}
