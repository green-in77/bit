package kr.or.bit.dto;

public class Roomdto { //채팅방정보
	private String name; //채팅방이름
	private int limit; //정원
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	@Override
	public String toString() {
		return "Roomdto [name=" + name + ", limit=" + limit + "]";
	}
	
}
