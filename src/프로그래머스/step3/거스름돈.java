package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 거스름돈 {
    @Test
    public void correct() {
        Assertions.assertEquals(4, solution(5, new int[]{1, 2, 5}));
    }

    public int solution(int n, int[] money) {

        int answer = 0;
        int[][] dp = new int[money.length + 1][n + 1];
        Arrays.sort(money); //시간 초과 나서 추가 함
        for (int i = 1; i < money.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (j < money[i - 1]) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = (dp[i-1][j] + dp[i][j - money[i-1]]) % 1000000007;
                    }
                }
            }
        }

        answer = dp[money.length][n];

        return answer;
    }
}
