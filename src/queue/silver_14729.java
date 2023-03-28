//package queue;
//
//import java.io.*;
//import java.util.*;
//
//public class silver_14729 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		PriorityQueue<Float> pq = new PriorityQueue<>(N);
//		
//		for(int i=0; i<N; i++) {
//			float score = Float.parseFloat(br.readLine());
//			pq.add(score);
//		}
//		
//		for(int i=0; i<7; i++) {
//			System.out.printf("%.3f%n", pq.poll());
//		}
//	}
//}

package queue;

import java.io.*;
import java.util.*;

public class silver_14729 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		float[] scores = new float[N];
		
		for(int i=0; i<N; i++) {
			float score = Float.parseFloat(br.readLine());
			scores[i] = score;
		}
		
		Arrays.sort(scores);
		
		for(int i=0; i<7; i++) {
			System.out.printf("%.3f%n", scores[i]);
		}
	}
}
