package textrpg;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import units.UnitManager;

public class StageLobby extends Stage {
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	@Override
	public boolean update() {
		buffer.append("====Lobby====");
		buffer.append("[1.전투]");
		buffer.append("[2.설정]");
		buffer.append("[0.종료]");

		String input = buffer.toString();

		if (input.equals("전투")) {
			TextRPG.getInstance = "BATTLE";
		} else if (input.equals("설정")) {
			TextRPG.getInstance = "SETTING";
		} else if (input.equals("종료")) {
			TextRPG.getInstance = "EXIT";
		}
		return false;
	}

	@Override
	public void Init() {
		UnitManager.instance.init();

	}

}
