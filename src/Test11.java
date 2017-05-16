public class Test11 {
	public static void main(String[] args) {
		
		// 1,000,000 원으로 
		// 100N 50N, 20, 10, 5, 1N
		// 환율 1322원
		// 100N 4장 , 50N은 4장, 1N은 20장 이상
		// 우리돈 2000원 이하
		// 4 ,4, 4, 3, 4, 25장
		
		//환율 1320
		int exRate = 1322;
		int totalAmt = 1000000;
	
		Test11 test = new Test11();
		int result[] = test.calculation(exRate, totalAmt);
		test.show(result);
	}
	public int[] calculation(int exRate, int totalAmt){
		int[] count = {4, 4, 0, 0, 0, 20};
		int[] eachAmt = {100, 50, 20, 10, 5, 1};
		boolean[] isCount = {false, false, true, true, true, true};
		
		int sum = 0;
		int balance = 0;
		int loc=2;
		
		while(true) {
			// 합계 초기화
			sum = 0;
			
			for(int i=0; i < count.length; i++){
				sum += count[i] * eachAmt[i] * exRate;
			}	
			// 중간 점검
			System.out.print("SUM("+loc+"):"+sum + " | ");
			show(count);
			
			// 합계가 넘었을 때
			if (sum > totalAmt){
				count[loc-1]--;
				isCount[loc-1] = false;
				System.out.println(" 닫힘:"+(loc-1));
				continue;
			} else { 
				if(isCount[loc])
					count[loc]++;
			}
				
			// 나머지가 2000원 미만이면 잔돈 계산
			if (totalAmt - sum < 2000){
				balance = totalAmt - sum; 
				System.out.println(": " + balance );
			}

			loc++;
			if(loc>5)
				loc = 2;
			
			System.out.println("--------");
			// 합계 금액과 잔돈이 목표 금액이 도달하면 종료 
			if (sum + balance == totalAmt)
				break;
		}
		
		return count;
	}
	
	public void show(int[] count){
//		System.out.print("100N : " + count[0] +"장, ");
//		System.out.print("50N : " + count[1] +"장, ");
//		System.out.print("20N : " + count[2] +"장, ");
//		System.out.print("10N : " + count[3] +"장, ");
//		System.out.print("5N : " + count[4] +"장, ");
//		System.out.println("1N : " + count[5] +"장");
		
		System.out.print(count[0] +", ");
		System.out.print(count[1] +", ");
		System.out.print(count[2] +", ");
		System.out.print(count[3] +", ");
		System.out.print(count[4] +", ");
		System.out.print(count[5]);
	}
}
