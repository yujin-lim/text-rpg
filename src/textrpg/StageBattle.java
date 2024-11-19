package textrpg;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Vector;

import units.Monster;
import units.Player;
import units.UnitManager;

public class StageBattle  extends Stage {
	
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(System.out));
	
	UnitManager um = null;
	Vector<Monster> monsterlist = null;
	Random ran ;
	int monsterDead = 0;
	int playerDead = 0;
	
	public StageBattle() {
		um = UnitManager.instance;
		ran = new Random();
	}

	@Override
	public boolean update() {
		boolean run = true;
		int player_index = 0;
		int monster_index = 0;
		boolean turn = true;
		
		while (run) {
			if (turn) {
				print_char();
				if (player_index < Player.getGuildSize()) {
					player_attack(player_index);
					player_index += 1;
				} else {
					turn = !turn;
					player_index = 0;
				}
			} else if (!turn) {
				if (monster_index < monsterlist.size()) {
					monster_attack(monster_index);
					monster_index += 1;
				} else {
					turn = !turn;
					monster_index = 0;
				}
			}
			check_live();
			if (monsterDead <= 0 || playerDead <= 0) 
				break;
			
		}
		TextRPG.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void Init() {
	   um.monsterlist.clear();
	   um.random_monster_set(4);
	   um.player = null;
	   um.player = new Player();
	   monsterlist = null;
	   monsterlist = um.monsterlist;
	   monsterDead = monsterlist.size();
	   playerDead = Player.getGuildSize();

	}
	
	public void print_char() {
		buffer.append(" ================");
		buffer.append("=====[BATTLE]=====");
		buffer.append(playerDead + ":" + monsterDead);
		buffer.append("=====[PLAYER]=====");
		for (int i = 0; i < Player.getGuildSize(); i++) {
			Player.GetGuildUnit(i).printData();
		}
		buffer.append("=====[MONSTER]=====");
		for (int i = 0; i < monsterlist.size(); i++) {
			monsterlist.get(i).printData();
		}
	}
	
	
	public void player_attack(int index) {
		Player pl = Player.GetGuildUnit(index);
		
		if(pl.getHp() <= 0) {
			return;
		}
		
		buffer.append("================");
		buffer.append("[" +pl.getName()+"]");
		buffer.append("[1. 때리기 ]");
		buffer.append("[2. 스킬 ]");
		
		String input = buffer.toString();
		int  sel = Integer.parseInt(input);
		
		if(sel == 1) {
			while(true) {
				int idx = ran.nextInt(monsterlist.size());
				if(monsterlist.get(idx).getHp() > 0) {
					pl.attack(monsterlist.get(idx));
					break;
				}
			}
		}
		else if (sel == 2) {
			buffer.append("================");
			buffer.append("[" +pl.getSkill()+"]");
			buffer.append("[1. 회복 ]");
			buffer.append("[2. 전체 공격 ]");
			
			input = buffer.toString();
		    int  selskill = Integer.parseInt(input);
		    
		    if(selskill == 1) {
		    	
		    }
		    else if(selskill == 2) {
		    	
		    	
		    }
		}
	
	
	public void monster_attack(int index) {
		Monster mon = monsterlist.get(index);
		if(mon.getHp() <= 0)
			return;
		while(true) {
			int idx = ran.nextInt(Player.getGuildSize());
			if(Player.GetGuildUnit(idx).getHp() > 0) {
				mon.attack(Player.GetGuildUnit(idx));
				break;
			}
		}
	}
	
	public void check_live() {
		int num = 0;
		for (int i = 0; i < Player.getGuildSize(); i++) {
			if (Player.GetGuildUnit(i).getHp() <= 0) {
				num += 1;
			}
		}
		playerDead = Player.getGuildSize() - num;

		num = 0;
		for (int i = 0; i < monsterlist.size(); i++) {
			if (monsterlist.get(i).getHp() <= 0) {
				num += 1;
			}
		}
		monsterDead = monsterlist.size() - num;
	}

}
