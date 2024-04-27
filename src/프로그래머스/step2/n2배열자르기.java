package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class n2배열자르기 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{3, 2, 2, 3}, solution(3, 2, 5));
        Assertions.assertArrayEquals(new int[]{4, 3, 3, 3, 4, 4, 4, 4}, solution(4, 7, 14));
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        for (int i = 0; i < answer.length; i++) {
            int row = (int) ((i + left) / n) + 1;
            int col = (int) ((i + left) % n) + 1;
            answer[i] = Math.max(row, col);
        }
        return answer;
    }
}
