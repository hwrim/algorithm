package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 행렬의덧셈 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[][]{{4, 6}, {7, 9}}, solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}}));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        for(int i=0 ; i<arr1.length ; i++) {
            for(int j=0 ; j<arr1[0].length ; j++) {
                arr1[i][j] += arr2[i][j];
            }
        }
        return arr1;
    }
}
