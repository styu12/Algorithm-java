package graph;

import java.io.*;
import java.util.*;

//class Node {
//	int x;
//	int y;
//	
//	public Node(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}

public class gold_7576 {

	// N x M 
	public static int n, m;
	public static int[][] graph;
	
	// 방향벡터 (상, 하, 좌, 우) 
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	// 익은 토마토가 익는 지점들 (출발지점들) 
	public static ArrayList<Node> starts = new ArrayList<Node>();
	
	// ----------- (bfs 출발점 여러개일때) 큐 하나를 돌리되, 출발점을 처음에 여러 개 넣어주자 -----------------------
	public static void bfs(ArrayList<Node> starts) {
		Queue<Node> q = new LinkedList<>();
		for(int i=0; i<starts.size(); i++) {
			q.offer(new Node(starts.get(i).x, starts.get(i).y));
		}
		
		while(!q.isEmpty()) {
			Node t = q.poll();
			for(int i=0; i<4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;
				
				if(graph[nx][ny] != 0) continue;
				
				q.offer(new Node(nx,ny));
				graph[nx][ny] = graph[t.x][t.y]+1;
			}
		}
		
	}
	
// --------------------------------- 실패버전 (큐 여러개 만들어서 돌림) ---------------------------------
//	public static void bfs(ArrayList<Node> starts) {
//		ArrayList<Queue<Node>> qArr = new ArrayList<Queue<Node>>();
//		// 출발점 개수만큼 큐 준비 
//		for(int i=0; i<starts.size(); i++) {
//			qArr.add(new LinkedList<>());
//			// 각각의 큐에 출발점 노드 담아주기. 방문처리는 따로 필요없음 
//			Node start = starts.get(i);
//			qArr.get(i).offer(start);
//		}
//		
//		// 큐 배열이 빌 때까지 (안의 큐들을 전부 돌 때까지) 
//		while(!qArr.isEmpty()) {
//			// 큐 배열 돌면서 하나씩 처리 
//			for(int i=0; i<qArr.size(); i++) {
//				Node t = qArr.get(i).poll();
//				
//				// 인접노드 확인 
//				for(int j=0; j<4; j++) {
//					int nx = t.x + dx[j];
//					int ny = t.y + dy[j];
//					// 범위 벗어나면 패스 
//					if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;
//					// 토마토 없거나 이미 익었으면 패스  
//					if(graph[nx][ny] != 0) continue;
//					
//					// 큐에 넣고 방문처리 (1씩 더해가기)  
//					qArr.get(i).offer(new Node(nx, ny));
//					graph[nx][ny] = graph[t.x][t.y] + 1;
//				}
//				
//				// 큐가 비었으면, qArr에서 빼고, 인덱스 맞추기 위해 i-- 
//				if(qArr.get(i).isEmpty()) qArr.remove(i--);
//			}
//		}
//		
//		
//	}
// -------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 가로 m 세로 n 
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		// 그래프 세팅 
		graph = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;
				if(num == 1) starts.add(new Node(i, j));
			}
		}
		
		bfs(starts);
		
		boolean ok = true;
		int max = 0;
		// 안 익은 토마토 남아있지는 않은지 확인 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(graph[i][j] == 0) ok=false;
				else max = Math.max(max, graph[i][j]);
			}
		}
		
		if(ok) System.out.println(max-1);
		else System.out.println(-1);
	}
	
}
