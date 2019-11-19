package bgm;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class 게임종료bgm {
	public static Clip clip;
	public 게임종료bgm() {
		play();
	}
	
	public static void play() {
		Main_sound("/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Hat Films Improv Remix by parkourbrad1 Id-346842/Unknown Album/게임클리어 후.wav");
	}
	
	public static void Main_sound(String file) {
		try {
			AudioInputStream ais = 
					AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			clip.loop(8);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void stop() {
		clip.stop();
		clip.close();
	}
}
