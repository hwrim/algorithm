package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 행렬테두리회전하기 {

    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{8, 10, 25},
                solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int r1 = query[0] - 1;
            int c1 = query[1] - 1;
            int r2 = query[2] - 1;
            int c2 = query[3] - 1;

            int tmp = map[r1][c1];
            int min = tmp;

            //왼쪽 위 방향
            for (int r = r1+1; r <= r2; r++) {
                min = Math.min(min, map[r][c1]);
                map[r-1][c1] = map[r][c1];
            }
            //왼쪽방향
            for (int c = c1+1; c <= c2; c++) {
                min = Math.min(min, map[r2][c]);
                map[r2][c-1] = map[r2][c];
            }
            //오른쪽 아래 방향
            for(int r=r2-1 ; r>=r1 ; r--) {
                min = Math.min(min, map[r][c2]);
                map[r+1][c2] = map[r][c2];
            }
            //오른쪽 방향
            for(int c=c2-1 ; c>c1 ; c--) {
                min = Math.min(min, map[r1][c]);
                map[r1][c+1] = map[r1][c];
            }
            map[r1][c1+1] = tmp;
            answer[i] = min;
        }

        return answer;
    }
}
