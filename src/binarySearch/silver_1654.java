package binarySearch;

import java.io.*;
import java.util.*;

public class silver_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		// 이미 가지고 있는 랜선 k개, 필요한 랜선 n개(동일길이) 
		int k = Integer.parseInt(inputs[0]);
		int n = Integer.parseInt(inputs[1]);
		
		// 랜선 배열 세팅 
		int[] wires = new int[k];
		for(int i=0; i<k; i++) {
			wires[i] = Integer.parseInt(br.readLine());
		}
		
		// 자르는길이 이진탐색
		long s = 0;
		long e = (long)Integer.MAX_VALUE;
		
		long ans = 0;
		
		while(s <= e) {
			long m = (s+e) / 2;
			
			// m길이로 잘랐을 때 조건체크 (n개 이상 나오는지)
			long cnt = 0;
			for(int i=0; i<k; i++) {
				cnt += wires[i] / m;
			}
			
			// n개 이상이라면 길이를 늘려보자 
			if(cnt >= n) {
				ans = m; // 값 저장 
				s = m+1;
			}	else {
				// n개 미만이라면 길이를 줄여보자
				e = m-1;
			}
		}
		
		System.out.println(ans);
	}
}
