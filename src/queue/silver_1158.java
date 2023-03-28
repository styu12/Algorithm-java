package queue;

import java.io.*;
import java.util.*;

public class silver_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<N; i++) q.offer(i+1);
		
		sb.append("<");
		while(q.size() > 1) {
			for(int i=0; i<K-1; i++) q.offer(q.poll());
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">").append("\n");
		
		System.out.println(sb.toString());
	}
}
