package programmers;

import java.util.*;

public class HotelDaesil {
	public static void main(String[] args) {
		 System.out.println(solution(new String[][] {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
	}
	public static int solution(String[][] book_time) {
        int answer = 1;
        
        int[][] time = new int[book_time.length][2];
        for(int i=0 ; i<book_time.length ; i++) {
            String[] strTime1 = book_time[i][0].split(":");
            String[] strTime2 = book_time[i][1].split(":");
            
            time[i][0] = Integer.parseInt(strTime1[0]) * 60 + Integer.parseInt(strTime1[1]);
            time[i][1] = Integer.parseInt(strTime2[0]) * 60 + Integer.parseInt(strTime2[1]);
            
        }
        
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        
        for(int i=0 ; i<time.length ; i++) {
            System.out.println("start : " + time[i][0] + "  end : " + time[i][1]);
        }
        
        PriorityQueue<Room> pq = new PriorityQueue<>();
        pq.add(new Room(time[0][0], time[0][1]));
        
        int index = 1;
        while(index < book_time.length) {
            Room r = pq.peek();
            if(r.end + 10 > time[index][0]) {
                answer++;
                
            } else {
                pq.poll();
            }
            pq.add(new Room(time[index][0], time[index][1]));
            index++;
            
        }
        
        return answer;
    }
}
class Room implements Comparable<Room> {
    int start;
    int end;
    
    public Room(int start ,int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Room room) {
        return this.end - room.end;
    }
}
