package bfsdfs;

import java.io.*;
import java.util.*;

public class silver_1325 {

	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visit;
	public static int[] cnt; // 노드별로 bfs 타고 가며 연결 노드 수  기록  
	public static int n; // 노드 개수 n 
	
	
	public static void bfs(int s) {
		// 큐 생성 
		Queue<Integer> q = new LinkedList<>();
		// 출발 노드 큐에 넣고 방문 처리  
		q.offer(s);
		visit[s] = true;
		
		// 큐가 빌 때까지 
		while(!q.isEmpty()) {
			int x = q.poll();
			// 인접노드 확인 
			for(int i=0; i<graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				// 방문하지 않았다면 큐에 넣고 방문처리 & 새로 하나 방문했으니 cnt 1증가    
				if(!visit[y]) {
					q.offer(y);
					visit[y] = true;
					cnt[y]++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 노드 n개, 간선 m개 
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// cnt 배열 초기화 
		cnt = new int[n+1];
		
		// visit 세팅 
		visit = new boolean[n+1];
		for(int i=0; i<n+1; i++) graph.add(new ArrayList<Integer>()); // graph 세팅 - n+1개 (인덱스 1~n)
		// 간선 개수만큼 graph 업데이트
		while(m-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// a가 b를 신뢰 -> cnt 배열에 b의 값 +1 해나갈 것 
			graph.get(a).add(b);
		}
		
		// 모든 노드에 대해 bfs 수행 
		for(int i=1; i<=n; i++) {
			bfs(i);
			visit = new boolean[n+1]; // 다시 bfs 호출 하기 위해 방문배열 초기화 
		}
		
		int max = 0;
		for(int i=1; i<=n; i++) max = Math.max(max, cnt[i]);
		
		// depths 돌면서 max랑 같은 값인 노드 번호 출력
		for(int i=1; i<=n; i++) {
			if(cnt[i] == max) System.out.print(i + " ");
		}
	}
}
