import java.util.Scanner;
 
import kr.or.bit.BitCar;
 
public class BitCar_Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BitCar bc1 = new BitCar("smart", 100000);
        bc1.getCartype();
        bc1.getCarprice();
        bc1.CarCheck(bc1);
        BitCar bc2 = new BitCar("java",20000);
        bc2.getCartype();
        bc2.getCarprice();
        bc2.CarCheck(bc2);
        BitCar bc3 = new BitCar("web",25000);
        bc3.getCartype();
        bc3.getCarprice();
        bc3.CarCheck(bc3);
        BitCar bc4 = new BitCar("web",45000);
        bc4.getCartype();
        bc4.getCarprice();
        bc4.CarCheck(bc4);
        BitCar.carNumberInfo();
        
        bc1.CarCheck(bc1);
    }