package queue;

import java.io.*;
import java.util.*;

public class silver_2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			q.add(i+1);
		}
		
		int ans = 0;
		while(!q.isEmpty()) {
			ans = q.poll();
			if(!q.isEmpty()) {
				int tmp = q.poll();
				q.add(tmp);
			}
		}
		
		System.out.println(ans);
	}
}

//
//class MyQueue {
//	private int[] queue;
//	private int front, tail, numItems;
//	
//	private final int ERROR = -12345;
//	
//	public MyQueue(int n) {
//		queue = new int[n];
//		front = 0;
//		tail = n-1;
//		numItems = 0;
//	}
//	
//	public void enqueue(int newItem) {
//		if(!isFull()) {
//			tail = (tail+1) % queue.length;
//			queue[tail] = newItem;
//			numItems++;
//		}
//	}
//	
//	public int dequeue() {
//		if(isEmpty()) return ERROR;
//		else {
//			int tmp = queue[front];
//			front = (front+1) % queue.length;
//			numItems--;
//			return tmp;
//		}
//	}
//	
//	public int front() {
//		if(isEmpty()) return ERROR;
//		else return queue[front];
//	}
//	
//	public boolean isEmpty() {
//		return numItems == 0;
//	}
//	
//	public boolean isFull() {
//		return numItems >= queue.length;
//	}
//	
//	public void dequeueAll() {
//		queue = new int[queue.length];
//		front = 0;
//		tail = queue.length-1;
//		numItems = 0;
//	}
//}