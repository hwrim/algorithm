package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 최고의집합 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{4,5}, solution(2,9));
        Assertions.assertArrayEquals(new int[]{-1}, solution(2,1));
        Assertions.assertArrayEquals(new int[]{4,4}, solution(2,8));
    }

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int val = s/n;
        int res = s%n;
        for (int i = 0; i < n-res; i++) {
            answer[i] = val;
        }
        for (int i = n-res; i < n; i++) {
            answer[i]= val+1;
        }

        return answer;
    }
}
