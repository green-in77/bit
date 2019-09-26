import kr.or.bit.Pclass;

/*
public , default , private , protected 등장
상속관계에서 protected
양면성 : 박쥐 ( default , public )
증명 : 상속이 없는 클래스 안에서 protected 접근자는 default 와 같다.
why) 상속이 없는 상황에서는 protected 접근자는 의미가 없다.
  
  
 */

class Dclass {
	private int i;
	public int j;
	protected int k; // 상속없는 클래스 안에서는 default 와 같기때문에 이렇게 사용하지 않음.
	// 상속관계가 아니면 protected 를 쓰지 않는다...
	int p;
}


class Child2 extends Pclass { 
	void method() {
		this.k = 1000; //protected 상속 관계에서는 public 과 같은 성격(접근 가능)
	}
}


public class Ex08_Inherit_Protected {

	public static void main(String[] args) {
		Pclass p = new Pclass();
		Child2 c = new Child2();
		//c.k 는 안보임(접근불가) // protected ( default 와 같은 성격)
		c.method();
		
		Dclass d = new Dclass();
		d.j=1;  // public 
		d.p=2; //default
		d.k = 3; // protected ( 같은 패키지 안에서는 default )
		
		
	

	}

}
