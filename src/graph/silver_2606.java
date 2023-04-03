package graph;

import java.io.*;
import java.util.*;

public class silver_2606 {

	public static int cnt; // 연결 컴퓨터 수 카운트용 변수 
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 
	public static boolean[] visit;
	
	public static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		// 출발 노드 큐에 넣으면서 방문처리 
		q.offer(s);
		visit[s] = true;
		
		// 큐가 빌 때까지 
		while(!q.isEmpty()) {
			int x = q.poll();
			// 인접노드 확인 
			for(int i=0; i<graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if(!visit[y]) {
					q.offer(y);
					visit[y] = true;
					cnt++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 컴퓨터 n대, 간선 m개 
		int n = Integer.parseInt(br.readLine()); 
		int m = Integer.parseInt(br.readLine());
		
		// 방문여부 배열 세팅 
		visit = new boolean[n+1];
		
		// 그래프 세팅 
		for(int i=0; i<n+1; i++) graph.add(new ArrayList<Integer>());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// 양방향 그래프 
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		
		// 1번 컴퓨터에서 출발하는 bfs 호출 
		bfs(1);
		
		System.out.println(cnt);
	}
}
