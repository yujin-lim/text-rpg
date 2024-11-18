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
		guildlist.add(new Player ("전사", 300,100,100,100,2));
		guildlist.add(new Player ("마법사", 250,200,150,100,3));
		
		for (int i = 0; i < party_Size; i++) {
			
		}
	}


}
