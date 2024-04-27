package 프로그래머스.kakao2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class 파괴되지않는건물 {

    @Test
    public void correct() {
        Assertions.assertEquals(10,
                solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}},
                        new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
    }

    static int[][] mapSum;
    static int N, M;

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        N = board.length;
        M = board[0].length;

        mapSum = new int[N + 1][M + 1];

        for (int[] a : skill) {
            int r1 = a[1];
            int c1 = a[2];
            int r2 = a[3];
            int c2 = a[4];
            int attack = a[5] * (a[0] == 1 ? -1 : 1);
            mapSum[r1][c1] += attack;
            mapSum[r1][c2 + 1] += (attack * -1);
            mapSum[r2 + 1][c1] += (attack * -1);
            mapSum[r2 + 1][c2 + 1] += attack;
        }

        sum();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + mapSum[i][j] > 0) answer++;
            }
        }

        return answer;
    }
    public static void sum() {
        // 좌우
        for (int c = 1; c < M; c++) {
            for (int r = 0; r < N; r++) {
                mapSum[r][c] += mapSum[r][c - 1];
            }
        }
        // 상하
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                mapSum[r][c] += mapSum[r - 1][c];
            }
        }
    }

}
