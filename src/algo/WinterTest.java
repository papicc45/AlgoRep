package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WinterTest {
	static int x, y;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] map;
	static boolean[][] visited;
	
	static ArrayList<int[]> iceList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		map = new int[x][y];
		
		for(int i=0 ; i<x ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<y ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					iceList.add(new int[] {i, j});
				}
			}
		}
		
		int days = 0;
		while(!CheckAllMelt()) {
			visited = new boolean[x][y];
			CheckOutAir(0, 0);
			MeltIce();
			days++;
		}
		
		System.out.println(days);
	
	}
	static void CheckOutAir(int tx, int ty) {
		visited[tx][ty] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nx = tx + dx[i];
			int ny = ty + dy[i];
			
			if(nx>=0 && ny>=0 && nx<x && ny<y) {
				if(!visited[nx][ny] && map[nx][ny] != 1) {
					map[nx][ny] = 2;
					CheckOutAir(nx, ny);
				}
			}
		}
	}
	static void MeltIce() {
		for(int i=0 ; i<iceList.size() ; i++) {
			int[] temp = iceList.get(i);
			int outAirCount = 0;
			for(int j=0 ; j<4 ; j++) {
				int nx = temp[0] + dx[j];
				int ny = temp[1] + dy[j];
				
				if(nx>=0 && ny>=0 && nx<x && ny<y) {
					if(map[nx][ny] == 2) {
						outAirCount++;
					}
				}
			}
			if(outAirCount >= 2) {
				map[temp[0]][temp[1]] = 0;
				iceList.remove(i);
				i--;
			}
		}
	}
	static boolean CheckAllMelt() {
		for(int i=0 ; i<x ; i++) {
			for(int j=0 ; j<y ; j++) {
				if(map[i][j] == 1)
					return false;
			}
		}
		return true;
	}
}
