package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class silver_1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		
		int N = 0;
		long sum = 0L;
		while(sum <= S) {
			sum += ++N;
		}
		System.out.println(N-1);
		
	}
}
