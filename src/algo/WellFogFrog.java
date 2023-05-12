package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WellFogFrog {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] weight = new int[n];
		boolean[] best = new boolean[n];
		for(int i=0 ; i<n ; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			best[i] = true;
		}
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0 ; i<=n ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i=1 ; i<=n ; i++) {
			ArrayList<Integer> getList = list.get(i);
			int tempWeight = weight[i-1];
			for(Integer j : getList) {
				if(tempWeight <= weight[j-1])
					best[i-1] = false;
			}
		}
		
		int cnt = 0;
		for(int i=0 ; i<best.length ; i++) {
			if(best[i])
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
