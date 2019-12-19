/*
 ���赵 1���� ����� ���� .......���� ����. ������ �ܼ����� ����.
 >> 1�� �̻��� ���赵�� ����� ��.
 ** ������ ** ( �������� ���赵�� ���踦 �ξ��ִ� ��)
 	��Ӱ��� ( is ~ a : ��� ) ��~ �̴�. (�θ� �ڿ� ����)
 
 	���԰��� ( has ~ a : ����) �� ~�� ������ �ִ�.
 
 ex) ��.class , ����.class >> ��� : ���� �����̴�. >> �� extends ����
 ex) ��.class, ��.class >> ���� ���̴�. X -> ���� : ���� ���� ������ �ִ�. >> class �� { �� ������ } >> ��ü�� member field �� ���´�.
 es) ����. �� >> ������ ���̴� X -> ������ ���� ������ �ִ�. >> class ���� { �� ������ }
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

������� ��, �ﰢ��, �簢�� �� ����� ���赵�� �ۼ�
���� �����̴� / �ﰢ���� �����̴� / �簢���� �����̴�

���� : �߻�ȭ, �Ϲ�ȭ �� �ڿ� ( ����, �׸���, ) >> ���� �ڿ�
 �� : ��üȭ, Ư��ȭ �� �ڿ� ( ������, �� ) >> ���θ��� ������ �ִ� �� 
 
 �� : ��ǥ�� (x,y)
 ���� ���� ������ �ִ�.
 �ﰢ���� ���� ������ �ִ�.
 �簢���� ���� ������ �ִ�.
 
 �Ϲ�ȭ(����, �߻�) : shape(�׸���, ����) , point(��)
 class Shape{} // ���
 class Point{} // ����
 
 ��üȭ, Ư��ȭ : circle, triangle
 
 
 */

//�߻�ȭ, �Ϲ�ȭ ( ���� )
class Shape {
	String color = "gold"; // ����Ӽ�
	void draw() { // ������
		System.out.println("�׸���");
	}
}

// �߻�ȭ, �Ϲ�ȭ (����)
class Point {
	int x;
	int y;
	Point() {
		this(1,1); //Point �����ڸ� ȣ���ϴ� this
		//this.x = 1;
		//this.y = 1;
	}
	Point(int x , int y) {
		this.x = x;
		this.y = y;
	}
}
//���� ���弼��. (���� : ������ �������� ������ �ִ�.
//���� �����̴� (is~a)
//���� ���� ������ �ִ�.
//���� Ư���� ������(r)

//���� �������� default ������ 10�� ������.
//���� x, y ��ǥ�� default �� 10,15
//�⺻���� ������ ������ ������ �������� ���� ���� �Է��� �� �ִ�.
class Circle extends Shape {
	int r; //������
	Point center; //�� (���԰���)
	
	Circle() {
		//this.r = 10;
		//this.center = new Point(10,15);
		this(10,new Point(10,15)); // new �� �ּҰ��� �ѱ�.
	}
	
	Circle (int r, Point center){ //Point ��ü�� �ּҰ��� �ްڴ�.
		this.r = r;
		this.center = center;
	}
	// Circle c1 = new Circle(); //������ 10 / x 10, y  15
	// Circle c2 = new Circle(15,new Point(5,5)); // ������ 15, x 5, y 5
	
}
//����1)
//�ﰢ�� Ŭ������ ���弼��.
//����) �ﰢ���� 3���� ���� ���� �׸��� �׸��ٶ�� ����� ������ �ִ�.
//Shape, Point �����޾ƿ�.
//hint) (x,y) (x,y) (x,y) 3���� ��ǥ��
//default �� �׸� �� �ְ�, 3���� ��ǥ���� �޾Ƽ� �׸� �� �ִ�.

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

//���̵� ����(��) Array �� ó���ϱ�
class Triangle2 extends Shape{
	Point[] pointarray; // Point Ÿ���� �迭 ����.
	
	Triangle2 () {
		/*
		pointarray = new Point[3];//�游 ����.
		//��ȿ� �ּ� �־��ֱ�.
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
			System.out.println("��ǥ : " + point.x + ", " + point.y);
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
		
		Circle c = new Circle();  //�⺻��
		c.draw();
		System.out.println(c.color); //��ӹ�����.
		System.out.println(c.r);
		System.out.println(c.center.x); // POINT �ּҰ� .�ּҰ�.��
		System.out.println(c.center.y);
		
		
		Circle c2 = new Circle(5, new Point(5,5)); // ��ǥ���� ������ ��.
		System.out.println(c2.color); //��ӹ�����.
		System.out.println(c2.r);
		System.out.println(c2.center.x); // POINT �ּҰ� .�ּҰ�.��
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
