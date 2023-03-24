//package greedy;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class silver_11399 {
//	public static void main(String[] args) {
//		int answer = 0;
//		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		sc.nextLine();
//		String str = sc.nextLine();
//		
//		String[] strArr = str.split("\\s");
//		int[] intArr = new int[strArr.length];
//		for(int i = 0; i < strArr.length; i++) {
//			intArr[i] = Integer.parseInt(strArr[i]);
//		}
//		Arrays.sort(intArr);
//		
//		for(int i = 0; i < intArr.length; i++) {
//			answer += intArr[i] * N;
//			N--;
//		}
//		System.out.println(answer);
//	}
//}

package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class silver_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		String[] inputs;
		int[] times = new int[N];
		inputs = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(inputs[i]);
		}
		
		Arrays.sort(times);
		
		for(int i = 0; i < N; i++) {
			int x = N - i;
			answer += times[i] * x;
		}
		
		System.out.println(answer);
	}
}

