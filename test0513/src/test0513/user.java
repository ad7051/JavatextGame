package test0513;

public class user {
	private int hp;
	private int atk;
	private int potion;
	private int coin;
	public user(){
		hp=50;
		atk=5;
		potion=5;
		coin=10;
	}
	public int getHp() {
		return hp;
	}
	public void printHp() {
		System.out.printf("체력: [");
		for(int i=0;i<50;i+=5) {
			if(hp>i)System.out.printf("I");
			else System.out.printf("-");
		}
		System.out.printf("]"+hp+"/"+50+"\n");
	}
	public void damage(int damage) {
		hp-=damage;
	}
	public int getAtk() {
		return atk;
	}
	public void upAtk(int up) {
		atk+=up;
	}
	public void useSword(int up) {
		if(atk<7)atk=7;
		else System.out.println("이미 공격력이 높아 의미가 없다.");
	}
	
	public int getPotion() {
		return potion;
	}
	public void usePotion() {
		if(potion>0) {
			potion--;
			hp+=5;
			if(hp>50)hp=50;
			System.out.println("포션을 사용하였다. 남은 포션의 개수: "+potion+"개 \n 남은 체력: "+hp);
		}else System.out.println("포션의 개수가 부족하다.");
	}
	public void buyPotion() {
		potion++;
	}

	public int getCoin() {
		return coin;
	}
	public void useCoin(int used) {
		coin-=used;
	}
	public void gCoin(int c) {
		coin+=c;
	}
}