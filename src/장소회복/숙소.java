package 장소회복;

import character.Player_character;

public class 숙소 extends Player_character implements Runnable{
	
	int 시간 = 0;
	public volatile static boolean running = true;
	
	Player_character 플레이어;
	
	public 숙소(Player_character a) {
		this.플레이어 = a;
	}
	
	public static void terminate() {
		running = false;
	}
	
	public void run() {
		while(running) {
			try {
				회복하기();
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				running = false;
			}
		}
	}
	
	private void 회복하기() {
		시간++;
		if(플레이어.hp < 플레이어.hp_max || 플레이어.스트레스 > 0) {
			if(시간 % 3 == 0) {
				System.out.println("");
				if(플레이어.hp < 플레이어.hp_max && 플레이어.hp + 30 > 플레이어.hp_max) {
					플레이어.hp = 플레이어.hp_max;
					System.out.printf("🔋HP 회복완료! (현재HP: %d)\n", 플레이어.hp);
				}
				if(플레이어.hp + 30 <= 플레이어.hp_max) {
					플레이어.hp += 30;
					System.out.printf("🔋HP +30! (현재HP: %d)\n", 플레이어.hp);
				}
				
				if(플레이어.스트레스 == 1) {
					플레이어.스트레스 -= 1;
					System.out.println("⏳스트레스 해소완료! (현재스트레스: 0)");
				}
				if(플레이어.스트레스 > 1) {
					플레이어.스트레스 -= 1;
					System.out.printf("⏳스트레스지수 -1 (현재스트레스: %d)\n", 플레이어.스트레스);
				}
				
			}
		}
		
		if(플레이어.스트레스 == 0 && 플레이어.hp == 플레이어.hp_max) {
			System.out.println("🔸아주 건강한 상태입니다. 빨리 이 마을을 탈출하세요!🔸");
			숙소.running = false;
		}
	}
	
}
