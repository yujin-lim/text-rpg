package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StageManager extends Stage {
	
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(System.out));
	private BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

	@Override
	public boolean update() {
		buffer.append("====TEXT RPG====");
		buffer.append("[시작]을 입력하세요");
		
		String input = buffer.toString();
		
		if(input .equals("시작")) {
		     TextRPG.nextStage = "LOBBY";
			
			
		}
		return false;
		
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
