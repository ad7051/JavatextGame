package test0513;

import java.util.Scanner;

public class menu {
	static user u=new user();
	static Fightmenu m= new Fightmenu();
	public static int input(){ //���ڸ� �Է� �޴°��� scanner ����ü�� �Ź� �Լ����� �������� ������ �۵����� �ʾ� �������� ���̱� ����, �Է¹޴��Լ��� ������ �������.
	    Scanner keyboard = new Scanner(System.in);
	    return keyboard.nextInt();//�Է��� ���� ���� ��ȯ�Ѵ�.
	  }
	public int Menu() {	
		int menu=0;
		int record=0;
		System.out.printf("������ ���� �������! ����� ���ݺ��� ����Դϴ�.\n");
		System.out.println("�׷���, �� ������ ����Դϴ�! �ڼ��� ���� �Ʒ��� �޴��� ���ؼ� Ȯ���� �ּ���!");
		for(;;) {
			System.out.println("���� �ְ� Ž�� Ƚ�� "+record+"ȸ");//���������� �ְ� ���� ����� ����Ѵ�.
			System.out.println("1. �������� ������ ������!");
			System.out.println("2. �������� ������ ����!");
			System.out.println("3. �׸� �ҷ�.");
			menu=input();
			if(menu==1) {
				System.out.printf("������ ����\n");
					record=m.stage(u);//�ְ� ����� ���� ��Ȳ�� ����Ѵ�.
						if(record==-1){//����� ����� -1�� ��µǾ� ������� ǥ���ϰ� ����ȴ�.
							System.out.println("�ɸ��ʹ� ���� ���� ���������ϴ�.");
							return -1;
						}else if(record>=20){//������ ��ǥ����ġ ���� �����Ͽ� �Ϸ��ϰԵǸ� �Ϸῡ ���� ���ϰ� ������ ����ȴ�.
							System.out.println("����� ������ �̹� ������ �����Ͽ����ϴ�.");
							System.out.println("�÷��� ���ּż� �����մϴ�!");
							return 2;
						}
			}else if(menu==2) {//���� �Լ��� �ҷ��´�.
				System.out.printf("������ ����\n\n");
				store();
			}else if(menu==3) {
				return 0;
			}else {
				System.out.println("����ε� �޴��� �Է�����");//�߸��� �Է¿� ���� �ȳ� �޽����̴�.
			}
		}
	 }
	public static void store(){//������ �����ؼ� �ɷ�ġ�� ��ȭ��Ű�� �����̴�.
		int menu;
		System.out.println("������ � ������!");
		for(;;){
			System.out.println("\n�������� ������ ����ּ���!");
			System.out.println("1. ����(HP�� 5ȸ�� ��Ų��.) : 2coin");
			System.out.println("2. ��ö��(���ݷ��� 7�� �����ش�) : 5coin");
			System.out.println("3. �ٷ� ��ȭ��(���ݷ��� 1�����ش�) : 10coin");
			System.out.println("0. ������");
			System.out.println("���� ���� �� : "+u.getCoin());
			menu=input();
			if(menu==1){//�޴��� ���� ���� ���� ����Ǿ� ��µȴ�.
				if(u.getCoin()<2)System.out.println("���, �� ���� ���ݾ�! �� ������ ����!!");//���� ���ġ ������� ���Ű� �Ұ��ϰ� ��� ���´�.
				else{
					u.useCoin(2);
					System.out.println("������ �����ߴ�.");
					u.buyPotion();
					System.out.println("������ �� ���ð�!!");
		        	}//���� ����� ��� ���Ű� �����ϴ�.
		      	}else if(menu==2){
		      		if(u.getCoin()<5)System.out.println("���, �� ���� ���ݾ�! �� ������ ����!!");
		      		else{
		      			u.useCoin(5);
		      			System.out.println("��ö���� �����ߴ�.");
		      			u.useSword(7);
		      			System.out.println("������ �� ���ð�!!");
		      		}
		      	}else if(menu==3){
		      		if(u.getCoin()<10)System.out.println("���, �� ���� ���ݾ�! �� ������ ����!!");
		      		else{
		      			u.useCoin(10);
		      			System.out.println("�ٷ� ��ȭ���� �����ߴ�.");
		      			u.upAtk(1);
		      			System.out.println("������ �� ���ð�!!");
		      		}
		      	}else if(menu==0){//�޴������ �ȳ� �޽����� ���´�.
		      		System.out.println("�� ���ð�!!");
		      		break;
		      	}else{//�߸��� �Է��� �� �� �޴��� ���������� ����ȴ�.
		      		System.out.println("�峭�� �����ϼ�!");
		      		break;      
		      	}
		}
	}
	
}
