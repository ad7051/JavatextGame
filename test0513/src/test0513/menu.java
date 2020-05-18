package test0513;

import java.util.Scanner;

public class menu {
	static user u=new user();
	static Fightmenu m= new Fightmenu();
	public static int input(){ //문자를 입력 받는것을 scanner 구조체를 매번 함수에서 선언하지 않으면 작동하지 않아 불편함을 줄이기 위해, 입력받는함수를 별개로 만들었다.
	    Scanner keyboard = new Scanner(System.in);
	    return keyboard.nextInt();//입력을 받은 값을 반환한다.
	  }
	public int Menu() {	
		int menu=0;
		int record=0;
		System.out.printf("모험의 땅에 어서오세요! 당신은 지금부터 용사입니다.\n");
		System.out.println("그래요, 그 전설의 용사입니다! 자세한 것은 아래의 메뉴를 통해서 확인해 주세요!");
		for(;;) {
			System.out.println("현제 최고 탐험 횟수 "+record+"회");//현제까지의 최고 진행 기록을 출력한다.
			System.out.println("1. 던전으로 모험을 떠나자!");
			System.out.println("2. 상점에서 물건을 사자!");
			System.out.println("3. 그만 할래.");
			menu=input();
			if(menu==1) {
				System.out.printf("던전에 입장\n");
					record=m.stage(u);//최고 기록을 진행 상황에 기록한다.
						if(record==-1){//사망시 기록이 -1로 출력되어 사망함을 표시하고 종료된다.
							System.out.println("케릭터는 힘을 다해 쓰러졌습니다.");
							return -1;
						}else if(record>=20){//게임을 목표진행치 까지 진행하여 완료하게되면 완료에 대한 축하가 나오고 졸료된다.
							System.out.println("당신은 무사히 이번 던전을 정복하였습니다.");
							System.out.println("플레이 해주셔서 감사합니다!");
							return 2;
						}
			}else if(menu==2) {//상점 함수를 불러온다.
				System.out.printf("상점에 입장\n\n");
				store();
			}else if(menu==3) {
				return 0;
			}else {
				System.out.println("제대로된 메뉴를 입력하자");//잘못된 입력에 대한 안내 메시지이다.
			}
		}
	 }
	public static void store(){//물건을 구매해서 능력치를 변화시키는 상점이다.
		int menu;
		System.out.println("상점에 어서 오세요!");
		for(;;){
			System.out.println("\n사고싶으신 물건을 골라주세요!");
			System.out.println("1. 포션(HP를 5회복 시킨다.) : 2coin");
			System.out.println("2. 강철검(공격력을 7로 높여준다) : 5coin");
			System.out.println("3. 근력 강화제(공격력을 1높여준다) : 10coin");
			System.out.println("0. 나가기");
			System.out.println("현제 남은 돈 : "+u.getCoin());
			menu=input();
			if(menu==1){//메뉴에 따라서 돈과 글이 변경되어 출력된다.
				if(u.getCoin()<2)System.out.println("어라, 너 돈이 없잖아! 썩 나가지 못해!!");//돈이 충분치 않을경우 구매가 불가하고 경고가 나온다.
				else{
					u.useCoin(2);
					System.out.println("포션을 구매했다.");
					u.buyPotion();
					System.out.println("다음에 또 오시게!!");
		        	}//돈이 충분할 경우 구매가 가능하다.
		      	}else if(menu==2){
		      		if(u.getCoin()<5)System.out.println("어라, 너 돈이 없잖아! 썩 나가지 못해!!");
		      		else{
		      			u.useCoin(5);
		      			System.out.println("강철검을 구매했다.");
		      			u.useSword(7);
		      			System.out.println("다음에 또 오시게!!");
		      		}
		      	}else if(menu==3){
		      		if(u.getCoin()<10)System.out.println("어라, 너 돈이 없잖아! 썩 나가지 못해!!");
		      		else{
		      			u.useCoin(10);
		      			System.out.println("근력 강화제를 구매했다.");
		      			u.upAtk(1);
		      			System.out.println("다음에 또 오시게!!");
		      		}
		      	}else if(menu==0){//메뉴종료시 안내 메시지가 나온다.
		      		System.out.println("잘 가시게!!");
		      		break;
		      	}else{//잘못된 입력을 할 시 메뉴가 강제적으로 종료된다.
		      		System.out.println("장난은 사절일세!");
		      		break;      
		      	}
		}
	}
	
}
