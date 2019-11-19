package item;

public class Dobok extends Item_super {
	public static int plus_to_hp;
	
	public Dobok() {
		this.name = "유도도복";
		this.price = 3000;
		this.count = 0;
		plus_to_hp = 30;
	}
}