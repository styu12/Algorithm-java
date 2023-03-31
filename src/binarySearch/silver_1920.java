package binarySearch;

import java.io.*;
import java.util.*;

public class silver_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		while(m-->0) {
			int ok = Arrays.binarySearch(a, Integer.parseInt(st.nextToken()));
			if(ok >= 0) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
