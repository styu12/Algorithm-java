package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class silver_2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] ropes = new int[N];
		int maxWeight = 0;
		
		for(int i = 0; i < N; i++) {
			int rope = Integer.parseInt(br.readLine());
			ropes[i] = rope;
		}
		
		Arrays.sort(ropes);
		for(int i = 0; i < ropes.length; i++) {
			int curRope = ropes[i];
			int curWeight = curRope * (N - i);
			maxWeight = curWeight > maxWeight ? curWeight : maxWeight;
		}
		System.out.println(maxWeight);
	}
}
