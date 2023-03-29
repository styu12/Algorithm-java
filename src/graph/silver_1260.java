package graph;

import java.io.*;
import java.util.*;

public class silver_1260 {
	// graph 변수, visited 배열 선언
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visited;
	
	// 출력용 stringbilder
	public static StringBuilder sb = new StringBuilder();

	public static void dfs(int s) {
		// 입력 노드 방문처리 및 출력 
		visited[s] = true;
		System.out.print(s + " ");
		// 인접노드 확인  
		for(int i=0; i<graph.get(s).size(); i++) {
			int x = graph.get(s).get(i);
			// 방문하지 않았다면 재귀적으로 호출
			if(!visited[x]) dfs(x);
		}
	}
	
	public static void bfs(int s) {
		// 큐 생성
		Queue<Integer> q = new LinkedList<>();
		// 출발 노드 큐에 넣으면서 방문처리 및 출력  
		q.offer(s);
		visited[s] = true;
		System.out.print(s + " ");
		
		// 큐가 빌 때 까지 
		while(!q.isEmpty()) {
			// 큐에서 하나 뽑고 인접노드 확인
			int x = q.poll();
			for(int i=0; i<graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				// 인접노드 방문하지 않았다면 큐에 넣으면서 방문처리 및 출력  
				if(!visited[y]) {
					q.offer(y);
					visited[y] = true;
					System.out.print(y + " ");
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 노드 n개 , 간선 m개 , 출발 v번 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		// graph, visited 초기화 (index 1~n) 
		visited = new boolean[n+1];
		for(int i=0; i<n+1; i++) graph.add(new ArrayList<Integer>()); // graph item n+1개 세팅 
		while(m-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			// 양방향이므로 서로 graph에 추가 
			graph.get(x1).add(x2);
			graph.get(x2).add(x1);
		}
		
		// graph 인접노드 오름차순으로 정렬 
		for(int i=1; i<n+1; i++) {
			Collections.sort(graph.get(i));
		}
		
		// dfs 호출 -> 프린트 & visited 초기화 
		dfs(v);
		
		visited = new boolean[n+1];
		System.out.println();
		
		// bfs 호출 -> 프린트 
		bfs(v);
		
	}
	
}
