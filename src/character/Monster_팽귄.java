package character;

public class Monster_팽귄 extends Character_super{
	
	public static int 왕관 = 0;
	public Monster_팽귄() {
		this.name = "팽귄🐧";
		this.hp = 130; 
		this.attack_max = 40;
		this.attack_min = 25;
		this.coin = (int)(Math.random()*(500) + 300); //300에서 500코인 사이 랜덤으로 나옴.
		this.exp = 20;
	}
	
	
	public int 아이템주기() {
		if(hp <= 0) {
			int 랜덤아이템확률 = (int)(Math.random()*10+1);
			if(랜덤아이템확률 <= 5) {
				왕관 += 3;
				System.out.printf("   + [몬스터아이템] '황제팽귄의 왕관👑'(현재 보유량: %d개)\n", 왕관);
			}
		}
		return 왕관;
	}
	
	Player_character 플레이어 = new Player_character();
	
	public void 팽귄스킬(Player_character a) {
		this.플레이어 = a;
		int 랜덤확률 = (int)(Math.random()*(10-1)+1);
		if(랜덤확률 >= 8) {
			a.스트레스 ++;
			System.out.printf("\n❗[몬스터스킬]️ \"꽤액!!\" 팽귄의 시끄러운 소리로 스트레스 증가❗(현재스트레스: %d)\n", a.스트레스);
			
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	
}
