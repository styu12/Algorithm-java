package stack;

import java.io.*;
import java.util.*;

public class silver_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		boolean ok = true;
		
		Stack s = new Stack(N);
		
		// 주어진 숫자 돌면서 해당 숫자가 나올 때 까지 stack push/pop 반복 
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
				 
			if(s.getItem() >= num) {
				// 현재 스택 최대 아이템이 num보다 클 경우에는 같아질 때 까지 pop
				if (s.isEmpty()) {
					ok = false;
					break;
				}
				while(!s.isEmpty() & s.top() > num) {
					s.pop();
					sb.append("- ");
				}
				if(s.isEmpty() || s.top() != num) {
					ok = false;
					break;
				}
				s.pop();
				sb.append(("- "));
			}	else {
				// 현재 스택 최대 아이템이 num보다 작을 경우에 같아질 때까지 push 후 pop 
				while(s.getItem() < num) {
					s.push();
					sb.append("+ ");
				}
				s.pop();
				sb.append("- ");
			}	
		}
		
		if(!ok) System.out.println("NO");
		else {
			st = new StringTokenizer(sb.toString(), " ");
			while(st.hasMoreTokens()) {
				System.out.println(st.nextToken());
			}
		}
		
		
	}
}

class Stack {
	private int[] stack;
	private int topIndex;
	private int item;
	
	public Stack(int N) {
		stack = new int[N];
		topIndex = -1;
		item = 0;
	}
	
	public void push() {
		stack[++topIndex] = ++item;
	}
	
	public int pop() {
		if(!isEmpty()) {
			int tmp = stack[topIndex--];
			return tmp;
		}	else return 0;
	}
	
	public int top() {
		if(!isEmpty()) return stack[topIndex];
		else return 0;
	}
	
	public int getItem() {
		return item;
	}
	
	public boolean isEmpty() {
		return topIndex < 0;
	}
}