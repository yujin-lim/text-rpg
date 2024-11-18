package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TextRPG {

	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(System.out));
	private BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	
    public static String nextStage = "";
    private Random ran = new Random();
    private static String curStage = "";
    
    private static TextRPG instance = new TextRPG();
    
    private TextRPG() {
    	
    }

    public static TextRPG getInstance() {
    	return instance;
    }
    
    Map<String, Stage> stagelist = new HashMap<String,Stage>();
    
    private boolean isRun = true;
    
    public void run() {
    	setGame();
    	while (isRun) {
    		play();
    	}
    }

   
    public void init () {
    	stagelist.put("MANAGER", new StageManager());
    	stagelist.put("LOBBY", new StageLobby());
    	stagelist.put("BATTLE", new StageBattle());
    	stagelist.put("SETTING", new StageSetting());
    	nextStage = "TITLE";
    }
    
    public boolean changeStage() {
    	buffer.append("CurStage : " + curStage);
    	buffer.append("nextStage: " + nextStage);
    	
    	if(curStage.equals(nextStage)) {
    		return true;
    	}
    	
    	curStage = nextStage;
    	Stage stage = stagelist.get(curStage);
    	stage.Init();
    	
    	boolean run = true;
    	while (run) {
    		run = stage.update();
    		if(run == false) {
    			break;
    		}
    	}
    	if(nextStage.equals("")) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
    
    public void setGame() {
    	
    }
    
    public void play() {
    	
    }

	
    
    
	
}
