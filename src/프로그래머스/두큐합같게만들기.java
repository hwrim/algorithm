package 프로그래머스;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    @Test
    public void correct() {
        Assertions.assertEquals(2,
                solution(new int[]{3, 2, 7, 2}
                        ,new int[]{4, 6, 5, 1}));
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;


        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1=0;
        long sum2=0;
        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }
        for (int i : queue2) {
            q2.add(i);
            sum2 += i;
        }

        System.out.println(sum1);
        System.out.println(sum2);


        while (sum1 != sum2) {
            answer++;

            if (sum1 > sum2) {
                int val = q1.poll();
                sum1-=val;
                sum2+=val;
                q2.add(val);
            }else{
                int val = q2.poll();
                sum1+=val;
                sum2-=val;
                q1.add(val);
            }
            if(answer > (queue1.length + queue2.length) * 2) return -1;
        }


        return answer;
    }
}
