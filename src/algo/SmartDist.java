package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SmartDist {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		char[] arr = br.readLine().toCharArray();
		
		int result = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] == 'P') {
				int left = i - k;
				int right = i + k;
				
				boolean check = false;
				for(int j=left ; j<i ; j++) {
					if(j>=0 && arr[j] == 'H') {
						result++;
						arr[j] = 'C';
						check = true;
						break;
					}
				}
				
				if(!check) {
					for(int j=i+1 ; j<=right ; j++) {
						if(j<n && arr[j] == 'H') {
							result++;
							arr[j] = 'C';
							break;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
