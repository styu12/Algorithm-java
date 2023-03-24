// split() version

//package greedy;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//
//public class silver_1541 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] inputs = br.readLine().split("-");
//		
//		int[] subItems = new int[inputs.length];
//		
//		for(int i = 0; i < inputs.length; i++) {
//			if(inputs[i].contains("+")) {
//				int sum = 0;
//				String[] addItems = inputs[i].split("\\+");
//				for(int j = 0; j < addItems.length; j++) {
//					sum += Integer.parseInt(addItems[j]);
//				}
//				subItems[i] = sum;
//			}	else {
//				subItems[i] = Integer.parseInt(inputs[i]);
//			}
//		}
//		
//		int answer = subItems[0];
//		for(int i = 1; i < subItems.length; i++) {
//			answer -= subItems[i];
//		}
//		System.out.println(answer);
//	}
//}

// StringTokenizer version
/*
 * 핵심은 하나의 문자열에서 뺄셈을 기준으로 분리 후, 
 * 각각 아이템을 덧셈 한 뒤에
 * 쭉쭉 뺄셈 적용!
 */
package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class silver_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer subs = new StringTokenizer(br.readLine(), "-");
		
		int answer = Integer.MAX_VALUE;
		
		while(subs.hasMoreTokens()) {
			int tmp = 0;
			StringTokenizer adds = new StringTokenizer(subs.nextToken(), "+");
			
			while(adds.hasMoreTokens()) {
				tmp += Integer.parseInt(adds.nextToken());
			}
			
			answer = answer == Integer.MAX_VALUE ? tmp : answer - tmp; 
		}
		
		System.out.println(answer);
	}
}

