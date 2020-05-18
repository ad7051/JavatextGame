package test0513;

public class Main {
	  public static void main(String[] args) {
		  	menu m= new menu();
			int menu=1;
			System.out.println("Hello welcome to TRPG ver.2");
			while(menu==1) {
				menu=m.Menu();//반환값으로 다른 수를 받아오면 종료된다.
			}
			if(menu==-1) {
				System.out.println("GAME OVER");
			}else if(menu==2) {
				System.out.println("Thank You For Play");
			}else if(menu==0) {
				System.out.println("Bye Bye~");
			}
			System.out.println("Program is End");
		}
}