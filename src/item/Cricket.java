package item;

public class Cricket extends Item_super {
	public static int damage_to_atk;
	
	public Cricket() {
		this.name = "크리켓방망이";
		this.price = 3000;
		this.count = 0;
		damage_to_atk = 30;
	}
}
