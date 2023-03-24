package greedy;

import java.io.*;
import java.util.*;

public class silver_1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 기타 줄 N개, 브랜드 M개 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 패키지 가격,낱개 가격 각각 최소값으로 업데이트 해나갈 것 
		int pkg = Integer.MAX_VALUE;
		int unit = Integer.MAX_VALUE;
		
		// 브랜드 가격 입력받으면서 최소값 업데이트 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pkg = Math.min(pkg, Integer.parseInt(st.nextToken()));
			unit = Math.min(unit, Integer.parseInt(st.nextToken()));
		}
		
		// 총 세 가지 경우 중 최소값을 정답으로 지정 
		int ans = Math.min(pkg*(N/6)+unit*(N%6), pkg*((N/6)+1));
		ans = Math.min(ans, unit*N);

		System.out.println(ans);
	}
}
