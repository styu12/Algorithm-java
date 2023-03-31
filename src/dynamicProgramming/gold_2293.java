package dynamicProgramming;

import java.io.*;
import java.util.*;

public class gold_2293 {

	// 가격별로 만들 수 있는 경우의 수 저장할 dp 테이블  
	public static int[] d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 동전 n개, 가격 k원 
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 동전 종류 배열 
		int[] coins = new int[n];
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// dp 테이블 세팅 (0원 ~ k원)  
		d = new int[k+1];
		d[0] = 1;
		
		// k원까지 배열 돌면서 만들 수 있는 경우의수 기록 (동전별 이전 경우의 수 더해주기)  
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j >= coins[i]) {
					d[j] += d[j-coins[i]];
				}
			}
		}
//		for(int i=1; i<=k; i++) {
//			for(int j=0; j<n; j++) {
//				if(i >= coins[j]) {
//					d[i] += d[i-coins[j]];
//				}
//			}
//		}
		System.out.println(Arrays.toString(d));
		// k원의 경우의 수 출력 
		System.out.println(d[k]);
		
	}
	
}
