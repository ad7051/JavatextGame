package test0513;

import java.util.Random;
import java.util.Scanner;

public class Fightmenu{
	public static int input(){ //���ڸ� �Է� �޴°��� scanner ����ü�� �Ź� �Լ����� �������� ������ �۵����� �ʾ� �������� ���̱� ����, �Է¹޴��Լ��� ������ �������.
	    Scanner keyboard = new Scanner(System.in);
	    return keyboard.nextInt();//�Է��� ���� ���� ��ȯ�Ѵ�.
	  }
	public static int Random() {
		Random rand=new Random();
		return rand.nextInt(1000);
	}
	
	 public int stage(user u){//���������� �ൿ�� �����ϴ� ȭ���̴�.
		    int menu;
		    int rand=0;
		    int i;
		    for(i=0;i<20;){
		      if(u.getHp()<=0) return-1;
		      
		      System.out.println("\n���� �� �ൿ�� ��������.\n");
		      System.out.println("1. ������ ����");
		      System.out.println("2. ������ ���ư���");
		      System.out.println("3. ���� Ȯ��");
		      menu=input();//�޴��� �޾ƿ´�.
		      if(menu==1){
		        i++;
		        rand=Random();
		        if(rand%4!=0){//������ 1/4Ȯ���� ���� ���� ������ �����ϴ�.
		          Fight(u,i);
		        }else{
		        System.out.println("\n�ƹ� �ϵ� �Ͼ�� �ʾҴ�.");
		        }
		      }else if(menu==2){
		        rand=Random();
		        if(rand%10==0){//������ ���ư����� 10�ۼ�Ʈ�� Ȯ���� ���Ϳ��� ������ �޾� ������ ������ ����ȴ�.
		          System.out.println("\n������ �����̴�!!");
		          i+=Fight(u,i);
		        }else
		        return i;
		      }else if(menu==3){//���� ��Ȳ�� ����ϴ� �Լ��� �ҷ��´�.
		        printstatus(u,i);
		      }else {//�������� ���� �ȳ��� �Ѵ�.
		        System.out.println("\n����ε� �޴��� �Է�����!");
		      }
		    }
		    return i;//�����Ȳ�� �����Ѵ�.
		  }

	public void printstatus(user u,int record){//�÷��̾��� �������ͽ��� ����ϴ� â�̴�.
	    int left=20-record;//������ ���� ���� Ŭ��������� Ƚ���̴�.
	    System.out.println("���� �������� ���� ���� Ƚ��: "+left);
	    u.printHp();
	    System.out.println("���ݷ�: "+u.getAtk());
	    System.out.println("���� ���� ����: "+u.getPotion());
	    System.out.println("���� ���� ��: "+u.getCoin());
	  }
	  public static int Fight(user u,int record){// �����Լ� ������ ���Ϳ��� ����� ����� �Լ���, ����� ���͸� Ȯ���� �����Ȳ�� ���缭  �����Ų��.
		    int menu;
		    int rand=Random(); 
		    monster m;
		    int win=0;//�������� �¸��� 1�� ��ȯ�� �߰������� �� �����ϰ�, ���ֽ� 0�� ��ȯ�޾� �߰� ���� ���� ����ȴ�.
		    if(record>17){//�����Ȳ�� ���� ���� �����̴�.
		    	m=new monster(0);
		    }else if(rand%20==0){//Ȯ���� ���� ���� �����̴�.
		    	m=new monster(0);
			}else if(rand%3==0){
				m=new monster(1);
			}else{
				m=new monster(2);
		    }
		    
		    System.out.println("�߻��� "+m.getName()+"�� ��Ÿ����!!");
		    for(;m.getHp()>0;){
		    	rand=Random(); 
		    	if(u.getHp()<=0)return 0;
		    	System.out.printf("�̸�: %s\n���ݷ�: %d\n",m.getName(),m.getAtk());
		    	m.printHp();
		    	menu=fightmenu(u);//�����޴����� �����ൿ�� �޾ƿ´�.
		    	if(menu==1){//���ݽ� ������ ����ؼ� ġ��Ÿ�� ������.
		        rand=Random();
		        if(rand%33==0){//���͸��� ġ��Ÿ Ȯ���� �޽����� �ܾ �ٸ��� ������ ������ �Լ��� ������ �ʾҴ�.
		          System.out.printf("%s���� %dġ������ �λ��� ������.\n",m.getName(),u.getAtk()+u.getAtk()/2);
		          m.damage(u.getAtk()+u.getAtk()/2);
		        }else{
		          m.damage(u.getAtk());
		        }
		      }else if(menu==2){
		        u.usePotion();
		        
		      }else{
		        rand=Random();
		        if(rand%6==0){//���Ϳ� ���� ����ĥ �� �ִ� Ȯ���� �޶� ������ ����.
		          System.out.println("����ġ�µ� �����ߴ�.");
		        }
		        else{
		          System.out.println("����ġ�µ� �����ߴ�.");
		          return 0;//���ֽ� ���ָ� ǥ���� 0�� ��ȯ�Ѵ�.
		        }
		      }rand=Random();
		      if(rand%3==1){//���Ϳ��� �����ൿ ���Ŀ� Ȯ�������� ���ݹ޴´�.
		    	  u.damage(m.Atk());
		    	  System.out.println("///\n������ �޾� HP�� �����g��!");
		    	  u.printHp();
		      }
		  }
		    System.out.println("\n"+m.getName()+"�� ��ġ����.");//���͸� hp�� 0���Ϸ� ���� ��� �¸��Ѵ�.
		    u.gCoin(m.getMoney());//�� ���� ������ ����Ͽ� �����Ѵ�.
		    
		    
		    return win;//���и� ��ȯ�Ѵ�.
		    
	  }
	  public static int fightmenu(user u){ //������ �� ������ �ɷ�ġ �� �̸��� ������ �ְ� �޴°� ���� �ݺ��Ǵ� �κ��� ���� ����â�� ����ȭ ��Ű�����ؼ� ������ �Լ��� �����Ͽ���.
		    int menu;
		    for(;;){
		      System.out.println("\n\n���� ���� ü��: "+u.getHp()+"/50");
		      if(u.getHp()<7)
		      System.out.println("������ ��������.");//�پ��� ��Ȳ�� ���� ��̸� �ֱ����� �޽���
		      System.out.println("1. �����Ѵ�.");
		      System.out.println("2. ������ ����Ѵ�.\n  ���� ���� ���� ��:"+u.getPotion());
		      System.out.println("3. ����ģ��.");
		      menu=input();//�޴� �Է¹޴°��� ����ȭ��Ų��.
		      if(menu!=1&&menu!=2&&menu!=3){//������ �޴� �̿��� �������� �����Ͽ� �޽����� ����.
		       System.out.println("������ ��Ȳ�̴� �峭�� ġ�� ����.");
		      }else return menu;//������ �����ൿ�� ���� �� ���ͺ� ���� �Լ��� �ѱ��.
		    }
		  }
}
