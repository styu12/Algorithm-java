package queue;

import java.io.*;
import java.util.*;

public class silver_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> docs = new LinkedList();
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				docs.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			
			int cnt = 0;
			while(!docs.isEmpty()) {
				
				int[] front = docs.poll();
				boolean isMax = true; 
				
				for(int j=0; j<docs.size(); j++) {
					if(docs.get(j)[1] > front[1]) {
						docs.offer(front);
						for(int i=0; i<j; i++) {
							docs.offer(docs.poll());
						}
						isMax = false;
						break;
					}
				}
				
				if(!isMax) continue;
				
				cnt++;
				if(front[0] == M) break;
				
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
