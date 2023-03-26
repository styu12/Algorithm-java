//package stack;
//
//import java.io.*;
//import java.util.*;
//
//public class silver_9012 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		// num of testcase
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int i=0; i<T; i++) {
//			String str = br.readLine();
//			CharStack s = new CharStack(str.length());
//			boolean ok = true;
//			
//			if(str.charAt(0) == '(') {
//				s.push(str.charAt(0));
//				for(int j=1; j<str.length(); j++) {
//					if(str.charAt(j) == '(') s.push(str.charAt(j));
//					else {
//						if(s.isEmpty()) {
//							ok = false;
//							break;
//						}	else {
//							s.pop();
//						}
//					}
//				}
//				
//				if(!ok || !s.isEmpty()) sb.append("NO\n");
//				else sb.append("YES\n");
//				
//			}	else {
//				sb.append("NO\n");
//			}
//		}
//		
//		System.out.println(sb.toString());
//	}
//}
//
//class CharStack {
//	private char[] s;
//	private int topIndex;
//	
//	private final char ERROR = 'X';
//	
//	public CharStack(int n) {
//		s = new char[n];
//		topIndex = -1;
//	}
//	
//	public void push(char newItem) {
//		s[++topIndex] = newItem; 
//	}
//	
//	public char pop() {
//		if(!isEmpty()) {
//			char tmp = s[topIndex--];
//			return tmp;
//		}	else return ERROR;
//	}
//	
//	public char top() {
//		if(!isEmpty()) return s[topIndex];
//		else return ERROR;
//	}
//	
//	public boolean isEmpty() {
//		return topIndex < 0;
//	}
//}


package stack;

import java.io.*;

public class silver_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int cnt = 0;
			String str = br.readLine();
			
			for(int j=0; j<str.length(); j++) {
				cnt = str.charAt(j) == '(' ? cnt+1 : cnt-1;
				if(cnt < 0) break;
			}
			
			if(cnt == 0) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb.toString());
	}
}
