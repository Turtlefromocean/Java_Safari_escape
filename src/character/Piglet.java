package character;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Piglet extends Player_character implements Runnable {

	public volatile static boolean running = true;

	public Piglet() {
		this.name = "피글렛🐷";
		this.hp = 160;
		this.hp_max = 160;
		this.attack_max = 25;
		this.attack_min = 15;
		this.coin = 10000;
		this.exp = 0;
		this.skill = "\"돈돈\"";
		this.skill_cnt = 0;
		this.플레이어속도 = 1000;
	}

	Character_super 몬스터 = new Character_super();

	public Piglet(Character_super monster) {
		this.몬스터 = monster;
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
	public void skill() {
		
		if (this.skill_cnt != 0) {
			Piglet.running = false;
			System.out.println("\n🛠스킬사용 종료🛠");
			몬스터.coin = (int)(몬스터.coin*10/11);
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
			System.out.println("\"💸 돈돈! 💸\"");
			System.out.println("🛠 스킬사용으로 15초동안 몬스터의 보상코인의 10%가 증가합니다🛠");
			몬스터.coin = (int)(몬스터.coin*11/10);

		}

	}

	
}
