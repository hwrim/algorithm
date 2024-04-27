package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class 연속펄스부분수열의합 {

    @Test
    public void correct() {
        Assertions.assertEquals(10, solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
    }

    public long solution(int[] sequence) {
        long answer = 0;

        boolean flag = true;

        long caseOne = 0;
        long caseTwo = 0;

        for(int num : sequence){
            caseOne += flag ? num : -num;
            caseTwo += flag ? -num : num;

            caseOne = Math.max(0, caseOne);
            caseTwo = Math.max(0, caseTwo);

            answer = Math.max(answer, Math.max(caseOne, caseTwo));

            flag = !flag;
        }

        return answer;
    }
}
