package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class silver_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		
			
		int[] coins = new int[N]; 
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int j = N-1;

		while(K != 0) {
			if(coins[j] > K) { 
				j--;
				continue; 
			}
			else {
				answer += K / coins[j];
				K = K % coins[j];
				j--;
			}
		}
		
		System.out.println(answer);
	}
}
