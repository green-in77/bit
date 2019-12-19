import java.util.Calendar;
import java.util.Date;

import kr.or.bit.utils.Edu_Date;

/*
* Calendar �� ��ӹ޾� ������ ������ Ŭ������ 
 * GregorianCalendar
   buddhisCalendar �ִµ� getInstance()�� [�ý����� ������ ��������]�� [Ȯ��]�ؼ�
      �±��� ��� buddhisCalendar �� �ν��Ͻ��� ��ȯ�ϰ� �� �ܿ��� GregorianCalendar
     �� �ν��Ͻ��� ��ȯ�Ѵ�
   GregorianCalendar �� Calendar�� ��ӹ޾� ���ó� ������ �������� ����ϰ� �ִ� 
   �׷����¿� �°� ������ ������ �±��� ������ ������ ���������� GregorianCalendar ���
   �׷��� �ν��Ͻ��� ���� �����ؼ� ������� �ʰ� �޼��带 ���ؼ� �ν��Ͻ��� ��ȯ�ް��ϴ�
   ������ �ּ��� �������� ���α׷� ������ �ϵ��� �ϱ� ����
   class MyApp{
     static void main(){
      Calendar cal = new GregorianCalendar();
      �ٸ� ������ ������ ����ϴ� �������� �����ϸ� ����......    }  }
   class MyApp{
     static void main(){
      Calendar cal = new getInstance();
        �ٸ� ������ ������ ����ϴ� �������� �����ϸ� ����......   }  }
  API : ������ Protected Calendar() 
 */
//Java API
//��¥ : Date (��) -> Calendar(��)

public class Ex08_Calendar {
	public static void main(String[] args) {
		
		Date dt = new Date(); // ������
		System.out.println(dt);
		
		Calendar cal = Calendar.getInstance(); //PC�� ���������� ���� �±��̸� �±��� ����/ �� �ܴ� �׷����� ���� ���� 
		System.out.println(cal);
		// ����� �ʿ��� �ð��� ���� ������ �������� �ٰ�..( ������ �̾Ƽ� ��..)
		
		System.out.println("�⵵ : " + cal.get(Calendar.YEAR));
		System.out.println("��(0~11) : " + (cal.get(Calendar.MONTH)+1));
		System.out.println("�� : " + cal.get(Calendar.DATE));
		System.out.println("�� ���� ���° �� : " + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("������ �̹����� ���° �� : " + cal.get(Calendar.DAY_OF_WEEK)); // �Ͽ��Ϻ���~
		
		//PC�� �ð�
		System.out.println("�� : " + cal.get(Calendar.HOUR));
		System.out.println("�� : " + cal.get(Calendar.MINUTE));
		System.out.println("�� : " + cal.get(Calendar.SECOND));
		
		System.out.println("AM/PM : " + cal.get(Calendar.AM_PM)); // 0 �� AM / 1 �� PM
		
		//������Ʈ(�п����� ����Ʈ)
		// 200��... 150p �̻󿡼��� ��¥�� ��.. ( ���� �� 150�� ����...)
		// ��¥ ���õ� Ŭ���� : Ư�� �Լ� ȣ�� : ȭ�� ��¥ ���
		// class MyDate { static void todate(){} }
		// Mydate.todate();
		
		String date = Edu_Date.DateString(Calendar.getInstance());
		System.out.println(date);
		
		date = Edu_Date.DateString(Calendar.getInstance(), "-");
		System.out.println(date);
		
		date = Edu_Date.monthFormat_DateString(Calendar.getInstance());
		System.out.println(date);
		
		
	}

}
