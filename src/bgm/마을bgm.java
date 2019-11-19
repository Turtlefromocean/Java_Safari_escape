package bgm;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class 마을bgm {
	public static Clip clip;
	public 마을bgm() {
		play();
	}
	
	public static void play() {
		Main_sound("/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Chiến Thắng Linh Đình by SieuAmThanh Id-423353/Unknown Album/마을bgm.wav");
	}
	
	public static void Main_sound(String file) {
		try {
			AudioInputStream ais = 
					AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			clip.loop(5);
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
