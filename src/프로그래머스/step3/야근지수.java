package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 야근지수 {

    @Test
    public void correct() {
        Assertions.assertEquals(12, solution(4, new int[]{4,3,3}));
        Assertions.assertEquals(6, solution(1, new int[]{2,1,2}));
        Assertions.assertEquals(0, solution(3, new int[]{1,1}));
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        while (n > 0) {
            int max = pq.poll();
            if (max==0) break;
            pq.add(--max);
            n--;

        }
        for(int work : pq) {
            answer += work * work;
        }
        return answer;
    }
}
