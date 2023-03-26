package stack;

import java.io.*;
import java.util.*;

public class silver_2841 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		// N개 줄에 P개 프렛을 가진 스택 할당 
		Stack<Integer>[] guitar = new Stack[N];
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int pret = Integer.parseInt(st.nextToken());
			
			if(guitar[line] == null) guitar[line] = new Stack();
			
			Stack<Integer> s = guitar[line];
			while(!s.empty() && s.peek().compareTo(pret) > 0) {
				s.pop();
				ans++;
			}
			if(!s.empty() && s.peek().compareTo(pret) == 0) continue;
			
			s.push(pret);
			ans++;
		}
		
		System.out.println(ans);
	}
}
