package queue;

import java.io.*;
import java.util.*;

public class silver_14713 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Queue<String>[] qArr = new LinkedList[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Queue<String> q = new LinkedList<>();
			while(st.hasMoreTokens()) { 
				q.offer(st.nextToken());
			}
			qArr[i] = q;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		boolean ok = true;
		while(st.hasMoreTokens() && ok) {
			String word = st.nextToken();
			ok = false;
			
			for(int i=0; i<qArr.length; i++) {
				Queue<String> q = qArr[i];
				if(!q.isEmpty() && q.peek().equals(word)) {
					q.poll();
					ok = true;
					break;
				}
			}
			
		}
		
		for(int i=0; i<qArr.length; i++) {
			if(!qArr[i].isEmpty()) {
				ok = false;
				break;
			}
		}
		
		if(ok) System.out.println("Possible");
		else System.out.println("Impossible");
		
	}
}
