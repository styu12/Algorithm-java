package greedy;

import java.io.*;

public class silver_1080 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N행 M열 행렬  
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		
		String[] m1 = new String[N];
		String[] m2 = new String[N];
		
		for(int i=0; i<N; i++) m1[i] = br.readLine();
		for(int i=0; i<N; i++) m2[i] = br.readLine();
		
		// m1과 m2를 비교하면서 같으면 0, 다르면 1로 2차원 배열 만들기 
		int[][] m = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				char c1 = m1[i].charAt(j);
				char c2 = m2[i].charAt(j);
				m[i][j] = c1 == c2? 0 : 1;
			}
		}
		
		// 아예 뒤집지도 못하는 상황 예외처리. 
		if(N < 3 || M < 3) {
			boolean same = true;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(m[i][j] == 1) same = false;
				}
			}
			if(same) System.out.println(0);
			else System.out.println(-1);
		}	else {
			
			// 2차원 배열 m을 돌면서, 1이 있으면 0으로 바꾼다. 
			// 바꾸는 동작은 항상 3x3행렬의 (0,0) 자리에서만 실행
			int cnt = 0;
			for(int i=0; i<N-2; i++) {
				for(int j=0; j<M-2; j++) {
					// 시작점이 1인지 체크 
					if(m[i][j] == 0) continue;
					else {
						cnt++;
						m[i][j] = 0;
						m[i+1][j] = m[i+1][j] == 0 ? 1 : 0;
						m[i+2][j] = m[i+2][j] == 0 ? 1 : 0;
						m[i][j+1] = m[i][j+1] == 0 ? 1 : 0;
						m[i+1][j+1] = m[i+1][j+1] == 0 ? 1 : 0;
						m[i+2][j+1] = m[i+2][j+1] == 0 ? 1 : 0;
						m[i][j+2] = m[i][j+2] == 0 ? 1 : 0;
						m[i+1][j+2] = m[i+1][j+2] == 0 ? 1 : 0;
						m[i+2][j+2] = m[i+2][j+2] == 0 ? 1 : 0;
					}
				}	
			}
			
			// 마지막 남은 마지막 2행, 마지막 2열에 1이 있는지 체크
			for(int i=N-2; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(m[i][j] == 1) {
						cnt = -1;
						break;
					}
				}
			}
			
			for(int i=0; i<N-2; i++) {
				for(int j=M-2; j<M; j++) {
					if(m[i][j] == 1) {
						cnt = -1;
						break;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
	}
}
