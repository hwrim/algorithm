package 프로그래머스.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class test5 {
    @Test
    public void correct() {
        Assertions.assertEquals(3,solution(new int[]{1,1,3,3,2,2}));
    }

    public int solution(int[] tasks) {
        int answer = 0;
        Map<Integer, Integer>map = new HashMap<>();
        for (int i = 0; i < tasks.length-1; i++) {
            if (map.size() != 0 && map.get(tasks[i])>0) {
                continue;
            }
            for (int j = i+1; j < tasks.length; j++) {
                if (tasks[i] == tasks[j]) {
                    map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
                }
            }
        }
        for (int a : map.keySet()) {
            if (map.get(a) > 0 && map.get(a) < 3) {
                answer++;
            } else {
                answer = -1;
            }
        }
        return answer;
    }
}
