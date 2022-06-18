package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 하샤드수 {
    @Test
    public void correct() {
        Assertions.assertEquals(false, solution(11));
    }

    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int a = x;

        while (a >= 1) {
            sum += a % 10;
            a /= 10;
        }


        if (x % sum != 0) {
            answer = false;
        }

        return answer;
    }
}
