package textrpg;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class File {

	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(System.out));
	
	public void File() {
		while (true) {
			buffer.append("====파  일====");
			buffer.append("[1.저장]");
			buffer.append("[2.로드]");
			buffer.append("[0.종료]");

			String input = buffer.toString();

			if (input.equals("저장")) {
				save();
			} else if (input.equals("로드")) {
				load();
			} else if (input.equals("종료")) {
				return;
			}
		}
	}
	
	public void save() {
		
		
		
	}
	
	
	public void load() {
		
		
		
	}
	
	
	
	
	
	
	
	

}
