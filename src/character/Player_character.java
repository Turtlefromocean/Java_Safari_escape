package character;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

import item.Potion_pill;

public class Player_character extends Character_super{
	public int hp_max;
	public int 플레이어속도;  //새로 추가!!
	public int 스트레스 = 0;   //새로 추가!!
	public String skill;
	public int skill_cnt;
	
	public int 야생성영향받은플레이어공격력 = attack_max + (int)(exp /100)*10;
	public static int 전갈의독 = 0;
	public static int 바나나 = 0;
	public static int 왕관 = 0;
	public int 뱃지 = 0;
	
	public int 동료수 = 0;
	public int 친밀도 = 0;
	
	public void attack(Character_super enemy) {
		
		int 랜덤공격력 = (int)(Math.random()*(attack_max-attack_min)+attack_min);
		enemy.hp -= 랜덤공격력;
		System.out.printf("[%s]의 공격! Damage %d\n", name, 랜덤공격력);
		AudioClip 플레이어공격;
		try {
			File file = new File("/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/HitSound.wav");
			플레이어공격 = Applet.newAudioClip(file.toURL());
			플레이어공격.play();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.printf("\t[%s] HP : %d\n\n", enemy.name, enemy.hp);
	}
	
	public int potion() {
		hp += Potion_pill.plus_to_hp;
		System.out.printf(" 💊HP +%d💊 \n", Potion_pill.plus_to_hp);
		return hp;
	}
	
	
	public int get_coin(Character_super enemy) {
		coin += enemy.coin;
		return coin;
	}

	
}
