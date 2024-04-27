package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 사라지는발판 {
    @Test
        public void correct() {
            Assertions.assertEquals("5",
                    solution(new int[][]{{1,1,1},{1,1,1},{1,1,1}}
                            ,new int[]{1,0}
                            ,new int[]{1,2}));
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        return answer;
    }
}
