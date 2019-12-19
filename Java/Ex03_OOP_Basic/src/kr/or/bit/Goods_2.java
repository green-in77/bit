package kr.or.bit;
/*
 상품은 바코드(int 101010101), 가격(int 1000),
 상품명(String 이름, 상품종류(String 종류), 할인유무(String "할인상품"/"비할인상품")을가지고 있다
 
상품을 등록하려면 반드시 바코드, 가격, 상품명, 상품종류, 할인유무를 가지고 있어야 한다.

상품의 이름, 바코드, 상품 종류는 특정기능을 통해서만 볼 수 있으며 상품이 등록된 이후 수정 불가능하다.

상품의 가격, 할인유무는 등록된 이후 수정이 가능하다.

바코드, 가격, 상품명의  정보는 확인 가능하다.

 */
public class Goods_2 {
	private int  barcode; // 바코드
	private int goodsprice; // 가격
	private String goodsname; // 상품명
	private String goodskind; // 상품종류
	private String goodsdiscount; // 할인유무
	
	public Goods_2(int barcode, int goodsprice, String goodsname, String goodskind, String goodsdiscount ){ //바코드,상품가격,상품명,상품종류,할인유무 
		this.barcode = barcode;
		this.goodsprice = goodsprice;
		this.goodsname = goodsname;
		this.goodskind = goodskind;
		this.goodsdiscount = goodsdiscount;
	}
	
	public void Goods_print() {
		System.out.printf("상품명 : %s, 바코드 : %d, 상품종류 : %s \n",this.goodsname, this.barcode, this.goodskind);
	}

	public void setGoodsprice(int goodsprice) { // 상품가격 수정
		this.goodsprice = goodsprice;
	}

	public void setGoodsdiscount(String goodsdiscount) { // 상품할인정보 수정
		this.goodsdiscount = goodsdiscount;
	}
	

	public int getGoodsprice() { // 상품가격 확인
		return goodsprice;
	}

	public int getBarcode() { // 바코드 확인
		return barcode;
	}

	public String getGoodsname() { // 상품명 확인
		return goodsname;
	}	
}
