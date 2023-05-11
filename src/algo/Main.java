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


public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long k = Long.parseLong(st.nextToken());
		long p = Long.parseLong(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		n  *= 10;
		long result = recur(p, n);
		result *= k;
		System.out.println(result % 1000000007);
	}
	static long recur(long x, long y) {
		if(y == 1) {
			return x;
		}
		
		long ret = recur(x, y/2);
		
		ret = (ret * ret) % 1000000007;
		if(y%2 == 1) {
			ret = ret * x % 1000000007;
		}
		
		return ret;
	}
	
}



