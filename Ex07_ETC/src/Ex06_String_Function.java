import java.util.StringTokenizer;

// String Ŭ���� ( ���ڿ� )
// ���ߴܿ��� ���ڿ��� �ٷ�� �ڵ�...(String �Լ�)
// String Ŭ������ static  �Լ� + �Ϲ��Լ�(public)

// �߿� ( �ϱ� )... 10��...
public class Ex06_String_Function {
	public static void main(String[] args) {
		String str = ""; //���ڿ��� �ʱ�ȭ. //�ʱ�ȭ ������ null
		
		String[] strarr = {"aaa","bbb","ccc"};
		for (String s : strarr) {
			System.out.println(s);
		}
		
		//�Լ�
		String ss = "hello";
		//concat ���ڿ� ��ġ��.
		String concatstr = ss.concat(" world"); // concat => ss�� ���ڿ��� ���� ���ڿ��� ��ġ�� ��.
		System.out.println(concatstr);
		
		//contains ���ӵ� ���ڿ��� �����ϰ� �ִ��� ���� �Լ�.
		System.out.println(ss.contains("h")); // ss�� h�� �����ϰ� �ִ°� : true
		System.out.println(ss.contains("heo")); //ss �� ���ӵ� heo�� �����ϰ� �ִ°� : false
		
		String ss2 = "a b c d"; // heap char[] [a][ ][b][ ][c][ ][d]
		System.out.println(ss2.length());//�ڡ� length �ܿ�� ���ڿ��� ����. // 7 ( ���鵵 ����)
		
		String filename = "hello java, world";
		System.out.println(filename.indexOf(","));//�ڡ� indexOF �ܿ�� �ش� ������ index ��. // 10 ( index 0������~)
		System.out.println(filename.indexOf("java")); // java �� ù �������� j�� index �� // 6
		System.out.println(filename.indexOf("jeva")); // �ܾ� �������� ã�� ������ ���� �ܾ�� ã�� ����. //����� -1 / �迭���� ���� ���� �ǹ�. 
		
		// 0���� ū ���� �����ϸ� ���ڿ� ���ϴ� �ܾ ����.
		if ( filename.indexOf("hello") >= 0 ) {
			System.out.println("hello ���ڰ� ���ԵǾ� �ֽ��ϴ�.");
		}
		System.out.println(filename.lastIndexOf("a")); // ���ڿ� �� ������ a�� index ��.// 9
		
		// �ڡ� �ܿ�� length, indexof, substring, replace, split..
		
		String result = "superman";
		System.out.println(result.substring(0)); //superman
		System.out.println(result.substring(2)); //perman
		System.out.println(result.substring(0,0)); // endIndex -1 -> (0,-1) ���� ������ ����.
		System.out.println(result.substring(0,1)); // endIndex -1 -> (0,0) s
		System.out.println(result.substring(1,1)); // endIndex -1 -> (1,0) ���� ������ ���� �Ųٷ� ��..
		System.out.println(result.substring(2, 3)); // endIndex -1 -> (2,2) p
		
		System.out.println();
		
		//Quiz
		String filename2 = "bread.jpg"; // hong.png, 1.txt
		//���⼭ ���ϸ�� Ȯ����� �и��ؼ� ���.
		int i2 = filename2.lastIndexOf(".");
		System.out.println(filename2);
		System.out.println(filename2.substring(0, i2));
		System.out.println(filename2.substring(i2+1, filename2.length())); // ������ ������ ������ �Ŷ�... length �Ƚᵵ �������...
		System.out.println(filename2.substring(++i2)); //Ȯ����...
		
		//replace (ġȯ�Լ�)
		String s4 = "ABCDADDDA";
		String result4 = s4.replace("A", "�ȳ�");
		System.out.println(result4); //A�� ��ġ�� �ȳ����� ġȯ.
		
		// chartAt()
		System.out.println(s4.charAt(0)); // �ش� index �� ����ִ� char ����
		System.out.println(s4.charAt(3));
		
		System.out.println(s4.endsWith("DDA")); // ������ �ش� ���ڸ� ������ �ִ��� true
		System.out.println(s4.endsWith("DDD")); // ������ �ش� ���ڸ� ������ �ִ��� false
		
		System.out.println(s4.equalsIgnoreCase("ABcdAdddA")); // ��ҹ��� ���� ���� ���� ������ Ȯ��.
		
		// POINT : split
		String s6 = "���۸�,��Ƽ,�����,������,������";
		String[] namearray = s6.split(","); // �ش� ���ڸ� �������� �и��ؼ� �迭�� return
		for (String name : namearray) {
			System.out.println(name);
		}
		
		String filename3 = "bit.hwp";
		String[] filearray = filename3.split("\\."); // \ �ڹ��� ����ǥ�� �ν� ��ȣ + \. ���� ����ǥ��
		for (String name : filearray) {
			System.out.println(name);
		}
		// ����ǥ����... (Java, javascript, db �� ���)
		//Ư���� ���ڷ� ���ϼ��� >> ������ �������� >> ��ȿ�� ����
		// �ֹι�ȣ, ��ȭ��ȣ, �ڵ�����ȣ, ������ȣ, �����ȣ ...
		
		// 010-{\d4}-0000 ����ǥ���� >> {\d4}  d �� ������ 4�ڸ�.
		// 010-456-0000 -> 456�� ����ǥ���Ŀ� ������ false
		
		// ���� ī�信... ( ����ǥ���� 5�� ����� )
		// ������.....��...?
		
		String s7 = "a/b,c.d-f";
		StringTokenizer sto = new StringTokenizer(s7,"/,.-"); // �ش� ���ڸ� ���� �и���������...
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		//�ͼ��� quiz
		String s8 = "ȫ           ��      ��";
		//  ���� > "ȫ�浿" ��������
		System.out.println(s8.replace(" ","")); // ������ ������ ���� ������ ġȯ...
		
		String s9 = "                ȫ�浿           ";
		System.out.println(">"+s9+"<");
		System.out.println(">"+s9.trim()+"<"); // �¿� ���� ������.
		
		
		String s10 = "          ȫ        ��   ��          ";
		System.out.println(">"+s10.replace(" ","")+"<"); // ������ ������ ���� ������ ġȯ...
		
		//�������� �Լ��� �����ؼ� (chain)
		//method chain ���***************************************
		
		System.out.println(s10.trim().replace(" ",""));
		
		//Quiz-1
		int sum=0;
		String[] numarr = {"1","2","3","4","5"};
		// ���� : �迭�� �ִ� ���ڰ����� ���� sum �� ��Ƽ� ���
		/*
		for (int j = 0 ; j < numarr.length ; j++) {
			sum += Integer.parseInt(numarr[j]);
		}
		System.out.println(sum);
		*/
		for (String s : numarr) {
			sum += Integer.parseInt(s);
		}
		System.out.println(sum);
		
		//Quiz-2
		String jumin = "123456-1234567";
		jumin=jumin.replace("-","");
		System.out.println(jumin);
		
		sum = 0;
		
		//substring
		for ( int j = 0; j < jumin.length();j++) {
			sum += Integer.parseInt(jumin.substring(j,j+1));
		}
		System.out.println(sum);
		
		/////////////////////////////////////////////////////////////////////�����	
		int sum2=0;
		
		   for(int i = 0 ; i < jumin.length() ; i++) {
			   String numstr =jumin.substring(i, i+1);
			   if(numstr.equals("-")) continue; // -�� ������ ��ŵ.
			   sum2+= Integer.parseInt(numstr);
		   } 
		   System.out.println("�ֹι�ȣ ��:" + sum2);
		   
		 //�� �ֹι�ȣ�� ���� ���ϼ���_2
		   String[] numarr2 = jumin.replace("-","").split("");
		   int sum3=0;
		   for(String i : numarr2) {
			   sum3+= Integer.parseInt(i);
		   }
		   System.out.println("�ֹι�ȣ ��2:" + sum3);
		   
		 //�� �ֹι�ȣ�� ���� ���ϼ���_3
		   String jumin4 = jumin.replace("-", "");
		   int sum4=0;
		   for(int i = 0 ; i < jumin4.length() ;i++) {
			   sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
		   }
		   System.out.println("�ֹι�ȣ ��4:" + sum4);
		   ///////////////////////////////////////////////////////////////////////////////
		   
		   //String Ŭ���� (static)
		   // printf (cmd ��忡����)
		   // String >> format �Լ�.. (printf ó��)
		   
		   String str5 = String.format("%d-%s",100,"���ڿ�");
		   System.out.println(str5);
		   
		   
		   
		}
		
	}

