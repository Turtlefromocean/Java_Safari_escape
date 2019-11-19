package character;


public class Monster_야생동물구조대 extends Character_super {
	
	public static int 뱃지 = 0;
	
	public static int 구조대원이가져간틀니 = 0;
	
	public Monster_야생동물구조대() {
		this.name = "야생동물구조대원👷🏼‍♂️";
		this.hp = 150; 
		this.attack_max = 45;
		this.attack_min = 25;
		this.coin = (int)(Math.random()*(1000) + 700); //700에서 1000코인 사이 랜덤으로 나옴.
		this.exp = 30;
	}
	
	
	public int 아이템주기() {
		if(hp <= 0) {
			int 랜덤아이템확률 = (int)(Math.random()*10+1);
			if(랜덤아이템확률 <= 3) {
				뱃지 += 2;
				System.out.printf("[몬스터아이템] '동물구조원의 뱃지'를 얻었습니다! (현재 보유량: %d개)\n", 뱃지);
			}
			if(랜덤아이템확률 <= 3) {
				구조대원이가져간틀니++;
				System.out.println("[특별아이템] '구조대원이 가져간 거북이의 틀니'를 얻었습니다!");
			}
		}
		return 뱃지;
	}
	Player_character 플레이어 = new Player_character();
	
	public void 구조대원스킬(Player_character a) {
		this.플레이어 = a;
		int 랜덤확률 = (int)(Math.random()*(10-1)+1);
		if(랜덤확률 >= 8) {
			a.스트레스 ++;
			System.out.printf("\n❗[몬스터스킬]️마취총 영향으로 3초간 공격중지 & 스트레스 증가❗(현재스트레스: %d)\n", a.스트레스);
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
