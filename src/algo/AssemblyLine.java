package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AssemblyLine {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			System.out.println(Math.min(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			return;
		}
		int[][] arr = new int[n][4];
		int result = 0;
		
		int lastA = 0;
		int lastB = 0;
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(i != n-1) {
				int jobA = Integer.parseInt(st.nextToken());
				int jobB = Integer.parseInt(st.nextToken());
				
				int AToB = Integer.parseInt(st.nextToken());
				int BToA = Integer.parseInt(st.nextToken());
				
				arr[i][0] = jobA;
				arr[i][1] = jobB;
				arr[i][2] = AToB;
				arr[i][3] = BToA;
			} else {
				lastA = Integer.parseInt(st.nextToken());
				lastB = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n-1][2];
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		
		for(int i=1 ; i<n-1 ; i++) {
			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1] + arr[i-1][3]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0] + arr[i-1][2]) + arr[i][1];
		}
		
		System.out.println
				(Math.min
						(Math.min
									(Math.min(dp[n-2][0] + lastA, dp[n-2][1] + lastB),
						dp[n-2][0] + arr[n-2][2] + lastB),
				dp[n-2][1] + arr[n-2][3] + lastA)
				);
		
	}
}
