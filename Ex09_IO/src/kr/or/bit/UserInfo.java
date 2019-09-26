package kr.or.bit;

import java.io.Serializable;

//객체통신
//객체를 네트워크, [파일]간에, 프로세스간에 통신
//직렬화 : 객체를 분해해서 줄을 세워 보내는 과정
//역직렬화 : 객체를 다시 조립하는 과정

//실습
//대상 >> 파일 > 객체 write(직렬화)
//대상 >> 파일 > 객체 read(역직렬화)

//레고.. implements Serializable  구현하는 클래스만 직렬화 가능
public class UserInfo implements Serializable{
	private String name;
	private String pwd;
	private int age;
	
	public UserInfo() {}
	public UserInfo(String name, String pwd, int age) {
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
	}
	
	

}
