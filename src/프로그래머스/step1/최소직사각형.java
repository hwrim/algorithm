package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최소직사각형 {

    @Test
    public void correct() {
        Assertions.assertEquals(4000, solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        Assertions.assertEquals(120, solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        Assertions.assertEquals(133, solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }

    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        answer = maxWidth * maxHeight;
        return answer;
    }

}
