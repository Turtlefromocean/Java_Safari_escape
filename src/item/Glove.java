package item;

public class Glove extends Item_super {
	public static int damage_to_atk;
	
	public Glove() {
		this.name = "권투글러브";
		this.price = 1000;
		this.count = 0;
		
		damage_to_atk = 10;
	}
}
