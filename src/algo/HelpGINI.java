package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HelpGINI {
static int x, y;
	
	static char[][] map;
	static boolean[][] visited;
	static int[][] minutes;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static ArrayList<int[]> showerList = new ArrayList<>();
	static int beforeMinute = 0;
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		map = new char[x][y];
		visited = new boolean[x][y];
		minutes = new int[x][y];
		
		int startX = 0;
		int startY = 0;
		
		int homeX = 0;
		int homeY = 0;
		
		for(int i=0 ; i<x ; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0 ; j<y ; j++) {
				if(map[i][j] == 'W') {
					startX = i;
					startY = j;
				} else if(map[i][j] == '*') {
					showerList.add(new int[] {i, j});
				} else if(map[i][j] == 'H') {
					homeX = i;
					homeY = j;
				}
			}
		}
		
		BFS(startX, startY);
		if(minutes[homeX][homeY] == 0) {
			System.out.println("FAIL");
		} else {
			System.out.println(minutes[homeX][homeY]);
		}
		
	}
	static void BFS(int xx, int yy) {
		Queue<Area> q = new LinkedList<>();
		q.add(new Area(xx, yy, 0));
		
		visited[xx][yy] = true;
		shower();
		while(!q.isEmpty()) {
			Area temp = q.poll();
			if(beforeMinute != temp.minute) {
				shower();
			}
			
			beforeMinute = temp.minute;
			
			for(int i=0 ; i<4 ; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<x && ny<y) {
					if(!visited[nx][ny] && map[nx][ny] == '.' || map[nx][ny] == 'H') {
						visited[nx][ny] = true;
						minutes[nx][ny] = temp.minute + 1;
						q.add(new Area(nx, ny, temp.minute + 1));
					}
				}
			}
		}
	}
	static void shower() {
		if(showerList.size() == 0)
			return;
		ArrayList<int[]> cloneList = (ArrayList<int[]>) showerList.clone();
		for(int k=0 ; k<cloneList.size() ; k++) {
			int[] temp = cloneList.get(k);
			System.out.println(temp[0] + " " + temp[1]);
			for(int i=0 ; i<4 ; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(nx>=0 && ny>=0 && nx<x && ny<y) {
					if(map[nx][ny] == '.') {
						map[nx][ny] = '*';
						showerList.add(new int[] {nx, ny});
					}
				}
			}
			showerList.remove(k);
		}
		System.out.println();
	}

}

class Area {
	int x;
	int y;
	int minute;
	
	public Area(int x, int y, int minute) {
		this.x = x;
		this.y = y;
		this.minute = minute;
	}
}
