package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 이중우선순위큐 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{0, 0}, solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
        Assertions.assertArrayEquals(new int[]{333, -45}, solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int[] value_zero = {0,0};
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        for(int i=0; i<operations.length;i++){
            String[] op = operations[i].split(" ");
            int value = Integer.parseInt(op[1]);

            if(op[0].equals("I")){
                pqMax.offer(value);
                pqMin.offer(value);
            }
            if(op[0].equals("D")){
                if(!pqMax.isEmpty()){
                    if(op[1].equals("1")){
                        int max = pqMax.peek();
                        pqMax.remove(max);
                        pqMin.remove(max);
                    }
                    if(op[1].equals("-1")){
                        int min = pqMin.peek();
                        pqMax.remove(min);
                        pqMin.remove(min);
                    }
                }
            }
        }
        if(!pqMax.isEmpty()){
            answer[0]=pqMax.peek();
            answer[1]=pqMin.peek();
            return answer;
        }

        return value_zero;
    }
}
