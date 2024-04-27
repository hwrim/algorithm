package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 나머지가1이되는수찾기 {
    @Test
    public void correct() {
        Assertions.assertEquals(3, solution(10));
        Assertions.assertEquals(11, solution(12));
    }

    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }

        return -1;
    }
}
