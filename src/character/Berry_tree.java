package character;

public class Berry_tree extends Character_super{
	public Berry_tree() {
		this.name = "베리나무";
		this.hp = 30;
		this.coin = 50;
	}
	
	Player_character 플레이어 = new Player_character();
	public void 베리스킬(Player_character a) {
		this.플레이어 = a;
		int 랜덤확률 = (int)(Math.random()*(10-1)+1);
		if(랜덤확률 >= 9) {
			a.스트레스 ++;
			System.out.printf("❗[몬스터스킬]️알수없는 냄새로 인한 스트레스 증가❗(현재스트레스: %d)\n", a.스트레스);
		}
	}
}
