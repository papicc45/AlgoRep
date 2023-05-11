package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LectureAssignment {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int start = 0;
		int end = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			Lecture temp = pq.poll();
			
			if(end <= temp.start) {
				count++;
				end = temp.end;
			}
		}
		System.out.println(count);
	}
}
class Lecture implements Comparable<Lecture> {
	int start;
	int end ;
	
	public Lecture(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Lecture o) {
		if(o.end == this.end) {
			return this.start - o.start;
		} else {
			return this.end - o.end;
		}
	}
}
