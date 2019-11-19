package bgm;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class 던전bgm {
	public static Clip clip;
	public 던전bgm() {
		play();
	}
	
	public static void play() {
		Main_sound("/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Dystopian Future   Fx Sounds (8) by BurghRecords Id-390539/Unknown Album/던전배경음악.wav");
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
