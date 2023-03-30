// ################################################# DFS 버전 ################################################

package graph;

import java.io.*;
import java.util.*;

public class gold_1976 {

	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visit;
	public static int end; // 도착 도시 번호 
	
	public static boolean dfs(int s) {
		 
		visit[s] = true;  // 방문처리
		
		if(s == end) return true; // 도착 했으면 true 반환 
		else { // 도착점이 아니라면
			boolean ok = false;
			// 인접노드 확인
			for(int i=0; i<graph.get(s).size(); i++) {
				int y = graph.get(s).get(i);
				// 방문하지 않았다면 재귀적으로 호출   
				if(!visit[y]) {
					// 인접노드 중 하나라도 true 리턴 시 얘도 true 리턴
					if(dfs(y)) ok = true;
				}
			}
			return ok;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 도시 개수 n(인덱스 1~n) , 여행도시 수 m개   
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 방문처리 배열 세팅 
		visit = new boolean[n+1];
		// graph에 도시 n개 만큼 arraylist 생성 (가짜노드 0번까지)  
		for(int i=0; i<n+1; i++) graph.add(new ArrayList<Integer>());
		
		// graph 세팅 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				// 연결되어 있다면 
				if(Integer.parseInt(st.nextToken()) == 1) {
					// 양방향으로 graph 업데이트 
					graph.get(i+1).add(j+1);
					graph.get(j+1).add(i+1);
				}
			}
		}
	
		int[] plan = new int[m];
		// 여행 계획 도시 입력받기 
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		// 여행 계획 배열돌면서 start와 end에 따라 dfs 수행 -> true/false 확인 (갈 수 있으면 true)
		// 하나라도 false 나올 시 NO 
		boolean ok = true;
		for(int i=0; i<m-1; i++) {
			// start, end 세팅 
			int start = plan[i];
			end = plan[i+1];
			// dfs 다시 돌리기 위해 visit 초기화 
			visit = new boolean[n+1];
			
			if(!dfs(start)) {
				ok = false;
				break;
			}
		}
		
		if(ok) System.out.println("YES");
		else System.out.println("NO");
	}
}

// ####################################### BFS 버전 ##########################################

//package graph;
//
//import java.io.*;
//import java.util.*;
//
//public class gold_1976 {
//
//	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
//	public static boolean[] visit;
//	public static int end; // 도착 도시 번호
//	public static boolean yes = false; // bfs에서 도착했는지 확인하기 위한 Flag 
//	
//	public static void bfs(int s) {
//		// 큐 만들기
//		Queue<Integer> q = new LinkedList<>();
//		// 방문처리 및 큐에 넣기 
//		visit[s] = true;  
//		q.offer(s);
//		
//		// 큐가 빌 때까
//		while(!q.isEmpty()) {
//			// 하나 뽑아서 도착점인지 확인 -> 도착했으면 반복문 종료 
//			int x = q.poll();
//			if(x == end) {
//				yes = true;
//				break;
//			}
//			
//			// 도착 안 했으면 인접노드 확인 
//			for(int i=0; i<graph.get(x).size(); i++) {
//				int y = graph.get(x).get(i);
//				// 방문 안 했으면 방문처리 및 큐에넣기  
//				if(!visit[y]) {
//					visit[y] = true;
//					q.offer(y);
//				}
//			}
//		}
//
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		// 도시 개수 n(인덱스 1~n) , 여행도시 수 m개   
//		int n = Integer.parseInt(br.readLine());
//		int m = Integer.parseInt(br.readLine());
//		
//		// 방문처리 배열 세팅 
//		visit = new boolean[n+1];
//		// graph에 도시 n개 만큼 arraylist 생성 (가짜노드 0번까지)  
//		for(int i=0; i<n+1; i++) graph.add(new ArrayList<Integer>());
//		
//		// graph 세팅 
//		for(int i=0; i<n; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			for(int j=0; j<n; j++) {
//				// 연결되어 있다면 
//				if(Integer.parseInt(st.nextToken()) == 1) {
//					// 양방향으로 graph 업데이트 
//					graph.get(i+1).add(j+1);
//					graph.get(j+1).add(i+1);
//				}
//			}
//		}
//	
//		int[] plan = new int[m];
//		// 여행 계획 도시 입력받기 
//		st = new StringTokenizer(br.readLine(), " ");
//		for(int i=0; i<m; i++) {
//			plan[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		// 여행 계획 배열돌면서 start와 end에 따라 bfs 수행 -> 플래그 yes의 true/false 확인 (갈 수 있으면 true)
//		// 하나라도 false 나올 시 NO 
//		boolean ok = true;
//		for(int i=0; i<m-1; i++) {
//			// start, end 세팅 
//			int start = plan[i];
//			end = plan[i+1];
//			// dfs 다시 돌리기 위해 visit, yes 초기화 
//			visit = new boolean[n+1];
//			yes = false;
//			
//			bfs(start);
//			if(!yes) {
//				ok = false;
//				break;
//			}
//		}
//		
//		if(ok) System.out.println("YES");
//		else System.out.println("NO");
//	}
//}
