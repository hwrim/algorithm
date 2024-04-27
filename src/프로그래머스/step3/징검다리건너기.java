package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 징검다리건너기 {
    @Test
    public void correct() {
        Assertions.assertEquals(3, solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : stones) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        while (min < max) {
            int mid = (min + max + 1) / 2;
            if (isPossible(mid, stones, k)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        return max;
    }

    public boolean isPossible(int mid, int[] stones, int k) {
        int cnt = 0;
        for (int i : stones) {

            if (i - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == k) {
                return false;
            }
        }

        return true;
    }

}
