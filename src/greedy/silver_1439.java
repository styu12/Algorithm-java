package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class silver_1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		int[] cnt = {0, 0};
		char cur = '2';
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != cur) {
				cur = arr[i];
				cnt[arr[i] - '0']++;
			}
		}
		
		System.out.println(Math.min(cnt[0], cnt[1]));
	}
}
