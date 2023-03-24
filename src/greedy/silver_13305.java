//package greedy;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//
//public class silver_13305 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		long gas = 0L;
//		
//		String[] inputs1 = br.readLine().split(" ");
//		String[] inputs2 = br.readLine().split(" ");
//		
//		long[] distances = new long[N-1];
//		long[] prices = new long[N-1];
//		
//		for(int i = 0; i < N-1; i++) {
//			distances[i] = Long.parseLong(inputs1[i]);
//			prices[i] = Long.parseLong(inputs2[i]);
//		}
//		
//		int cur = 0;
//		long distSum = 0L;
//		for(int i = 0; i < prices.length; i++) {
//			if(prices[cur] <= prices[i]) {
//				// accumulate distSum
//				distSum += distances[i];
//			}	else {
//				// update gas & restart
//				gas += prices[cur] * distSum;
//				distSum = distances[i];
//				cur = i;
//			}
//		}
//		gas += prices[cur] * distSum;
//		
//		System.out.println(gas);
//		
//		
//		
//	}
//}

package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class silver_13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long gas = 0L;
		
		String[] inputs1 = br.readLine().split(" ");
		String[] inputs2 = br.readLine().split(" ");
		
		long[] distances = new long[N-1];
		long[] prices = new long[N-1];
		
		distances[0] = Long.parseLong(inputs1[0]);
		prices[0] = Long.parseLong(inputs2[0]);
		for(int i = 1; i < N-1; i++) {
			distances[i] = Long.parseLong(inputs1[i]);
			long curPrice = Long.parseLong(inputs2[i]);
			prices[i] = Math.min(prices[i-1], curPrice);
		}
		
		for(int i = 0; i < prices.length; i++) {
			gas += prices[i] * distances[i];
		}
		
		System.out.println(gas);
		
		
		
	}
}

