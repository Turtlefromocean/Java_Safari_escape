package character;

public class Monster_원숭이 extends Character_super {

	public static int 바나나 = 0;

	public Monster_원숭이() {
		this.name = "원숭이🐒";
		this.hp = 120;
		this.attack_max = 30;
		this.attack_min = 10;
		this.coin = (int) (Math.random() * (300) + 100); // 100에서 300코인 사이 랜덤으로 나옴.
		this.exp = 15;
	}

	public int 아이템주기() {
		if (hp <= 0) {
			int 랜덤아이템확률 = (int) (Math.random() * 10 + 1);
			if (랜덤아이템확률 <= 5) {
				바나나 += 3;
				System.out.printf("   + [몬스터아이템] '원숭이의 바나나🍌' (현재 보유량: %d개)\n", 바나나);
			}
		}
		return 바나나;
	}

	public void 원숭이스킬(Character_super a) {
		int 랜덤확률 = (int) (Math.random() * (10 - 1) + 1);
		if (랜덤확률 >= 8) {
			if (a.coin <= 300) {
				a.coin = 0;
				System.out.printf("\n❗[몬스터스킬] 원숭이가 보유베리를 모두 훔쳐갔습니다❗(현재보유코인: %d)\n", a.coin);
			}
			else if (a.coin > 300) {
				a.coin -= 300;
				System.out.printf("\n❗[몬스터스킬] 원숭이가 300베리를 훔쳐갔습니다❗ (현재보유코인: %d)\n", a.coin);
			}

		}
	}

}
