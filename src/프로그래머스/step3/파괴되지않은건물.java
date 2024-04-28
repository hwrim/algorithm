package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class 파괴되지않은건물 {

    @Test
    public void correct() {
        Assertions.assertEquals(10, solution(
                new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}
                , new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
        Assertions.assertEquals(6, solution(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
                , new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));
    }

    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;

        int[][] map = new int[N + 1][M + 1];

        for (int[] arr : skill) {
            int r1 = arr[1];
            int c1 = arr[2];
            int r2 = arr[3];
            int c2 = arr[4];
            int type = arr[5] * (arr[0] == 1 ? -1 : 1);
            map[r1][c1] += type;
            map[r1][c2 + 1] += (type * -1);
            map[r2 + 1][c1] += (type * -1);
            map[r2 + 1][c2 + 1] += type;
        }

        calc(map, N, M);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + map[i][j] > 0) answer++;
            }
        }

        return answer;

    }

    public void calc(int[][] map, int N, int M) {
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] += map[r - 1][c];
            }
        }

        for (int c = 1; c < M; c++) {
            for (int r = 0; r < N; r++) {
                map[r][c] += map[r][c - 1];
            }
        }


    }
}
