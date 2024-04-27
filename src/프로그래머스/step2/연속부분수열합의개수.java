package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 연속부분수열합의개수 {
    @Test
    public void correct() {
        Assertions.assertEquals(18, solution(new int[]{7, 9, 1, 1, 4}));
    }

    public int solution(int[] elements) {

        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        for (int size = 1; size <= len; size++) {
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = i; j < i + size; j++) {
                    sum += elements[j%len];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
