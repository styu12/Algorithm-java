package binarySearch;

import java.io.*;
import java.util.*;

public class silver_2805 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] trees = new int[n];
		for(int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = (int)1e9;
		
		int ans = 0;
		
		while(s <= e) {
			int h = (s+e) / 2;
			
			long sum = 0;
			for(int i=0; i<n; i++) {
				if(trees[i] > h) sum += (trees[i] - h);
			}
			
			if(sum >= m) {
				ans = h;
				s = h+1;
			}	else {
				e = h-1;
			}
		}
		
		System.out.println(ans);
	}
}
