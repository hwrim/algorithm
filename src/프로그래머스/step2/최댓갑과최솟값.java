package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최댓갑과최솟값 {
    @Test
    public void correct() {
        Assertions.assertEquals("1 4", solution("1 2 3 4"));
        Assertions.assertEquals("-4 -1", solution("-1 -2 -3 -4"));
        Assertions.assertEquals("-1 -1", solution("-1 -1"));
    }
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int min  = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int a = Integer.parseInt(arr[i]);
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        answer =min+" "+max;

        return answer;
    }
}
