package pokemon;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File("D:/Program/java/pokemon/Music/" + name);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//쓰레드 중지 
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // 해당 쓰레드를 중지상태로 만든다.
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis); //TODO 버퍼설명 
				player = new Player(bis);
			}while(isLoop); //isLoop가 true값이면 무한 반복 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
