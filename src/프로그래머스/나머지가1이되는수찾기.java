package 프로그래머스;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 나머지가1이되는수찾기 {

    @Test
    public void correct() {
        Assertions.assertEquals(50
                , solution(10, 10, new int[]{100}, new int[]{100}, new int[]{7}, new int[]{10}));
        Assertions.assertEquals(499
                , solution(90, 500, new int[]{70, 70, 0}, new int[]{0, 0, 500}, new int[]{100, 100, 2}, new int[]{4, 8, 1}));
    }


    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) (10e9 * 2 * 10e5 * 2);
        int cityLen = g.length;
        long start = 0;
        long end = (long) (10e9 * 2 * 10e5 * 2);

        while (start <= end) {
            long mid = (start + end) / 2;
            int gold = 0;
            int silver = 0;
            int add = 0; //금 + 은 의 양

            for (int i = 0; i < cityLen; i++) {
                int nowGold = g[i];
                int nowSilver = s[i];
                int nowWeight = w[i];
                long nowTime = t[i];

                long moveCount = mid / (nowTime * 2);

                if (mid % (nowTime * 2) >= t[i]) {
                    System.out.println(mid);
                    moveCount++;
                }
                gold += Math.min(nowGold, moveCount * nowWeight);
                silver += Math.min(nowSilver, moveCount * nowWeight);
                add += Math.min(nowGold + nowSilver, moveCount * nowWeight);
            }
            if(gold >= a && silver >= b && add >= a + b) {
                end = mid - 1;
                answer = Math.min(mid, answer);
            }else {
                start = mid + 1;
            }

        }

        return answer;
    }
}


