package character;

public class 관리자모드 extends Player_character {
	
	public 관리자모드() {
		this.name = "관리자모드";
		this.hp = 300;
		this.hp_max = 300;
		this.attack_max = 60;
		this.attack_min = 60;
		this.exp =0;
		this.coin = 10000;
		this.플레이어속도 = 800;
		}
	public void skill() {
		System.out.println("사용할 수 있는 스킬이 없습니다.");
	}
}
