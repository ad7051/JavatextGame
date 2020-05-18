package test0513;
import java.util.Random;

public class monster {
	private int money;
	private int atk;
	private int fhp;
	private int hp;
	private String name;
	public monster() {
		atk=0;
		hp=0;
		name="Missing No";
	}
	public monster(int category) {
		int [] m = {3,5,20};
		int [] a = {3,6,9};
		int [] h = {5,13,40};
		String [] n= {"슬라임","고블린","드래곤"};
		Random rand=new Random();
		int r=rand.nextInt(10000);
		
		money=m[category]+r%(12/(category+1));
		hp=h[category]+ r%(18/(category+1));
		fhp=hp;
		atk=a[category]+ r%(12/(category+1));;
		name=n[category];
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getAtk() {
		return atk;
	}
	public int Atk() {
		Random rand= new Random();
		int r=rand.nextInt(10000);
		if(r%atk==0||r%atk==6||r%atk==10) {
			System.out.println(name+"에게 치명적인 공격을 받았다.");
			return atk+atk/2;
		}
			System.out.println(name+"에게 공격을 받았다.");
		return atk;
	
	}
	
		public int  getHp() {
		return hp;
	}
		public void printHp() {
			System.out.printf("체력: [");
			if(fhp>40) {
				for(int i=0;i<fhp;i+=5) {
					if(hp>i)System.out.printf("I");
					else System.out.printf("-");
					}
				System.out.printf("]"+hp+"/"+fhp+"\n");
			}else{
				for(int i=0;i<fhp;i++) {
					if(hp>i)System.out.printf("I");
					else System.out.printf("-");
					}
				System.out.printf("]"+hp+"/"+fhp+"\n");
			}
		}
	public void damage(int damage) {
		hp-=damage;
	}
	
}
