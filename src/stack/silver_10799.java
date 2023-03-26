package stack;

import java.io.*;

public class silver_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int ans = 0;
		int bar = 0;
	
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') bar++;
			else {
				if(str.charAt(i-1) == '(') {
					ans += --bar;
				}	else {
					ans++;
					bar--;
				}
			}
		}
		
		System.out.println(ans);
	}
}
