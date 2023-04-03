package graph;

import java.io.*;
import java.util.*;

public class silver_1012 {

	// n X m graph 
	public static int n, m;
	public static int[][] graph;
	
	// 배추지렁이 개수 세는 cnt 
	public static int cnt=0;
	
	// 방향벡터 (상, 하, 좌, 우) 
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1 ,1};
	
	public static void dfs(int x, int y) {
		// 방문처리
		graph[x][y] = 0;
		
		// 인접노드확인 
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 범위 벗어나면 패스 
			if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;
			
			// 방문하지 않았다면 cnt 증가 & dfs 호출 
			if(graph[nx][ny] != 0) {
				dfs(nx,ny);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// test case 
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			// 배추 개수 k개 
			int k = Integer.parseInt(st.nextToken());
			
			// graph 세팅 
			graph = new int[n][m];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				// 배추 있는 곳 
				graph[x][y] = 1;
			}
			
			// graph 돌면서 dfs 호출 => cnt 업데이트 
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(graph[i][j] != 0) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
			cnt=0;
		}
		System.out.println(sb.toString());
	}
	
}
