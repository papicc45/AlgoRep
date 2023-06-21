package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] milkRoad = new int[n];
		int startIndex = Integer.MAX_VALUE;
		for(int i=0 ; i<n ; i++) {
			milkRoad[i] = Integer.parseInt(st.nextToken());
			if(milkRoad[i] == 0) {
				startIndex = Math.min(startIndex, i);
			}
		}
		
		int last = 0;
		int result = 1;
		for(int i=startIndex+1 ; i<n ; i++) {
			if((milkRoad[i] == 1 && last == 0) || (milkRoad[i] == 2 && last == 1) || (milkRoad[i] == 0 && last == 2)) {
				result++;
				last = milkRoad[i];
			}

		}
		
		System.out.println(result);
	}
}
