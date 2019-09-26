
public class Star {

	public static void main(String[] args) {
	 
		
		int Line = 0, Star = 0, Null=0 ;
		
		//왼쪽정렬 삼각형
		System.out.println("왼쪽정렬 삼각형");
		for( Line = 1 ; Line <= 8 ; Line++) { // 1부터 8까지 1씩 증가하며 반복. Line 값이 9가되면 끝 ( 별을 8줄을 찍겠다. )
			for( Star = 1 ; Star <=  Line  ; Star++) {  //1부터 Line 보다 커질때까지 1씩 증가하며 반복. Star 값이 Line 값보다 크면 끝 ( 별을 해당줄 만큼 찍겠다. 1번줄 1개, 2번줄 2개 ...)
				System.out.print("*"); // 별출력
			}
			System.out.println();// 1회 반복시 마다 줄바꿈
		}
		System.out.println();
		
		// 왼쪽정렬 역삼각형
		System.out.println("왼쪽정렬 역삼각형");
		for(Line = 1 ; Line <= 8 ; Line++) { // 1부터 8까지 1씩 증가하며 반복.Line 값이 9가되면 끝 ( 별을 8줄을 찍겠다. )
			// System.out.println(i);
			
			for(Star = 8 ; Star >=  Line ; Star-- ) { // 8이 Line보다 작아질때까지 1씩 감소하며 반복.Star 값이 Line 값보다 작으면 끝 ( Star 값이  Line 값이 될 때까지 별을 찍겠다. - Line 이 1이라면 8개, 2라면 7개 )   
				// System.out.print(j);
				System.out.print("*"); //별출력
			}
			
			System.out.println(); // 1회 반복시 마다 줄 바꿈
		}
		
		System.out.println();
	
		
		//오른쪽 정렬 삼각형
		System.out.println("오른쪽정렬 삼각형");
		for(Line = 1; Line <= 8 ; Line++) { //  1부터 8까지 1씩 증가하며 반복. Line 값이 9가되면 끝 ( 별을 8줄을 찍겠다. )
			for(Null = 8 ; Null >= Line ; Null-- ) { // 8이 Line보다 작아질때까지 1씩 감소하며 반복.Null 값이 Line 값보다 작으면 끝 ( Null 값이 Line 값이 될 때까지 공백을 찍겠다. - Line 이 1이라면 8개, 2라면 7개)
				System.out.print(" "); // 공백출력
			}
						
			for( Star = 1 ; Star <= Line ; Star++ ) { // 1이 Line보다 커질때까지 1씩 증가하며 반복. Star 값이 Line 값보다 크면 끝 ( 별을 해당줄 만큼 찍겠다. 1번줄 1개, 2번줄 2개 ...) 
			System.out.print("*"); //별출력
			}
			System.out.println(); // 1회 반복시 마다 줄 바꿈
						
		}
		
		System.out.println();
		
		// 오른쪽 정렬 역삼각형
		System.out.println("오른쪽정렬 역삼각형");
		for ( Line = 1; Line <=8 ; Line++) { //  1부터 8까지 1씩 증가하며 반복. Line 값이 9가되면 끝 ( 별을 8줄을 찍겠다. )
			for( Null =1; Null <= Line ; Null++ ) { // 1이 Line 보다 커질때까지 1씩 증가하며 반복. Null 값이 Line 값보다 크면 끝.( 해당 줄만큼 공백을 찍겠따. 1번줄 1개, 2번줄 2개...)
				System.out.print(" "); //공백출력
			}
		
			for (Star = 8; Star >= Line ; Star--) { // 8이 Line 보다 작아질때 까지 1씩 감소하며 반복. Star 값이 Line 값보다 작으면 끝. (Star 값이 Line 값이 될 때까지 별을 찍겠다. - Line이 1이라면 8개, 2라면 7개)
				System.out.print("*");
			}
			
			System.out.println(); // 1회 반복시 마다 줄 바꿈
			
		}
		System.out.println();
		
	// 중앙정렬 삼각형
		
		for (Line = 1; Line <= 5 ; Line++ ) { //1부터 8까지 1씩 증가하며 반복. Line 값이 5가 되면 끝.(별을 5줄을 찍겠다.)
			for (Null = 5 ; Null >= Line ; Null--) { // 5가 Line 보다 작을떄까지 1씩 감소하며 반복. Null 값이 Line 값보다 작으면 끝.(Null 값이 Line 이 될때까지 공백출력/Line 1 이면 5번, 2이면 4,...)
				System.out.print(" "); //공백출력
			}
			
			for (Star = 1; Star <= (2*Line)-1 ; Star++){ //1부터 홀수번으로 1씩 증가하며 반복(2*1)-1 = 1, (2*2)-1 = 3... (홀수만큼 별찍기)
				System.out.print("*"); //별출력
			}
			System.out.println(); //1회 반복시 마다 줄 바꿈
		}
	}
}
