package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;


public class Fan {
	final static int[][] grid = {
		    {1, 0, 0, 0, 0},
		    {1, 0, 0, 0, 0},
		    {1, 0, 0, 0, 0},
		    {6, 2, 2, 2, 6},
		    {0, 0, 0, 0, 1},
		    {0, 6, 1, 1, 0}
		};
	
	static int x = grid.length;
	static int y = grid[0].length;
	
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] map;
	
	static int max = Integer.MIN_VALUE;
	static int cnt = 0;
	static boolean[] direct = new boolean[4];
	static boolean[] useFan;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long start = System.currentTimeMillis();
		visited = new boolean[x][y];
		map = new int[x][y];
		
		ArrayList<int[]> fanList = new ArrayList<>();
		for(int i=0 ; i<x ; i++) {
			for(int j=0 ; j<y ; j++) {
				if(grid[i][j] == 6) {
					fanList.add(new int[] {i, j});
				}
			}
		}
		
		useFan = new boolean[fanList.size()];
		System.out.println(fanList.size());
		DFS(fanList, 0);
		
		System.out.println(max);
		long end = System.currentTimeMillis();
		
		System.out.println("실행시간 : " + (end - start) / 1000.0);
	}
	static void DFS(ArrayList<int[]> fanList,  int count) {
		
		if(count == fanList.size()) {
			for(int i=0 ; i<x ; i++) {
				for(int j=0 ; j<y ; j++) {
					System.out.print(map[i][j] + " ");
					if(grid[i][j] != 0 && grid[i][j] != 6) {
						if(map[i][j] >= grid[i][j]) {
							cnt++;
						}
					}
				}
				System.out.println();
			}
			System.out.println(cnt);
			System.out.println();
			max = Math.max(max, cnt);
			cnt = 0;
			return;
		}
		
		for(int i=0 ; i<fanList.size() ; i++) {
			int[] temp = fanList.get(i);
			if(!useFan[i]) {
				System.out.println("i : " + i);
				useFan[i] = true;
				for(int j=0 ; j<4 ; j++) {
					wind(temp[0], temp[1], dx[j], dy[j]);
					DFS(fanList, count + 1);
					unWind(temp[0], temp[1], dx[j], dy[j]);
				}
				useFan[i] = false;
			}
		}
	}
	private static void wind(int fanX, int fanY, int directX, int directY) {
		int nx = fanX + directX;
		int ny = fanY + directY;
		
		while(nx>=0 && ny>=0 && nx<x && ny<y 
						&& grid[nx][ny] != 6 && grid[nx][ny] != 0) {
			map[nx][ny]++;
			
			nx += directX;
			ny += directY;
		}
	}
	
	private static void unWind(int fanX, int fanY, int directX, int directY) {
		int nx = fanX + directX;
		int ny = fanY + directY;
		
		while(nx>=0 && ny>=0 && nx<x && ny<y 
						&& grid[nx][ny] != 6 && grid[nx][ny] != 0) {
			map[nx][ny]--;
			
			nx += directX;
			ny += directY;
		}
	}
}


