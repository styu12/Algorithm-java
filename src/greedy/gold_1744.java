package greedy;

import java.io.*;
import java.util.*;

public class gold_1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pos = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> neg = new PriorityQueue<>();
		
		int ans = 0;
		boolean existZero = false;
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > 0) pos.add(num);
			else if(num < 0) neg.add(num);
			else existZero = !existZero;
		}
		
		while(pos.size() >= 2) {
			int x = pos.poll();
			int y = pos.poll();
			if(y == 1) ans += (x+y);
			else ans += (x*y);
		}
		if(!pos.isEmpty()) ans += pos.poll();
		
		while(neg.size() >= 2) {
			int x = neg.poll();
			int y = neg.poll();
			ans += (x*y);
		}
		if(!neg.isEmpty() && !existZero) ans += neg.poll(); 
		
		System.out.println(ans);
	}
}
