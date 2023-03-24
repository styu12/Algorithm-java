package greedy;

import java.io.*;
import java.util.*;

public class silver_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] points = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(points);
		
		int ans = 1;
		
		int start = points[0];
		for(int i=1; i<N; i++) {
			if(points[i]-start < L) {
				continue;
			}	else {
				start = points[i];
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
