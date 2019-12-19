package kr.or.bit;
import java.util.Scanner;
class Product{
        private String name;//상품명
        private int price;//상품가격
        protected int TStock;//총 상품 재고
        
        protected Product(String name, int price){//홈런볼,포카칩,고래밥만 만들수 있으므로 protected
                this.name = name;
                this.price = price;
                TStock++;//총 재고 증가
        }
        public int getPrice() {//price getter
                return price;
        }
        protected void reduceTStock() {//총재고 감소 함수
                TStock --;
        }
        
        
}
class Homerunball extends Product{
        private int HStock;//홈런볼 재고
        private static int price=1000;
        protected Homerunball() {
                super("홈런볼",price);
                HStock++;//홈런볼 재고 증가
        }
        
        protected void reduceStock() {//홈런볼재고 감소 함수
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
                super("포카칩",price);
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
                super("고래밥",price);
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
class MethodOfPayment {//결제수단
        private int much;//얼마짜리
        MethodOfPayment(int much) {//결제수단 생성시 필수로 금액설정
                this.much = much;
        }
        protected void setMuch(Product p) {//결제함수 실행시 상품금액 감소
                this.much -= p.getPrice();
        }
        protected int getMuch() {//금액 getter
                return much;
        }
        
        public void returnUrs() {
                
        }
        
}
class Cash extends MethodOfPayment{//현금 클래스
        private String name;
        Cash(int much){
                super(much);
                this.name = "Cash";
        }
        
        public void returnUrs() {
                System.out.println(name + super.getMuch()+"가져가세요");
        }
}
class Credit extends MethodOfPayment{
        private String name;
        
        Credit(int much) {
                super(3000);
                this.name = "Card";
        }
        public void returnUrs() {
                System.out.println(name + "가져가세요");
        }
}
class Purchaser{//구매자 클래스
        MethodOfPayment m;//Purchaser has a methodofpayment
        public Purchaser(String kind,int much){
                if(kind.equals("Cash")) {
                        this.m = new Cash(much);
                }else if(kind.equals("Credit")){
                        this.m = new Credit(much);
                }else {
                        System.out.println("kind의 입력이 잘못되었습니다 Cash 혹은 Credit 을 입력하세요");
                }
        }
        public int balance() {
                return m.getMuch();
        }
}
interface IPayment{//결제 함수
        void payment(MethodOfPayment m, String name);//결제함수
}
class VendingMachine implements IPayment{//A vending machine is able to payment
        private Product p;//자판기는 상품을 가지고 있다
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
                        if(h[i]==null) {//홈런볼이 없는 경우 홈런볼 생성
                                h[i] = new Homerunball();
                                System.out.println("홈런볼의 재고가 증가했습니다");
                                break;
                        }else if(i==2 && h[i]!=null) {// 홈런볼이 없는 경우 홈런볼 생성 안함
                                System.out.println("홈런볼은 이미 가득 차 있습니다");
                        }
                }
        }
        private void inputP() {
                for(int i=0; i<c.length; i++) {
                        if(c[i]==null) {
                                c[i] = new Pokachip();
                                System.out.println("포카칩의 재고가 증가했습니다");
                                break;
                        }else if(i==2 && c[i]!=null) {
                                System.out.println("포카칩은 이미 가득 차 있습니다");
                        }
                }
        }
        private void inputW() {
                for(int i=0; i<w.length; i++) {
                        if(w[i]==null) {
                                w[i] = new WhaleSnack();
                                System.out.println("고래밥의 재고가 증가했습니다");
                                break;
                        }else if(i==2 && w[i]!=null) {
                                System.out.println("고래밥은 이미 가득 차 있습니다");
                        }
                }
        }
        public void inputProduct(String name) {//상품입력함수
                if(name.equals("홈런볼"))inputH();
                else if(name.equals("포카칩"))inputP();
                else if(name.equals("고래밥"))inputW();
                else {
                        System.out.println("지원하지 않는 상품입니다. 상품을 확인하세요");
                }
        }
        
        public void showMenu() {
                for(int i=0; i<3; i++) {
                        for(int j =0; j<3; j++) {
                                if(i==0) {
                                        if(h[j]!=null)System.out.print("[홈런볼]\t");
                                        else System.out.print("[    ]\t");
                                }
                                else if(i==1) {
                                        if(c[j]!=null)System.out.print("[포카칩]\t");
                                        else System.out.print("[    ]\t");
                                }
                                else {
                                        if(w[j]!=null)System.out.print("[고래밥]\t");
                                        else System.out.print("[    ]\t");
                                }
                        }
                        System.out.println();
                }
        }
        
        private void paymentH(MethodOfPayment m) {//홈런볼 결제함수
                for(int i=0;i<h.length;i++) {//홈런볼 배열을 for문으로 하나씩 불러온다
                        if(h[i]!=null && oh.getPrice()<=m.getMuch()) {//불려온 홈런볼이 null값이 아니고 홈런볼의 가격이 가진 돈보다 작다면
                                h[i].reduceStock();//홈런볼 재고 감소
                                m.setMuch(h[i]);//h[i]의 가격만큼 결제수단의 금액 감소
                                this.money+=oh.getPrice();
                                h[i]=null;//출력할 홈런볼의 값을 null로 바꿈
                                System.out.println("짜잔~! 홈런볼~");
                                break;//if 문이 실행됐다면 for문을 돌지 않는다
                        }else if(m.getMuch()<oh.getPrice()) {//m의 금액이 홈런볼의 가격보다 작다면
                                System.out.println("금액이 부족합니다");
                                break;
                        }else if(i==2 & h[2]==null){//홈런볼이 모두 null이고 가진돈이 부족한게 아니라면
                                System.out.println("홈런볼 재고가 없습니다");
                        }
                }
        }
        private void paymentP(MethodOfPayment m) {//상동
                for(int i=0;i<c.length;i++) {
                        if(c[i]!=null && oc.getPrice()<=m.getMuch()) {
                                c[i].reduceStock();
                                m.setMuch(c[i]);
                                this.money+=oc.getPrice();
                                c[i]=null;
                                System.out.println("짜잔~! 포카칩~");
                                break;
                        }else if(m.getMuch()<oc.getPrice()) {
                                System.out.println("금액이 부족합니다");
                                break;
                        }else if(i==2 & c[2]==null){//포카칩 모두 null이고 가진돈이 부족한게 아니라면
                                System.out.println("포카칩 재고가 없습니다");
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
                                System.out.println("짜잔~! 고래밥~");
                                break;
                        }else if(m.getMuch()<ow.getPrice()) {
                                System.out.println("금액이 부족합니다");
                                break;
                        }else if(i==2 & w[2]==null){//고래밥이 모두 null이고 가진돈이 부족한게 아니라면
                                System.out.println("고래밥 재고가 없습니다");
                        }
                }
        }
        @Override
        public void payment(MethodOfPayment m,String name) {//결제함수 실행, 구매자와 상품명 입력
                if(name.equals("홈런볼")) {//name 이 같은 경우
                        paymentH(m);
                }else if(name.equals("포카칩")) {
                        paymentP(m);
                        
                }else if(name.equals("고래밥")) {
                        paymentW(m);
                }else {
                        System.out.println("존재하지 않는 상품입니다");
                }
                
                
        }
        public void modeOfOwner(int n) {//관리자모드 호출함수
                for(int i=0; i<n; i++) {
                        System.out.println("입고할 상품명을 입력하세요 (홈런볼,포카칩,고래밥)");
                        String name = sc.nextLine();
                        inputProduct(name);
                }
        }
        public void completeInput() {//관리자모드 종료알림
                System.out.println("입고가 완료되었습니다");
        }
}
public class exxx {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                
                VendingMachine v = new VendingMachine();
                
                do {
                        v.showMenu();
                        System.out.println("결제수단을 입력하세요 (Credit)or(Cash value)"); //관리모드 별도있음. 스페이스로 구분된 문자 4개  ex) 1 2 3 4
                        String[] enter = sc.nextLine().split(" "); 
                        
                        if(enter.length==4) { // 관리자모드 
                                System.out.println("몇개의 상품을 넣으시겠습니까?");
                                int n = Integer.parseInt(sc.nextLine());
                                v.modeOfOwner(n);
                                v.completeInput();
                        }else if(enter[0].equals("Cash")) {
                                Purchaser p = new Purchaser("Cash", Integer.parseInt(enter[1]));
                                v.showMenu();
                                System.out.println("사고 싶은 메뉴를 입력하시오");
                                String menu = sc.nextLine();
                                v.payment(p.m, menu);
                                p.m.returnUrs();
                        }else if(enter[0].equals("Credit")) {
                                Purchaser p = new Purchaser("Credit", 50000);
                                v.showMenu();
                                System.out.println("사고 싶은 메뉴를 입력히시오");
                                String menu = sc.nextLine();
                                v.payment(p.m, menu);
                                p.m.returnUrs();
                        }else {
                                System.out.println("Credit과 Cash만 받습니다");
                        }
                }while(true);
        }
}
