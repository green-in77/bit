package kr.or.bit;
/*
 ��ǰ�� ���ڵ�(int 101010101), ����(int 1000),
 ��ǰ��(String �̸�, ��ǰ����(String ����), ��������(String "���λ�ǰ"/"�����λ�ǰ")�������� �ִ�
 
��ǰ�� ����Ϸ��� �ݵ�� ���ڵ�, ����, ��ǰ��, ��ǰ����, ���������� ������ �־�� �Ѵ�.

��ǰ�� �̸�, ���ڵ�, ��ǰ ������ Ư������� ���ؼ��� �� �� ������ ��ǰ�� ��ϵ� ���� ���� �Ұ����ϴ�.

��ǰ�� ����, ���������� ��ϵ� ���� ������ �����ϴ�.

���ڵ�, ����, ��ǰ����  ������ Ȯ�� �����ϴ�.

 */
public class Goods_2 {
	private int  barcode; // ���ڵ�
	private int goodsprice; // ����
	private String goodsname; // ��ǰ��
	private String goodskind; // ��ǰ����
	private String goodsdiscount; // ��������
	
	public Goods_2(int barcode, int goodsprice, String goodsname, String goodskind, String goodsdiscount ){ //���ڵ�,��ǰ����,��ǰ��,��ǰ����,�������� 
		this.barcode = barcode;
		this.goodsprice = goodsprice;
		this.goodsname = goodsname;
		this.goodskind = goodskind;
		this.goodsdiscount = goodsdiscount;
	}
	
	public void Goods_print() {
		System.out.printf("��ǰ�� : %s, ���ڵ� : %d, ��ǰ���� : %s \n",this.goodsname, this.barcode, this.goodskind);
	}

	public void setGoodsprice(int goodsprice) { // ��ǰ���� ����
		this.goodsprice = goodsprice;
	}

	public void setGoodsdiscount(String goodsdiscount) { // ��ǰ�������� ����
		this.goodsdiscount = goodsdiscount;
	}
	

	public int getGoodsprice() { // ��ǰ���� Ȯ��
		return goodsprice;
	}

	public int getBarcode() { // ���ڵ� Ȯ��
		return barcode;
	}

	public String getGoodsname() { // ��ǰ�� Ȯ��
		return goodsname;
	}	
}
