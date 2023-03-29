package bfsdfs;

import java.io.*;
import java.util.*;

// 각 칸을 나타낼 노드 클래스 (좌표) 
//class Node {
//	public int x;
//	public int y;
//	
//	public Node(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}

public class silver_7562 {

	// graph, n 모두 bfs 에서 접근 가능  
	public static int[][] graph;
	public static int n;
	// 방향 벡터 설정 
	public static int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1};
	public static int[] dy = {-1, 1, -1, 1, -2, 2, -2, 2};
	
	public static void bfs(Node s) {
		// 큐 생성 및 출발점 큐에 넣기 
		Queue<Node> q = new LinkedList<>();
		q.offer(s);
		
		// 큐가 빌 때 까지 
		while(!q.isEmpty()) {
			// 현재 위치 큐에서  빼기 
			Node pos = q.poll();
			// 인접 노드 확인 (방향 벡터 ) 
			for(int i=0; i<8; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				// 범위 벗어나면 패스 
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
				// 최단경로니까 방문한 곳만 큐에 넣고 방문처리 (이전 경로수에서 1더하기 )
				if(graph[nx][ny] == 0) {
					q.offer(new Node(nx, ny));
					graph[nx][ny] = graph[pos.x][pos.y]+1;
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// test case t
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			// NxN 크기 체스판 
			n = Integer.parseInt(br.readLine());
			
			// graph 초기화 - 모두 0으로 세팅 
			graph = new int[n][n]; 
			
			// 출발 및 도착점 받기 
			st = new StringTokenizer(br.readLine(), " ");
			Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine(), " ");
			Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			if(start.x == end.x && start.y == end.y) {
				sb.append(0).append("\n");
				continue;
			}
			
			// bfs 호출 
			bfs(start);
			// graph에서 end 위치 값 sb에 넣고, graph 초기화 
			sb.append(graph[end.x][end.y]).append("\n");
			graph = new int[n][n];
			
		}
		
		// print sb
		System.out.println(sb.toString());
	}
}
