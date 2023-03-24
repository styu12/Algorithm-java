package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class silver_1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int answer = 0;
		
		int N = Integer.parseInt(br.readLine());
		Integer[] aArr = new Integer[N];
		Integer[] bArr = new Integer[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		int i = 0;
		while(st.hasMoreTokens()) {
			aArr[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int j = 0;
		while(st.hasMoreTokens()) {
			bArr[j] = Integer.parseInt(st.nextToken());
			j++;
		}
		
		Arrays.sort(aArr);
		Arrays.sort(bArr, (x, y) -> y - x);
		
		for(int k = 0; k < aArr.length; k++) {
			answer += aArr[k] * bArr[k];
		}
		System.out.println(answer);
	}
}
