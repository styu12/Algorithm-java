package queue;

import java.io.*;
import java.util.*;

public class silver_5464 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		// 주차 공간N개, 차량 M대 
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		
		// 주차공간 배열 
		Lot[] lots = new Lot[N];
		for(int i=0; i<N; i++) {
			int price = Integer.parseInt(br.readLine());
			lots[i] = new Lot(i+1, price);
		}
		
		// 차량 배열 
		Car[] cars = new Car[M];
		for(int i=0; i<M; i++) {
			int weight = Integer.parseInt(br.readLine());
			cars[i] = new Car(i+1, weight);
		}
		
		// 대기줄 큐 
		Queue<Integer> q = new LinkedList<>();
		
		// 현재 주차중인 차량 대수 parkings & 매출 money 
		int parkings = 0;
		int money = 0;
		
		// 차량 출입 정보 (총 2M번 ) 
		for(int i=0; i<M*2; i++) {
			int carNum = Integer.parseInt(br.readLine());
			// in
			if(carNum > 0) {
				if(!q.isEmpty()) q.offer(carNum); // 대기 줄이 있는 경우 
				else if(parkings < N) {  // 줄 없고, 자리 있을 때
					// 주차공간 배열 돌며 빈 공간 찾기 
					for(int j=0; j<N; j++) {
						if(lots[j].carNum != 0) continue;
						else {
							lots[j].carNum = carNum;
							parkings++;
							// 들어갈 때 돈계산 해주자 
							money += lots[j].price * cars[carNum-1].weight;
							// 주차했으니 break 
							break;
						}
					}
				}	else q.offer(carNum); // 줄 없고 자리 없을 때 
			}
			// out
			else {
				carNum *= -1;
				int lotNum = 0;
				// 대기줄이 없을 때
				// => 주차공간 배열 돌면서 해당 차량이 주차한 공간 찾기 
				for(int j=0; j<N; j++) {   
					if(lots[j].carNum == carNum) {
						// 주차공간 비우고, 주차수 -1 
						lots[j].carNum = 0;
						// 해당 주차공간 인덱스 저장 
						lotNum = j;
						parkings--;
					}
				}
				
				if(!q.isEmpty()) { // 대기줄이  있을 때
					// 대기줄에서 번호 뽑아와서 방금 빠진 주차공간에 넣기 
					int newCarNum = q.poll();
					lots[lotNum].carNum = newCarNum;
					parkings++;
					// 들어갈 때 계산 
					money += lots[lotNum].price * cars[newCarNum-1].weight;
				}
				
			}
		}
		
		System.out.println(money);
		
	}
}

// 주차공간 Lot - 공간번호, 무게당가격, 주차중인 차량 번호 (없으면 0) 
class Lot {
	int num;
	int price;
	int carNum;
	
	public Lot(int num, int price) {
		this.num = num;
		this.price = price;
		this.carNum = 0;
	}
}

// 차량 Car - 차량번호, 무게 
class Car {
	int num;
	int weight;
	
	public Car(int num, int weight) {
		this.num = num;
		this.weight = weight;
	}
}