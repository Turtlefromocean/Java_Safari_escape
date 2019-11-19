package character;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Tiger extends Player_character implements Runnable  {
	public volatile static boolean running = true;
	public Tiger() {
		this.name = "티거🐯";
		this.hp = 180;
		this.hp_max =180;
		this.attack_max = 40;
		this.attack_min = 20;
		this.exp = 0;
		this.coin = 0;
		this.skill = "";
		this.플레이어속도 = 1000;
		}
	

	public void run() {
		while (running) {
			try {
				skill();
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
	public static void terminate() {
		running = false;
	}
	
	Player_character 티거;
	public Tiger(Player_character a) {
		this.티거 = a;
	}
	public void skill() {
		
		if (this.skill_cnt != 0) {
			Piglet.running = false;
			System.out.println("\n🛠스킬사용 종료🛠");
			티거.플레이어속도 = 1000;
			terminate();
		}
		else  {
			this.skill_cnt++;
			AudioClip 몬스터스킬;
			try {
				File file = new File(
						"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Jump by jeckkech Id-391670/Unknown Album/몬스터스킬.wav");
				몬스터스킬 = Applet.newAudioClip(file.toURL());
				몬스터스킬.play();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("\"📈 스피드업! 📈\"");
			System.out.println("🛠 스킬사용으로 15초동안 플레이어의 속도가 20% 빨라집니다🛠");
			티거.플레이어속도 = 800;

		}

	}

	
}

