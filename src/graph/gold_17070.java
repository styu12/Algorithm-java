package graph;

import java.io.*;
import java.util.*;

public class gold_17070 {
	
	public static int n;
	public static int[][] graph;
	// 가로 (Horizontal) 세로 (Vertical) 대각(Diagonal) 타입지정  
	public static int H=0, V=1, D=2;
	// 방향벡터 변수 (우, 하, 대각) 
	public static int[] dx = {0, 1, 1};;
	public static int[] dy = {1, 0, 1};
	
	public static int dfs(int x, int y, int type) {
		// 범위 벗어나면 패스   
		if(x<0 || x>n-1 || y<0 || y>n-1) return 0;
		// 벽이 있으면 패스 (가로, 세로는 자기자신만 체크)  
		if(graph[x][y]==1) return 0;
		// 벽이 있으면 패스 (대각선은 상, 좌도 체크)
		if(type == D && (graph[x-1][y]==1 || graph[x][y-1]==1) ) return 0;
		
		// 도착점이면 1 리턴 
		if(x==n-1 && y==n-1) return 1;
		
		// 타입에 따라 인접노드(방향벡터) 체크 
		if(type == H) {
			// 가로는 우, 대각  
			return dfs(x, y+1, H) + dfs(x+1, y+1, D);
		}	else if(type == V) {
			// 세로는 하, 대각 
			return dfs(x+1, y, V) + dfs(x+1, y+1, D);
		}	else {
			// 대각은 우, 하, 대각 
			return dfs(x, y+1, H) + dfs(x+1, y, V) + dfs(x+1, y+1, D);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// NxN 크기  입력받기 
		n = Integer.parseInt(br.readLine());
		
		// graph 세팅 
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// (0,0)에서 가로로 시작 
		System.out.println(dfs(0, 1, H));
	}
}
