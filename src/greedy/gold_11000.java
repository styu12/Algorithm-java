package greedy;

import java.io.*;
import java.util.*;

public class gold_11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Lecture[] lectures = new Lecture[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lectures[i] = new Lecture(start, end);
		}
		
		Arrays.sort(lectures);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(lectures[0].end);
		
		for(int i=1; i<N; i++) {
			// 들어갈 교실이 있을 때 
			if(lectures[i].start >= pq.peek())	pq.poll();
			pq.add(lectures[i].end);
		}
		
		int ans = 0;
		while(!pq.isEmpty()) {
			pq.poll();
			ans++;
		}
		System.out.println(ans);
				
	}
}

class Lecture implements Comparable<Lecture> {
	int start;
	int end;
	
	public Lecture(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Lecture o) {
		if(this.start == o.start) return o.end - this.end;
		return this.start - o.start;
	}
}
