package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class gold_1339 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alphaCnt = new int[26];
		
		for(int i = 0; i < N; i++) {
			String alphas = br.readLine();
			for(int j = 0; j < alphas.length(); j++) {
				int index = alphas.charAt(j) - 'A';
				int item = (int)Math.pow(10, alphas.length() - j - 1);
				alphaCnt[index] += item;
			}
		}
		
		Arrays.sort(alphaCnt);
		int sum = 0;
		int num = 9;
		
		for(int i = alphaCnt.length - 1; i > 0; i--) {
			if(alphaCnt[i] > 0) {
				sum += num * alphaCnt[i];
				num--;
			}
			if(num == 0) break;
		}
		
		System.out.println(sum);
	}
}

/* 
 * 	최종적으로 구하고자 하는 것을 보자! 
 * "합"의 최댓값 => 10100A + 1001C + 10F ... 이런식
 * A~Z배열을 만들어 몇을 곱해야하는지를 값으로 넣(알파벳 총 26개)
 *   큰 값부터 차례로 9~1 대입!
 */
