package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class silver_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		char[] nums = N.toCharArray();
		int sum = 0;
		
		descOrder(nums);
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i]-'0';
		}
		
		if(sum % 3 != 0 || nums[nums.length - 1] != '0') {
			System.out.println("-1");
		}	else {
			System.out.println(nums);
		}
	}
	
	
	static void descOrder(char[] s) {
		Arrays.sort(s);
		reverse(s);
	}
	
	static void reverse(char[] arr) {
		int n = arr.length;
		char t;
		for(int i = 0; i < n/2; i++) {
			t = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = t;
		}
	}
}


//package greedy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class silver_10610 {
//	/*
//	 * char 세는 배열을 따로 만들기 - 다이나믹 프로그래밍 느낌?
//	 * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
//	 * [3, 5, 6, 8, 8, 2, 1, 2, 3, 4]
//	 * 이런식으로 숫자별로 등장 횟수 세서 마지막에 이어붙이기 -> StringBuilder 사
//	 */
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String N = br.readLine();
//		int[] numCountArr = new int[10];
//		int sum = 0;
//		
//		for(int i = 0; i < N.length(); i++) {
//			char c = N.charAt(i);
//			int num = c - '0';
//			sum += num;
//			numCountArr[num]++;
//		}
//		
//		if(sum % 3 != 0 || numCountArr[0] == 0) {
//			System.out.println("-1");
//		}	else {
//			StringBuilder sb = new StringBuilder();
//			for(int i = 9; i >= 0; i--) {
//				while(numCountArr[i]-- > 0) {
//					sb.append(i);
//				}
//			}
//			System.out.println(sb);
//		}
//		
//	}
//}
