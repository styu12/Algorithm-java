package queue;

import java.util.*;
import java.io.*;

public class silver_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) q.offer(i+1);
		
		int[] targets = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i=0; i<M; i++) {
			int target = targets[i];
			
			if(q.peek() == target) {
				q.poll();
				continue;
			}
			
			int step = 0;
			for(int j=1; j<q.size(); j++) {
				step++;
				if(q.get(j) == target) break;
			}
			
			if(step <= q.size()/2) {
				for(int k=0; k<step; k++) {
					ans++;
					q.offer(q.poll());
				}
				q.poll();
			}	else {
				for(int k=0; k<q.size()-step; k++) {
					ans++;
					q.add(0, q.removeLast());
				}
				q.poll();
			}
		}
		
		System.out.println(ans);
		
	}
}
