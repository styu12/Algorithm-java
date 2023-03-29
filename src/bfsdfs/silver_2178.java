package bfsdfs;

import java.io.*;
import java.util.*;

//각 칸을 대변하는 Node 클래스 (위치좌표) 
class Node {
	public int x;
	public int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class silver_2178 {
	// bfs 에서 n,m, graph 모두 접근 가능해야 함 
	public static int n,m;
	public static int[][] graph;
	
	// 방향 벡터 세팅 (상, 하, 좌, 우) 
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void bfs(int x, int y) {
		// 큐 생성 및 출발점 넣기 
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		// 큐가 빌 때까지 
		while(!q.isEmpty()) {
			// 현재노드 큐에서 뽑고 
			Node curNode = q.poll();
			// 상하좌우 인접노드 확인 
			for(int i=0; i<4; i++) {
				int nx = curNode.x + dx[i];
				int ny = curNode.y + dy[i];
				// 범위 벗어나면 패스 
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;
				// 이동할 수 없는 노드는 패스 
				if(graph[nx][ny] == 0) continue;
				// 방문하지 않은 노드만 큐에넣고 방문처리  
				if(graph[nx][ny] == 1) {
					q.offer(new Node(nx, ny));
					graph[nx][ny] += graph[curNode.x][curNode.y];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		// NxM 배열 변수 입력받기 
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		
		// graph 초기화 및 세팅
		graph = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		System.out.println(graph[n-1][m-1]);
		
	}
	
}
