/*
 설계도 1개만 만드는 것은 .......거의 없음. 업무가 단순하지 않음.
 >> 1개 이상의 설계도를 만들게 됨.
 ** 기준점 ** ( 여러개의 설계도를 관계를 맺어주는 것)
 	상속관계 ( is ~ a : 상속 ) 은~ 이다. (부모를 뒤에 붙임)
 
 	포함관계 ( has ~ a : 포함) 은 ~을 가지고 있다.
 
 ex) 원.class , 도형.class >> 상속 : 원은 도형이다. >> 원 extends 도형
 ex) 원.class, 점.class >> 원은 점이다. X -> 포함 : 원은 점을 가지고 있다. >> class 원 { 점 변수명 } >> 객체를 member field 로 갖는다.
 es) 경찰. 총 >> 경찰은 총이다 X -> 경찰은 총을 가지고 있다. >> class 경찰 { 총 변수명 }
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

예를들면 원, 삼각형, 사각형 을 만드는 설계도를 작성
원은 도형이다 / 삼각형은 도형이다 / 사각형은 도형이다

도형 : 추상화, 일반화 된 자원 ( 색상, 그리다, ) >> 공통 자원
 원 : 구체화, 특수화 된 자원 ( 반지름, 점 ) >> 본인만이 가지고 있는 것 
 
 점 : 좌표값 (x,y)
 원은 점을 가지고 있다.
 삼각형은 점을 가지고 있다.
 사각형은 점을 가지고 있다.
 
 일반화(공통, 추상) : shape(그리다, 색상) , point(점)
 class Shape{} // 상속
 class Point{} // 포함
 
 구체화, 특수화 : circle, triangle
 
 
 */

//추상화, 일반화 ( 공통 )
class Shape {
	String color = "gold"; // 공통속성
	void draw() { // 공통기능
		System.out.println("그리다");
	}
}

// 추상화, 일반화 (공통)
class Point {
	int x;
	int y;
	Point() {
		this(1,1); //Point 생성자를 호출하는 this
		//this.x = 1;
		//this.y = 1;
	}
	Point(int x , int y) {
		this.x = x;
		this.y = y;
	}
}
//원을 만드세요. (정의 : 한점과 반지름을 가지고 있다.
//원은 도형이다 (is~a)
//원은 점을 가지고 있다.
//원의 특수성 반지름(r)

//원의 반지름은 default 값으로 10을 가진다.
//점의 x, y 좌표는 default 로 10,15
//기본값의 설정을 원하지 않으면 반지름과 점의 값을 입력할 수 있다.
class Circle extends Shape {
	int r; //반지름
	Point center; //점 (포함관계)
	
	Circle() {
		//this.r = 10;
		//this.center = new Point(10,15);
		this(10,new Point(10,15)); // new 로 주소값만 넘김.
	}
	
	Circle (int r, Point center){ //Point 객체의 주소값을 받겠다.
		this.r = r;
		this.center = center;
	}
	// Circle c1 = new Circle(); //반지름 10 / x 10, y  15
	// Circle c2 = new Circle(15,new Point(5,5)); // 반지름 15, x 5, y 5
	
}
//문제1)
//삼각형 클래스를 만드세요.
//정의) 삼각형은 3개의 점과 색와 그리고 그리다라는 기능을 가지고 있다.
//Shape, Point 제공받아요.
//hint) (x,y) (x,y) (x,y) 3개의 좌표값
//default 로 그릴 수 있고, 3개의 좌표값을 받아서 그릴 수 있다.

class Triangle extends Shape{
	Point point1;
	Point point2;
	Point point3;
	
	Triangle () {
		this(new Point(1,1), new Point(2,2), new Point(3,3));
	}
	
	Triangle (Point point1, Point point2, Point point3){
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}
} 

//난이도 조절(상) Array 로 처리하기
class Triangle2 extends Shape{
	Point[] pointarray; // Point 타입의 배열 선언.
	
	Triangle2 () {
		/*
		pointarray = new Point[3];//방만 만듬.
		//방안에 주소 넣어주기.
		pointarray[0] = new Point(1,2);
		pointarray[1] = new Point(3,4);
		pointarray[2] = new Point(5,6);
		*/
		this(new Point[] {new Point(1,2), new Point(3,4), new Point(5,6)});
	}
	Triangle2(Point[] pointarray){
		this.pointarray = pointarray;
	}
	
	void trianglePoint() {
		for ( Point point : this.pointarray) {
			System.out.println("좌표 : " + point.x + ", " + point.y);
		}
	}
	
}

public class Ex02_Inherit_composition {

	public static void main(String[] args) {
		/*Circle circle = new Circle();
		circle.r = 5;
		circle.center = new Point();
		circle.draw();
		*/
		
		Circle c = new Circle();  //기본원
		c.draw();
		System.out.println(c.color); //상속받은것.
		System.out.println(c.r);
		System.out.println(c.center.x); // POINT 주소값 .주소값.값
		System.out.println(c.center.y);
		
		
		Circle c2 = new Circle(5, new Point(5,5)); // 좌표값을 정의한 원.
		System.out.println(c2.color); //상속받은것.
		System.out.println(c2.r);
		System.out.println(c2.center.x); // POINT 주소값 .주소값.값
		System.out.println(c2.center.y);
		
		
		Triangle t1 = new Triangle();
		t1.draw();
		System.out.printf("x : %d, %d\n",t1.point1.x, t1.point1.y);
		System.out.printf("y : %d, %d\n",t1.point2.x, t1.point2.y);
		System.out.printf("z : %d, %d\n",t1.point3.x, t1.point3.y);
		System.out.println();
		
		Triangle2 t2 = new Triangle2();
		t2.trianglePoint();
		
		System.out.println();
		
		Triangle2 t3 = new Triangle2(new Point[] {new Point(11,22), new Point(33,44), new Point(55,66)});
		t3.trianglePoint();
		
		

	}

}
