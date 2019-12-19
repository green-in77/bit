package Quiz;

import java.io.Serializable;
import java.util.Scanner;


public class BMI implements Serializable{ //�ڡ� ����ȭ �ſ� �߿�!!
	private double length = 0; // Ű����
	private double weight = 0; // ������ ����
	private double result = 0; // BMI ��ġ ����
	private String you = null; //BMI ����� ����
	
	public BMI input(BMI bmi){ //BMI ��ü�� parameter�� �޾Ƽ� ���� �Է�
		Scanner scan = new Scanner(System.in);
		System.out.print("Ű�� �Է��ϼ��� : ");
		this.length = scan.nextInt();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		
		this.weight = scan.nextInt();
		
		this.result = this.weight/((this.length/100.0)*(this.length/100.0)); // BMI ��ġ ����ؼ� result 
		
		if(this.result<18.5){ // �Ҵܵ� BMI ��ġ�� �������� ��
			this.you = "ü�� ����";
		}else if(18.5<=this.result && this.result<=22.9){
			this.you = "����";
		}else if(23.0<=this.result && this.result<=24.9){
			this.you = "��ü��";
		}else if(25.0<=this.result){
			this.you = "��";
		}
		return bmi;
	}

	public double getLength() { // Ű getter
		return length;
	}

	public void setLength(double length) { // Ű ������ �� �ְ� setter
		this.length = length;
	}

	public double getWeight() { // ������ getter
		return weight;
	}

	public void setWeight(double weight) { //������ ������ �� �ְ� setter
		this.weight = weight;
	}

	public double getResult() { // BMI ��ġ getter
		return result;
	}

	public void setResult(double result) { // result ������ �� �ְ� setter (������??)
		this.result = result;
	}

	public String getYou() { // BMI ����� ����
		return you;
	}

	public void setYou(String you) {
		this.you = you;
	}

	@Override
	public String toString() { //�ѹ��� ����ؼ� �� �� �ְ� 
		return length+"\t"+weight+"\t"+result+"\t"+you;
	}
	
	
}//class
