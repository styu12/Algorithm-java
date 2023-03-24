package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

public class gold_1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long ans = 0L;
		
		// 보석 N개, 가방 K개 
		int N, K;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Gem[] gems = new Gem[N];
		Bag[] bags = new Bag[K];
		
		// 보석 담기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			gems[i] = new Gem(weight, price);
		}
		
		// 가방 담기
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int cap = Integer.parseInt(st.nextToken());
			bags[i] = new Bag(cap);
		}
		
		// 무게기준으로 오름차순 정
		Arrays.sort(gems);
		Arrays.sort(bags);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(N, Comparator.reverseOrder());
		
		for(int i=0, j=0; i<bags.length; i++) {
			while(j < N && bags[i].cap >= gems[j].weight) {
				pq.add(gems[j].price);
				j++;
			}
			if(!pq.isEmpty()) ans += pq.poll();
		}
		
		System.out.println(ans);
	}
}

class Gem implements Comparable<Gem> {
	int weight;
	int price;
	
	public Gem(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
	
	public int compareTo(Gem o) {
		if(this.weight == o.weight) return o.price - this.price;
		else return this.weight - o.weight;
	}
}

class Bag implements Comparable<Bag> {
	int cap;
	
	public Bag(int cap) {
		this.cap = cap;
	}
	
	public int compareTo(Bag o) {
		return this.cap - o.cap;
	}
	
}