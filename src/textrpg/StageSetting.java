package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import units.UnitManager;

public class StageSetting extends Stage {

	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(System.out));
	private BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	private UnitManager um;
	private File File;
	private Shopping Shopping;
	private static String input = "";
	
	@Override
	public boolean update() {
		while (true) {
			buffer.append("===========");
			buffer.append("==setting==");
			buffer.append("[1. 길드] ");
			buffer.append("[2. 상점] ");
			buffer.append("[3. 인벤토리] ");
			buffer.append("[4. 파일] ");
			buffer.append("[0. 종료] ");
			
		    input = buffer.toString();
		  
		    if(input.equals("1")) {
		    	um.Guild();
		    }
		    else if(input.equals("2")) {
		    	Shopping.Shopping();
		    }
		    else if(input.equals("3")) {
		    	um.Inventory();
		    }
		    else if(input.equals("4")) {
		    	File.File();
		    }
		    else if(input.equals("0")) {
		    	return false;
		    }
		}
	}
	
	@Override
	public void Init() {
		um = UnitManager.instance;
		Shopping = new Shopping();
		File = new File();
	}
	
}
