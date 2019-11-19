package character;

public class Character_super {
	public String name;
	public int hp;
	public int attack_max;
	public int attack_min;
	public int exp;
	public int coin;
	public int 스트레스;
	
	public void attack(Character_super enemy) {
		int 랜덤공격력 = (int)(Math.random()*(attack_max-attack_min)+attack_min);
		enemy.hp -= 랜덤공격력;
		System.out.printf("[%s]의 공격! Damage %d\n", name, 랜덤공격력);
		//System.out.printf("\t[%s] HP : %d\n\n", enemy.name, enemy.hp);
	}
	
	public int get_coin(Character_super enemy) {
		coin += enemy.coin;
		return coin;
	}
	
}
