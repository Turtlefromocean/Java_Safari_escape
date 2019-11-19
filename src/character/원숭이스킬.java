package character;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class 원숭이스킬 extends Player_character implements Runnable {
	int 걸린시간 = 0;
	public volatile static boolean running = true;
	public static int 쓰러진원숭이수 = 0;

	Player_character 플레이어;// = new Player_character();

	public 원숭이스킬(Player_character a) {
		this.플레이어 = a;
	}

	public static void terminate() {
		running = false;
	}

	public void run() {
		while (running) {
			try {
				공격하기();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}

	private void 공격하기() {
		걸린시간++;
		int 랜덤공격력 = (int) (Math.random() * (30 - 10) + 10);
		if (플레이어.hp - 랜덤공격력 <= 0) {
			if (걸린시간 % 3 == 0) {
				플레이어.hp = 0;
				System.out.printf("\n[원숭이🐒]의 공격! Damage %d (현재 HP : 0)\n", 랜덤공격력);
				AudioClip 몬스터공격;
				try {
					File file = new File(
							"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/몬스터공격소리.wav");
					몬스터공격 = Applet.newAudioClip(file.toURL());
					몬스터공격.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
				원숭이스킬.running = false;
			}
		}
		if (플레이어.hp - 랜덤공격력 > 0) {
			if (걸린시간 % 3 == 0) {
				플레이어.hp -= 랜덤공격력;
				System.out.printf("\n[원숭이🐒]의 공격! Damage %d (현재 HP : %d)\n", 랜덤공격력, 플레이어.hp);
				AudioClip 몬스터공격;
				try {
					File file = new File(
							"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/몬스터공격소리.wav");
					몬스터공격 = Applet.newAudioClip(file.toURL());
					몬스터공격.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
