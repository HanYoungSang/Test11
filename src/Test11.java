public class Test11 {
	public static void main(String[] args) {
		
		// 1,000,000 원으로 
		// 100N 50N, 20, 10, 5, 1N
		// 환율 1322원
		// 100N 4장 , 50N은 4장, 1N은 20장 이상
		// 우리돈 2000원 이하
		// 4 ,4, 4, 3, 4, 25장
		
		//환율 1320
		int exRate = 1320;
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
		
		while(true){
			if ( sum > totalAmt)
				break;
			sum = 0;
			balance = 0;
			
			for(int i=0; i<count.length; i++){
				if (isCount[i])
					count[i]++;
				
				sum += count[i] * eachAmt[i] * exRate;
				System.out.print("합계 금액 : "+ sum + ", ");
				show(count);
				
				if( sum > totalAmt - 2000){
					count[i]--;
					isCount[i] = false;
					balance = totalAmt - sum - eachAmt[i];
					System.out.println(i +","+balance);
				}
				
				
				
			}
			
			System.out.println("---------------");
			System.out.println("                   합계 금액 : "+ sum);
			show(count);
			System.out.println("---------------");
			
			
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
		System.out.println(count[5]);
	}
}