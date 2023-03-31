package binarySearch;

import java.io.*;
import java.util.*;

public class silver_10816 {
	
	public static int[] cards;
	public static int n;
	
	/*
	 * lowerBound 간단하게 구현한 버전 
	 */
//	// x 이상의 값이 처음 등장하는 인덱스 
//	public static int lowerBound(int x) {
//		return upperBound(x-1);
//	}
	
	// x 이상의 값이 처음 등장하는 인덱스 
	public static int lowerBound(int x) {
		int lo = 0;
		int hi = n;
		
		// lo랑 hi 같아질 때까지 반복 
		while(lo < hi) {
			int mid = lo + (hi-lo)/2;
			
			if(cards[mid] < x) {
				lo = mid+1;
			}	else {
				hi=mid;
			}
	
		}
		return lo;
	}
	
	// x 초과한 값이 처음 등장하는 인덱스 
	public static int upperBound(int x) {
		int lo = 0;
		int hi = n;

		// lo랑 hi 같아질 때까지 반복 
		while(lo < hi) {
			int mid = lo + (hi-lo)/2;
			
			if(cards[mid] <= x) {
				lo = mid+1;
			}	else {
				hi = mid;
			}
		}
		return lo;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 가지고 있는 카드 N개 
		n = Integer.parseInt(br.readLine());
		
		// 카드배열 세팅 
		cards = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards); // 이진탐색 전 정렬 
		
		// 찾아야하는 카드 m개 
		int m = Integer.parseInt(br.readLine());
		
		// 찾아야하는 카드 하나씩 이진탐색 2번 실행 (최소인덱스, 최대인덱스)  
		int[] nums = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(upperBound(num) - lowerBound(num)).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
