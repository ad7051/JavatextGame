package test0513;

import java.util.Random;
import java.util.Scanner;

public class Fightmenu{
	public static int input(){ //문자를 입력 받는것을 scanner 구조체를 매번 함수에서 선언하지 않으면 작동하지 않아 불편함을 줄이기 위해, 입력받는함수를 별개로 만들었다.
	    Scanner keyboard = new Scanner(System.in);
	    return keyboard.nextInt();//입력을 받은 값을 반환한다.
	  }
	public static int Random() {
		Random rand=new Random();
		return rand.nextInt(1000);
	}
	
	 public int stage(user u){//던전에서의 행동을 선택하는 화면이다.
		    int menu;
		    int rand=0;
		    int i;
		    for(i=0;i<20;){
		      if(u.getHp()<=0) return-1;
		      
		      System.out.println("\n이제 할 행동을 선택하자.\n");
		      System.out.println("1. 앞으로 전진");
		      System.out.println("2. 마을로 돌아가기");
		      System.out.println("3. 상태 확인");
		      menu=input();//메뉴를 받아온다.
		      if(menu==1){
		        i++;
		        rand=Random();
		        if(rand%4!=0){//전투는 1/4확률로 전투 없이 전진이 가능하다.
		          Fight(u,i);
		        }else{
		        System.out.println("\n아무 일도 일어나지 않았다.");
		        }
		      }else if(menu==2){
		        rand=Random();
		        if(rand%10==0){//마을에 돌아갈때도 10퍼센트의 확률로 몬스터에게 습격을 받아 강제로 전투가 진행된다.
		          System.out.println("\n몬스터의 습격이다!!");
		          i+=Fight(u,i);
		        }else
		        return i;
		      }else if(menu==3){//현제 상황을 출력하는 함수를 불러온다.
		        printstatus(u,i);
		      }else {//오류값에 대한 안내를 한다.
		        System.out.println("\n제대로된 메뉴를 입력하자!");
		      }
		    }
		    return i;//진행상황을 전달한다.
		  }

	public void printstatus(user u,int record){//플레이어의 스테이터스를 출력하는 창이다.
	    int left=20-record;//앞으로 남은 던전 클리어까지의 횟수이다.
	    System.out.println("던전 정복까지 남은 전진 횟수: "+left);
	    u.printHp();
	    System.out.println("공격력: "+u.getAtk());
	    System.out.println("남은 포션 개수: "+u.getPotion());
	    System.out.println("남은 동전 수: "+u.getCoin());
	  }
	  public static int Fight(user u,int record){// 전투함수 이전에 몬스터와의 출몰을 만드는 함수로, 출몰할 몬스터를 확률과 진행상황에 맞춰서  출몰시킨다.
		    int menu;
		    int rand=Random(); 
		    monster m;
		    int win=0;//전투에서 승리시 1을 반환해 추가적으로 더 전진하고, 도주시 0을 반환받아 추가 전진 없이 진행된다.
		    if(record>17){//진행상황에 따른 몬스터 등장이다.
		    	m=new monster(0);
		    }else if(rand%20==0){//확률에 따른 몬스터 등장이다.
		    	m=new monster(0);
			}else if(rand%3==0){
				m=new monster(1);
			}else{
				m=new monster(2);
		    }
		    
		    System.out.println("야생의 "+m.getName()+"이 나타났다!!");
		    for(;m.getHp()>0;){
		    	rand=Random(); 
		    	if(u.getHp()<=0)return 0;
		    	System.out.printf("이름: %s\n공격력: %d\n",m.getName(),m.getAtk());
		    	m.printHp();
		    	menu=fightmenu(u);//전투메뉴에서 전투행동을 받아온다.
		    	if(menu==1){//공격시 랜덤에 기반해서 치명타를 입힌다.
		        rand=Random();
		        if(rand%33==0){//몬스터마다 치명타 확률과 메시지의 단어가 다르기 때문에 별도의 함수로 만들지 않았다.
		          System.out.printf("%s에게 %d치명적인 부상을 입혔다.\n",m.getName(),u.getAtk()+u.getAtk()/2);
		          m.damage(u.getAtk()+u.getAtk()/2);
		        }else{
		          m.damage(u.getAtk());
		        }
		      }else if(menu==2){
		        u.usePotion();
		        
		      }else{
		        rand=Random();
		        if(rand%6==0){//몬스터에 따라 도망칠 수 있는 확률이 달라 지정해 놨다.
		          System.out.println("도망치는데 실패했다.");
		        }
		        else{
		          System.out.println("도망치는데 성공했다.");
		          return 0;//도주시 도주를 표현한 0을 반환한다.
		        }
		      }rand=Random();
		      if(rand%3==1){//몬스터에게 전투행동 직후에 확률적으로 공격받는다.
		    	  u.damage(m.Atk());
		    	  System.out.println("///\n공격을 받아 HP가 감소헸다!");
		    	  u.printHp();
		      }
		  }
		    System.out.println("\n"+m.getName()+"을 해치웠다.");//몬스터를 hp를 0이하로 만들 경우 승리한다.
		    u.gCoin(m.getMoney());//돈 또한 랜덤에 기반하여 지급한다.
		    
		    
		    return win;//승패를 반환한다.
		    
	  }
	  public static int fightmenu(user u){ //전투시 각 몬스터의 능력치 및 이름을 변수로 주고 받는건 힘들어도 반복되는 부분인 전투 선택창을 간소화 시키기위해서 별개의 함수로 지정하였다.
		    int menu;
		    for(;;){
		      System.out.println("\n\n현제 남은 체력: "+u.getHp()+"/50");
		      if(u.getHp()<7)
		      System.out.println("신중히 선택하자.");//다양한 상황에 맞춘 재미를 주기위한 메시지
		      System.out.println("1. 공격한다.");
		      System.out.println("2. 포션을 사용한다.\n  현제 남은 포션 수:"+u.getPotion());
		      System.out.println("3. 도망친다.");
		      menu=input();//메뉴 입력받는것을 간소화시킨다.
		      if(menu!=1&&menu!=2&&menu!=3){//지정된 메뉴 이외의 오류값을 감지하여 메시지를 띄운다.
		       System.out.println("위급한 상황이니 장난은 치지 말자.");
		      }else return menu;//정해진 전투행동을 본래 각 몬스터별 전투 함수로 넘긴다.
		    }
		  }
}
