package Quiz;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BMICheck {
	static HashMap<Integer, BMI> map = new HashMap<Integer, BMI>(); // hashmap ��ü����
	// map �� ������ ���� Ű(�ߺ��Ұ�)�� ��(�ߺ�����)�� ¦���� �Ǿ�����.
	
	static int count = 1;
	static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		BMICheck bc = new BMICheck(); // BMICheck ��ü ����
		while(true){
		System.out.println("�񸸵� �����մϴ�!!!!");
		System.out.print("<1>�߰� <2>���� <3>��� <4>���� <5>�ε� <6>���� : ");

		switch (scan.nextInt()) {
		case 1:
			bc.add(); // map ��ü�� BMI �߰��ϴ� �Լ�
			break;
		case 2:
			bc.delete(); // map ��ü�� ����� �� ����
			break;
		case 3:
			bc.print(); // �ܼ����
			break;
		case 4 :
			bc.save(); // map ��ü�� ����ȭ�ؼ� ���Ϸ� ����
			break;
		case 5:
			bc.load(); // ����ȭ�ؼ� �����ߴ� map ��ü�� ������ȭ�ؼ� �о����!
			break;
		case 6:
			bc.exit(); // �ý�������
			break;

		}// switch
		}//while
	}// main

	private void save() { // �޸𸮿� ����� �����͸� ���Ϸ� �����ϴ� �Լ�
		File file = new File("bmi.txt"); // ������ ���鲨��!!!
		try{
			FileOutputStream fos = new FileOutputStream(file); // ���Ϸ� �������� 1byte ¥�� ��ü.
			ObjectOutputStream oos = new ObjectOutputStream(fos); // ��ü�� ����ȭ�ؼ� ���Ͽ� ������ ����.
			
			oos.writeObject(map); // map ��ü�� ����ȭ�ؼ� ����..
			
			oos.close(); // �� �����ϱ� �ݾ��ְ�...
			fos.close();
		}catch(Exception e){ // ���ܹ߻���..
			System.out.println("�����߻�!!!");
			e.printStackTrace();
		}
		System.out.println("����Ǿ����ϴ�.");
	}

	private void exit() { // �ý��� ���� �Լ�
		System.out.println("�ý����� �����մϴ�.");
		System.exit(0);
		scan.close(); // ��ĳ�ʵ� �ٽ����� �ݾ��ֱ�!
	}

	private void print() { // �ֿܼ� ������ִ� �Լ�
		Set<Integer> set = map.keySet(); // map �� ����� ket ���� set ���� ���� return
		System.out.println("��ȣ\tŰ\t������\t���\t����");
		for (Integer number : set) { //map �� ����ƴ� key���� ���ڸ�ŭ..
			double length = map.get(number).getLength(); // number �� Ű���� ����Ǿ������ϱ�... �װ� ��������map �� ã�ư��� Ű,������,BMI ��, BMI ��� ��������
			double weight = map.get(number).getWeight();
			double result = map.get(number).getResult();
			String you = map.get(number).getYou();

			System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you); // ���
		}
	}

	private void delete() { // �����͸� �����ϴ� �Լ�
		System.out.print("�����Ͻ� �ѹ��� �Է��� �ּ��� : ");
		int num = scan.nextInt();
		if (map.containsKey(num)) { //map �� ����� count (Ű) ���� �������� �Է¹��� ��ȣ�� ���Ե� �����Ͱ� ������
			map.remove(num); // Ű������ �ش� ��ȣ�� ã�Ƽ� ������ ����.
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("���ѹ��� �߸��Է��ϼ̽��ϴ�. �ش� ������ �����ϴ�.");
		}
	}

	private void add() {
		BMI bmi = new BMI(); //BMI ��ü ����
		map.put(count, bmi.input(bmi));
		// bmi Ŭ������ input �Լ� ȣ�� : Ű,������,BMI ��ġ, BMI ����� �� ����� bmi ��ü�� �ּҰ� return
		//map �� 1�� Ű������ �Լ����� ���ϵ� bmi ��ü�� �ּҰ��� ����.
		count++;
	}
	
	private void load() {
		File file = new File("bmi.txt"); //���� ����
		try{
			FileInputStream fis = new FileInputStream(file); //������ ���� �� �ִ� 1byte ¥��
			ObjectInputStream oos = new ObjectInputStream(fis); // ������ȭ �ؼ� �о����!
			
			map = (HashMap)oos.readObject(); // ������ȭ�ؼ� ������ƮŸ������ ���⶧���� hashmap ���� �ٿ�ĳ�����ؼ� ����
			
			Set<Integer> set = map.keySet(); // map �� ����� key ���� set ���� �����ؼ� return
			System.out.println("��ȣ\tŰ\t������\t���\t����");
			for (Integer number : set) { // ����� set ������ map ���
				double length = map.get(number).getLength();
				double weight = map.get(number).getWeight();
				double result = map.get(number).getResult();
				String you = map.get(number).getYou();

				System.out.printf("[%s]\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
			}
			oos.close(); // ������ �ݾƾ���.
			fis.close();
			
		}catch(Exception e){ // ������ ���ٸ�....
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
}// class
