//package greedy;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class silver_1946 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int i = 0; i < T; i++) {
//			sb.append(calcOk(br)).append("\n");			
//		}
//		System.out.println(sb);
//	}
//	
//	static int calcOk(BufferedReader br) throws IOException {
//		StringTokenizer st;
//		int N = Integer.parseInt(br.readLine());
//		
//		int[][] scores = new int[N][2];
//		int ok = 0;
//		
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			scores[i][0] = Integer.parseInt(st.nextToken());
//			scores[i][1] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(scores, (s1, s2) ->  s1[0] - s2[0]);
//		
//		int prevTop = scores[0][1];
//		for(int i = 0; i < scores.length; i++) {
//			int curScore = scores[i][1];
//			if(curScore <= prevTop) {
//				ok++;
//				prevTop = curScore;
//			}
//		}
//		return ok;
//	}
//}

package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class silver_1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			sb.append(calcOk(br)).append("\n");			
		}
		System.out.println(sb);
	}
	
	static int calcOk(BufferedReader br) throws IOException {
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] ranks = new int[N+1];
		int ok = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int paper = Integer.parseInt(st.nextToken());
			int interview = Integer.parseInt(st.nextToken());
			ranks[paper] = interview;
		}
		
		int prevTop = Integer.MAX_VALUE;
		for(int i = 1; i < ranks.length; i++) {
			int curRank = ranks[i];
			if(curRank <= prevTop) {
				ok++;
				prevTop = curRank;
				if(curRank == 1) break;
			}
		}
		return ok;
	}
}

/*
 * 0 1 2 3 4 5 6 7
 * [0, 4, 5, 6, 2, 7, 1, 3]
 */ 
