package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 콜라츠추측 {

    @Test
    public void correct() {
        Assertions.assertEquals(4, solution(16));
    }

    public int solution(long num) {
        int answer = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num *= 3;
                num++;
            }
            answer++;
            if (answer == 500) {
                return -1;
            }
        }
        return answer;
    }

}
