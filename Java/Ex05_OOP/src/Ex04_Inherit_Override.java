/*
 Today Point : [상속관계] 에서 override : 상속관계에서 메서드 [재정의] // 상속이 없으면 override 가 없음.
 -상속 관계에서 자식클래스가 부모클래스의 메소드를 재정의(내용바꿈)
 재정의 의미 : 틀의 변화(함수의 이름과 , return type 의 변화가 아니라 {내용}의 변화
 문법)
 1. 부모함수 이름 동일
 2. 부모함수 parameter 동일
 3. 부모 함수 return type 동일
 4. 내용만 바꾸는 것.
 */

class Point2{
	int x = 4;
	int y = 5;
	String getPosition() {
		return "x: " + this.x + "y : " + this.y;
	}
}

class Point3D extends Point2 {
	//int x; 상속관계 부모가 가지는 x,y 를 쓰자.
	//int y;
	int z = 6;
	
	// ↓↓↓↓↓  Annotation은 Java code만으로 전달할 수 없는 [부가적인 정보]를 [컴파일러]나 [개발툴]로 전달할 수 있다.
	//@Override >> Annotation >> 재정의 검사하는 기능
	// 재정의를 하면 자식입장에서 원래 부모의 함수로 접근할 수 없음. 재정의 한 함수만 접근가능. -> 그래서 super 가 나옴.
	
	@Override
	String getPosition() {
		return "x : " + this.x + ", y : " + this.y + ", z : " + this.z;  //super.getPosition(); // super == 부모
	}
	
	//부모가 함수를 가지고 있고.. 이름도 마음에 든다!!!
	//부모의 함수와 틀이 똑같음. 내용만 변경
	//재정의
	//String getPosition() { //오버라이딩
		//return "x: " + this.x + " y : " + this.y + " z : " + this.z;
	//}
	
	
	
}


public class Ex04_Inherit_Override {

	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println(p3.getPosition());

	}

}
