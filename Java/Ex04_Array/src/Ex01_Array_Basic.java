import java.util.Arrays;

//�迭�� ��ü��.
// new �� ����, �����Ǵ� �޸𸮴� heap.
//����(����) �迭 ( ũ�Ⱑ ����) >> ���� ������ collection (�����迭)
public class Ex01_Array_Basic {
	public static void main(String[] args) {
		//int score  = 10, score2=20, score3=30, score4=40...; //�� Ÿ�� ���� �� �ʱ�ȭ.
		int[] score = new int[3]; // score �� �ּҰ��� ���� ��������
		System.out.println("score ����(heap �޸� score �ּ�) "+score);
		//score �迭�� ���� �ּҰ��� ����.
		//Array �� ������ ���� ������ �ִ�. (���� int ũ��)
		//������ ���� ���� : ÷��, index >> 0���� ���� >> ���۰� 0
		//�迭�� Ÿ���� �⺻���� �ʱⰪ���� ���´�. (int = 0)
		
		System.out.println(score[0]); //0
		System.out.println(score[1]); //0
		System.out.println(score[2]); //0
		
		score[1] = 1111; // �迭�� 1�濡 ���� ���� 1111�� ����
		
		System.out.println(score[1]); //1111
		
		//score[3] = 5000;
		//java.lang.ArrayIndexOutOfBoundsException : 3 -> �迭�� �� ������ �Ѿ���.
		// ���ܰ� �߻��߽��ϴ�. .... �׷��� ���α׷��� ������ �����ϰڽ��ϴ�.
		//try catch ..-> ������ �����ϴ� ���� �ƴ϶� ���α׷��� �������Ḧ ����.
		
		//Array ������ ���� ���� ��� = for�� 
		for ( int i = 0; i < 3; i++) {
			System.out.printf("[%d] = %d\t",i , score[i]);
		}
		
		System.out.println();
		
		for (int i = 0 ; i < score.length ; i++  ) { // scre.length = �迭�� �� ����
			System.out.printf("[%d] = %d\t", i, score[i]);
		}
		
		System.out.println();
		
		// Tip Array �����ִ� ����Ŭ���� ( helper class)
		String result = Arrays.toString(score); // ó�� �ϴ� ����� �ݱ�...
		System.out.println(result); // [ 0, 1111, 0]
		
		Arrays.sort(score); // ���� ���� -> ū
		result = Arrays.toString(score);
		System.out.println("sort : " + result); // [0, 0, 1111]
		
		// Today Point
		// �迭�� ����� ��� 3���� (�����迭, �����迭)
		int[] arr1 = new int[5]; // �⺻ ( ���� ������ ����)
		int[] arr2 = new int[] {100,200,300}; // �ʱⰪ�� ��Ȯ�Ҷ� �ʱⰪ ����
		int[] arr3 = {11,22,33,44,55}; // �����Ϸ��� �˾Ƽ� new �ڵ�����..
		// javascript : let cars = [11,22,33,44,55]
		// ���� ������ ó�� �������� �߰��� �� ����ų� ���ְų� �� �� ����.
		
		for (int i = 0 ; i < arr3.length ; i++ ) {
			System.out.println(arr3[i]);
		}
		
		//��ü ���� �Ҵ��� �и�
		// Car c; // ����
		// c = new Car(); //�Ҵ�
		
		//�迭�� ��ü��
		int[] arr4; //����
		arr4 = new int[] {21,22,23,24,25}; //�Ҵ� : arr4 ��� ������ �ּҰ��� �ѱ�� ��.
		
		int[] arr5 = arr4; // �ּҰ� �Ҵ�
				
		System.out.println(arr5 == arr4);
		
		String[] strarray = new String[] {"��", "��", "�ٶ�"};
		char[] ch = new char[10]; // �⺻�� ���� '\u0000'
		for (int j = 0 ; j < ch.length; j++) {
			System.out.println(">" + ch[j] + "<");
		}
		
		// 8���� �⺻Ÿ�� + String			Array ��������
		//�ڡڡڡڡڡڡڡڡڡڡڡ� Ŭ������ �迭 ���� ���� �ڡڡڡڡڡڡڡڡ�
		// Ŭ���� == ���赵 == Ÿ��
		//�ڵ��� 10��
		// Car[] c = new Car[10];
		
	}
}
