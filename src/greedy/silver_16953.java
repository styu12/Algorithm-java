//package greedy;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//public class silver_16953 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		int count = 1;
//		
//		int A = Integer.parseInt(st.nextToken());
//		int B = Integer.parseInt(st.nextToken());
//		
//		while(B > A) {
//			if(B % 2 == 0) {
//				B = divideByTwo(B);
//				count++;
//			}	else if(B % 10 == 1) {
//				B = separateOne(B);
//				count++;
//			}	else {
//				break;
//			}
//		}
//		
//		if(B == A) {
//			System.out.println(count);
//		}	else {
//			System.out.println(-1);
//		}
//		
//	}
//	
//	static int separateOne(int b) {
//		String str = String.valueOf(b);
//		String newStr = str.substring(0, str.length() - 1);
//		return Integer.parseInt(newStr);
//		
//	}
//	
//	static int divideByTwo(int b) {
//		return b / 2;
//	}
//}


package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class silver_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		
		while(B > A) {
			if (B % 10 == 1) B /= 10;
			else if (B % 2 == 0) B /= 2;
			else break;
			cnt++;
		}
		
		System.out.println(A == B ? cnt : -1);
		
	}
}
