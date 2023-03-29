package graph;

import java.io.*;
import java.util.*;

public class silver_4963 {
	
	public static int[][] graph;
	public static int n, m;
	
	// 방향 벡터 
	public static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	public static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	// 방문처리는 1->0 (육지: 1, 바다: 0) 
	// 시작점에서만 true 리턴 
	public static boolean dfs(int x, int y) {
		// 범위를 벗어나면 패스  
		if(x<0 || x>n-1 || y<0 || y>m-1) return false;
		// 육지라면(방문한 곳이 아니라면) 인접노드 체크 
		else if(graph[x][y] == 1) {
			// 방문처리 
			graph[x][y] = 0;
			for(int i=0; i<9; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				dfs(nx, ny);
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 0 0 이 나올 때 까지 테스트케이스 반복 
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			
			// NxM 크기 graph 입력 받음 
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			// 0 0 이면 break 
			if(n==0 && m==0) break;
			
			// graph 세팅 
			graph = new int[n][m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<m; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			// graph 돌면서 모두 dfs 실행하면서 육지가 시작되는 지점에서는 cnt +1 
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(dfs(i, j)) cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
