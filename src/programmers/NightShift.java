package programmers;

import java.awt.image.AbstractMultiResolutionImage;
import java.util.Collections;
import java.util.PriorityQueue;

public class NightShift {
	public static void main(String[] args) {
		System.out.println(solution(4, new int[] {4, 3, 3}));
		System.out.println(solution(1, new int[] {2, 1, 2}));
		System.out.println(solution(3, new int[] {1, 1}));
	}
	
	public static long solution(int n, int[] works) {
        long answer = 0;
        
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0 ; i<works.length ; i++) {
            pq.add(works[i]);
            total += works[i];
        }
        
        if(n >= total)
            return 0;
        
        for(int i=0 ; i<n ; i++) {
            int temp = pq.poll();
            pq.add(temp - 1);
        }
        
        
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);    
        }
        return answer;
    }
}
