package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 삼진법뒤집기 {
    @Test
    public void correct() {
        Assertions.assertEquals(7, solution(45));
    }

    public int solution(int n) {
        String answer = "";
        while (n > 0) {
            answer += n % 3;
            n /= 3;
        }
        return Integer.parseInt(answer,3);
    }
}
