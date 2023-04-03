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

public class sliver_2667 {
	
	public static int n;
	public static int[][] graph;
	public static ArrayList<Integer> counts = new ArrayList<Integer>();
	
	// 방향벡터 (상, 하, 좌, 우) 
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	// 단지 세는 배열 
	public static int cnt=0; 
	public static ArrayList<Integer> towns = new ArrayList<Integer>();
	
	public static void bfs(int x, int y) {
		
		Queue<Node> q = new LinkedList<>();
		// 출발노드 방문처리 후 큐에넣기  
		q.offer(new Node(x, y));
		cnt++;
		graph[x][y] = 0;
		
		
		while(!q.isEmpty()) {
			Node t = q.poll();
			for(int i=0; i<4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				// 범위를 벗어나는 애는 패스 
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
				// 방문하지 않았다면 (0이 아니라면) 방문처리후 큐에 넣기 				
				if(graph[nx][ny] != 0) {
					cnt++;
					graph[nx][ny] = 0;
					q.offer(new Node(nx, ny));
				}
			}
		}
		towns.add(cnt);
		cnt=0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// NxN 
		n = Integer.parseInt(br.readLine());
		
		// graph setting 
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 방문처리 했거나, 집이 없는 곳이라면 패스  
				if(graph[i][j] != 0) bfs(i,j);
			}
		}
		
		Collections.sort(towns);
		sb.append(towns.size()).append("\n");
		for(int i=0; i<towns.size(); i++) {
			sb.append(towns.get(i)).append("\n");
		}
		
        System.out.println(sb.toString());
	}
}
