package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 약수의개수와덧셈 {
    @Test
    public void correct() {
        Assertions.assertEquals(43, solution(13,17));
        Assertions.assertEquals(52, solution(24,27));
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <=right ; i++) {
            int cnt=0;
            for (int j = 1; j <=i ; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            if(cnt%2==0)
                answer+=i;
            else
                answer-=i;
        }
        return answer;
    }
}
