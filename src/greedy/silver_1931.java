//package greedy;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class silver_1931 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		int answer = 0;
//		// 가장 마지막으로 끝나는 시간 - 끝나는 시간에 주목 
//		int lastEnd = 0;
//		
//		int N = Integer.parseInt(br.readLine());
//		// 회의 [시작시간, 끝시간] 2차원 배열에 담자 
//		int[][] meetings = new int[N][2];
//		
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			meetings[i][0] = start;
//			meetings[i][1] = end;
//		}
//		
//		// 끝나는 시간 기준으로 정렬 
//		Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0] );
//		Arrays.sort(meetings, (m1, m2) -> m1[1] - m2[1] );
//		System.out.println(Arrays.deepToString(meetings));
//		
//		// 가장 마지막으로 끝나는 시간보다 늦게 시작하면 회의 가능 & lastEnd 업데이트 
//		for(int i = 0; i < meetings.length; i++) {
//			int start = meetings[i][0];
//			int end = meetings[i][1];
//			
//			if(start >= lastEnd) {
//				lastEnd = end;
//				answer++;
//			}
//		}
//		
//		System.out.println(answer);
//	}
//}

package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class silver_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int answer = 0; 
		int lastEnd = 0;
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		
		for(int i = 0; i < N; i++) {
			// 입력값 받아서 Meeting 객체 만든 후 리스트에 넣
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
		
		// 끝나는 시간 기준으로 정렬 - Meeting Class에 CompareTo 구
		Arrays.sort(meetings);
		
		// 가장 마지막으로 끝나는 시간보다 늦게 시작하면 회의 가능 & lastEnd 업데이트 
		for(int i = 0; i < meetings.length; i++) {
			int start = meetings[i].start;
			int end = meetings[i].end;
			
			if(start >= lastEnd) {
				lastEnd = end;
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Meeting o) {
			if(end == o.end) {
				return Integer.compare(start, o.start);
			} 
			return Integer.compare(end, o.end);
		}
	}
}

