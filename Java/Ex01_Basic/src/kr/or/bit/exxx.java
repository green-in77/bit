package kr.or.bit;
import java.util.Scanner;
class Product{
        private String name;//��ǰ��
        private int price;//��ǰ����
        protected int TStock;//�� ��ǰ ���
        
        protected Product(String name, int price){//Ȩ����,��īĨ,���丸 ����� �����Ƿ� protected
                this.name = name;
                this.price = price;
                TStock++;//�� ��� ����
        }
        public int getPrice() {//price getter
                return price;
        }
        protected void reduceTStock() {//����� ���� �Լ�
                TStock --;
        }
        
        
}
class Homerunball extends Product{
        private int HStock;//Ȩ���� ���
        private static int price=1000;
        protected Homerunball() {
                super("Ȩ����",price);
                HStock++;//Ȩ���� ��� ����
        }
        
        protected void reduceStock() {//Ȩ������� ���� �Լ�
                TStock --;
                HStock --;
        }
        public int getPrice() {
                return price;
        }
        
}
class Pokachip extends Product{
        private int PStock;
        private static int price=1500;
        protected Pokachip() {
                super("��īĨ",price);
                PStock++;
        }
        protected void reduceStock() {
                TStock --;
                PStock --;
        }
        public int getPrice() {
                return price;
        }
}
class WhaleSnack extends Product{
        int WStock;
        private static int price=700;
        protected WhaleSnack() {
                super("����",price);
                WStock++;
        }
        protected void reduceStock() {
                TStock --;
                WStock --;
        }
        public int getPrice() {
                return price;
        }
        
}
class MethodOfPayment {//��������
        private int much;//��¥��
        MethodOfPayment(int much) {//�������� ������ �ʼ��� �ݾ׼���
                this.much = much;
        }
        protected void setMuch(Product p) {//�����Լ� ����� ��ǰ�ݾ� ����
                this.much -= p.getPrice();
        }
        protected int getMuch() {//�ݾ� getter
                return much;
        }
        
        public void returnUrs() {
                
        }
        
}
class Cash extends MethodOfPayment{//���� Ŭ����
        private String name;
        Cash(int much){
                super(much);
                this.name = "Cash";
        }
        
        public void returnUrs() {
                System.out.println(name + super.getMuch()+"����������");
        }
}
class Credit extends MethodOfPayment{
        private String name;
        
        Credit(int much) {
                super(3000);
                this.name = "Card";
        }
        public void returnUrs() {
                System.out.println(name + "����������");
        }
}
class Purchaser{//������ Ŭ����
        MethodOfPayment m;//Purchaser has a methodofpayment
        public Purchaser(String kind,int much){
                if(kind.equals("Cash")) {
                        this.m = new Cash(much);
                }else if(kind.equals("Credit")){
                        this.m = new Credit(much);
                }else {
                        System.out.println("kind�� �Է��� �߸��Ǿ����ϴ� Cash Ȥ�� Credit �� �Է��ϼ���");
                }
        }
        public int balance() {
                return m.getMuch();
        }
}
interface IPayment{//���� �Լ�
        void payment(MethodOfPayment m, String name);//�����Լ�
}
class VendingMachine implements IPayment{//A vending machine is able to payment
        private Product p;//���Ǳ�� ��ǰ�� ������ �ִ�
        private Homerunball oh = new Homerunball();
        private Pokachip oc = new Pokachip();
        private WhaleSnack ow = new WhaleSnack();
        private Homerunball[] h = new Homerunball[3];
        private Pokachip[] c = new Pokachip[3];
        private WhaleSnack[] w = new WhaleSnack[3];
        private Scanner sc = new Scanner(System.in);
        private int money;
        
        private void inputH() {
                for(int i=0; i<h.length; i++) {
                        if(h[i]==null) {//Ȩ������ ���� ��� Ȩ���� ����
                                h[i] = new Homerunball();
                                System.out.println("Ȩ������ ��� �����߽��ϴ�");
                                break;
                        }else if(i==2 && h[i]!=null) {// Ȩ������ ���� ��� Ȩ���� ���� ����
                                System.out.println("Ȩ������ �̹� ���� �� �ֽ��ϴ�");
                        }
                }
        }
        private void inputP() {
                for(int i=0; i<c.length; i++) {
                        if(c[i]==null) {
                                c[i] = new Pokachip();
                                System.out.println("��īĨ�� ��� �����߽��ϴ�");
                                break;
                        }else if(i==2 && c[i]!=null) {
                                System.out.println("��īĨ�� �̹� ���� �� �ֽ��ϴ�");
                        }
                }
        }
        private void inputW() {
                for(int i=0; i<w.length; i++) {
                        if(w[i]==null) {
                                w[i] = new WhaleSnack();
                                System.out.println("������ ��� �����߽��ϴ�");
                                break;
                        }else if(i==2 && w[i]!=null) {
                                System.out.println("������ �̹� ���� �� �ֽ��ϴ�");
                        }
                }
        }
        public void inputProduct(String name) {//��ǰ�Է��Լ�
                if(name.equals("Ȩ����"))inputH();
                else if(name.equals("��īĨ"))inputP();
                else if(name.equals("����"))inputW();
                else {
                        System.out.println("�������� �ʴ� ��ǰ�Դϴ�. ��ǰ�� Ȯ���ϼ���");
                }
        }
        
        public void showMenu() {
                for(int i=0; i<3; i++) {
                        for(int j =0; j<3; j++) {
                                if(i==0) {
                                        if(h[j]!=null)System.out.print("[Ȩ����]\t");
                                        else System.out.print("[    ]\t");
                                }
                                else if(i==1) {
                                        if(c[j]!=null)System.out.print("[��īĨ]\t");
                                        else System.out.print("[    ]\t");
                                }
                                else {
                                        if(w[j]!=null)System.out.print("[����]\t");
                                        else System.out.print("[    ]\t");
                                }
                        }
                        System.out.println();
                }
        }
        
        private void paymentH(MethodOfPayment m) {//Ȩ���� �����Լ�
                for(int i=0;i<h.length;i++) {//Ȩ���� �迭�� for������ �ϳ��� �ҷ��´�
                        if(h[i]!=null && oh.getPrice()<=m.getMuch()) {//�ҷ��� Ȩ������ null���� �ƴϰ� Ȩ������ ������ ���� ������ �۴ٸ�
                                h[i].reduceStock();//Ȩ���� ��� ����
                                m.setMuch(h[i]);//h[i]�� ���ݸ�ŭ ���������� �ݾ� ����
                                this.money+=oh.getPrice();
                                h[i]=null;//����� Ȩ������ ���� null�� �ٲ�
                                System.out.println("¥��~! Ȩ����~");
                                break;//if ���� ����ƴٸ� for���� ���� �ʴ´�
                        }else if(m.getMuch()<oh.getPrice()) {//m�� �ݾ��� Ȩ������ ���ݺ��� �۴ٸ�
                                System.out.println("�ݾ��� �����մϴ�");
                                break;
                        }else if(i==2 & h[2]==null){//Ȩ������ ��� null�̰� �������� �����Ѱ� �ƴ϶��
                                System.out.println("Ȩ���� ��� �����ϴ�");
                        }
                }
        }
        private void paymentP(MethodOfPayment m) {//��
                for(int i=0;i<c.length;i++) {
                        if(c[i]!=null && oc.getPrice()<=m.getMuch()) {
                                c[i].reduceStock();
                                m.setMuch(c[i]);
                                this.money+=oc.getPrice();
                                c[i]=null;
                                System.out.println("¥��~! ��īĨ~");
                                break;
                        }else if(m.getMuch()<oc.getPrice()) {
                                System.out.println("�ݾ��� �����մϴ�");
                                break;
                        }else if(i==2 & c[2]==null){//��īĨ ��� null�̰� �������� �����Ѱ� �ƴ϶��
                                System.out.println("��īĨ ��� �����ϴ�");
                        }
                }
        }
        private void paymentW(MethodOfPayment m) {
                for(int i=0;i<w.length;i++) {
                        if(w[i]!=null && ow.getPrice()<=m.getMuch()) {
                                w[i].reduceStock();
                                m.setMuch(w[i]);
                                this.money+=ow.getPrice();
                                w[i]=null;
                                System.out.println("¥��~! ����~");
                                break;
                        }else if(m.getMuch()<ow.getPrice()) {
                                System.out.println("�ݾ��� �����մϴ�");
                                break;
                        }else if(i==2 & w[2]==null){//������ ��� null�̰� �������� �����Ѱ� �ƴ϶��
                                System.out.println("���� ��� �����ϴ�");
                        }
                }
        }
        @Override
        public void payment(MethodOfPayment m,String name) {//�����Լ� ����, �����ڿ� ��ǰ�� �Է�
                if(name.equals("Ȩ����")) {//name �� ���� ���
                        paymentH(m);
                }else if(name.equals("��īĨ")) {
                        paymentP(m);
                        
                }else if(name.equals("����")) {
                        paymentW(m);
                }else {
                        System.out.println("�������� �ʴ� ��ǰ�Դϴ�");
                }
                
                
        }
        public void modeOfOwner(int n) {//�����ڸ�� ȣ���Լ�
                for(int i=0; i<n; i++) {
                        System.out.println("�԰��� ��ǰ���� �Է��ϼ��� (Ȩ����,��īĨ,����)");
                        String name = sc.nextLine();
                        inputProduct(name);
                }
        }
        public void completeInput() {//�����ڸ�� ����˸�
                System.out.println("�԰� �Ϸ�Ǿ����ϴ�");
        }
}
public class exxx {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                
                VendingMachine v = new VendingMachine();
                
                do {
                        v.showMenu();
                        System.out.println("���������� �Է��ϼ��� (Credit)or(Cash value)"); //������� ��������. �����̽��� ���е� ���� 4��  ex) 1 2 3 4
                        String[] enter = sc.nextLine().split(" "); 
                        
                        if(enter.length==4) { // �����ڸ�� 
                                System.out.println("��� ��ǰ�� �����ðڽ��ϱ�?");
                                int n = Integer.parseInt(sc.nextLine());
                                v.modeOfOwner(n);
                                v.completeInput();
                        }else if(enter[0].equals("Cash")) {
                                Purchaser p = new Purchaser("Cash", Integer.parseInt(enter[1]));
                                v.showMenu();
                                System.out.println("��� ���� �޴��� �Է��Ͻÿ�");
                                String menu = sc.nextLine();
                                v.payment(p.m, menu);
                                p.m.returnUrs();
                        }else if(enter[0].equals("Credit")) {
                                Purchaser p = new Purchaser("Credit", 50000);
                                v.showMenu();
                                System.out.println("��� ���� �޴��� �Է����ÿ�");
                                String menu = sc.nextLine();
                                v.payment(p.m, menu);
                                p.m.returnUrs();
                        }else {
                                System.out.println("Credit�� Cash�� �޽��ϴ�");
                        }
                }while(true);
        }
}
