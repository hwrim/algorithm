import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{4, 9}
                , solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}}));
    }

    static int zero = 0;
    static int one = 0;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];



        answer[0] = zero;
        answer[1] = one;

        return answer;
    }

}
