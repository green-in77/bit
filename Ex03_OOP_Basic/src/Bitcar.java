import kr.or.bit.Ex_Bitcar;


public class Bitcar {

	public static void main(String[] args) {
		
			Ex_Bitcar car1 = new Ex_Bitcar("smart", 1000);  // car 생성
			car1.car_print(); // 차종 출력
			car1.carsum_print(); // 누적대수 출력
			
			Ex_Bitcar car2 = new Ex_Bitcar("web", 3000); 
			car2.car_print();
			car2.carsum_print();
			
			Ex_Bitcar car3 = new Ex_Bitcar("java", 1000); 
			car3.car_print();
			car3.carsum_print();

			car1.ssum_print(); // smart 누적대수 출력
			car2.wsum_print(); // web 누적대수 출력
			car3.jsum_print(); // java 누적대수 출력
			
			
			Ex_Bitcar car4 = new Ex_Bitcar("aaa", 11);
			car4.car_print();
			car4.carsum_print();
			
			
		}		
}

