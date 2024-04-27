package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 없는숫자더하기 {
    @Test
    public void correct() {
        Assertions.assertEquals(14, solution(new int[]{1,2,3,4,6,7,8,0}));
        Assertions.assertEquals(6, solution(new int[]{5,8,4,0,6,7,9}));
    }

    public int solution(int[] numbers) {
        int answer = 45;
        for (int n : numbers) {
            answer -= n;
        }
        return answer;
    }
}
