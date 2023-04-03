package greedy;

import java.io.*;

public class silver_1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		// 알파벳 등장횟수 카운트용 배열 
		int[] alphas = new int[26];
		int odd = -1; // 홀수번 등장하는 알파벳 인덱스 체크 
		boolean ok = true; // 출력 못하는 지 체크하는 플래그 
	
		// 알파벳 배열 세팅 
		for(int i=0; i<str.length(); i++) {
			alphas[str.charAt(i)-'A']++;
		}
		
		for(int i=0; i<26; i++) {
			// 홀수번 등장하는 애가 2개 이상 있으면 팰린드롬 불가능 
			if(alphas[i]%2==1 && odd!=-1) {
				ok=false;
				break;
			}
			
			if(alphas[i]%2==1 && odd==-1) odd=i;
			
			// 등장횟수의 절반만큼만 sb에 붙이고, 카운트 배열도 절반으로 줄임 
			for(int j=0; j<alphas[i]/2; j++) {
				sb.append((char)(i+'A'));
			}
			alphas[i] /= 2;
		}
		
		if(!ok) {
			System.out.println("I'm Sorry Hansoo");
		}	else {
			// 홀수번 등장한 애 있으면 가운데에 넣어주기 
			if(odd != -1) {
				sb.append((char)(odd+'A'));
			}
			
			// 후반부 넣어주기 
			for(int i=25; i>=0; i--) {
				for(int j=0; j<alphas[i]; j++) {
					sb.append((char)(i+'A'));
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}
