package item;

public class Potion_pill extends Item_super{
	public static int plus_to_hp;
	public Potion_pill() {
		this.name = "구급약";
		this.price = 200;
		this.count = 5;
		plus_to_hp = 50;
	}
	
}
