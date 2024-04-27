package 프로그래머스.devMatching21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 로또의최고순위와처저쉰위 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{3, 5}
                , solution(new int[]{44, 1, 0, 0, 31, 25}
                        , new int[]{31, 10, 45, 1, 6, 19}));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int myLotto = 0;
        int numLotto = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                myLotto++;
                continue;
            }
            for (int num : win_nums) {
                if (num == lotto) {
                    numLotto++;
                    break;
                }
            }
        }
        return new int[]{7 - Math.max(myLotto + numLotto, 1), 7 - Math.max(numLotto, 1)};
    }

}
