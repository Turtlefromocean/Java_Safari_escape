package character;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Monster_전갈 extends Character_super{
	
	public static int 전갈의독 = 0;
	
	public Monster_전갈() {
		this.name = "전갈🦂";
		this.hp = 100; 
		this.attack_max = 20;
		this.attack_min = 5;
		this.coin = (int)(Math.random()*(300) + 100); //100에서 300코인 사이 랜덤으로 나옴.
		this.exp = 15;
	}
	
	public int 아이템주기() {
		if(hp <= 0) {
			int 랜덤아이템확률 = (int)(Math.random()*10+1);
			if(랜덤아이템확률 <= 5) {
				전갈의독 += 2;
				System.out.printf("   + [몬스터아이템] '전갈의독🧪' (현재 보유량: %d개)\n", 전갈의독);
			}
		}
		return 전갈의독;
	}
	
	public void attack(Character_super enemy) {
		
		int 랜덤공격력 = (int)(Math.random()*(attack_max-attack_min)+attack_min);
		enemy.hp -= 랜덤공격력;
		System.out.printf("[%s]의 공격! Damage %d\n", name, 랜덤공격력);
		AudioClip 몬스터공격;
		try {
			File file = new File("/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/몬스터공격소리.wav");
			몬스터공격 = Applet.newAudioClip(file.toURL());
			몬스터공격.play();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.printf("\t[%s] HP : %d\n\n", enemy.name, enemy.hp);
	}
	
	Player_character 플레이어 = new Player_character();
	public void 전갈스킬(Player_character a) {
		this.플레이어 = a;
		int 랜덤확률 = (int)(Math.random()*(10-1)+1);
		if(랜덤확률 >= 8) {
			a.스트레스 ++;
			System.out.printf("\n❗[몬스터스킬]️전갈의 독 영향으로 2초간 공격중지 & 스트레스 증가❗(현재스트레스: %d)\n", a.스트레스);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
