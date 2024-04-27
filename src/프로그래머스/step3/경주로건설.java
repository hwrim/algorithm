package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
    @Test
    public void correct() {

        Assertions.assertEquals(900, solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        Assertions.assertEquals(3800, solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}}));
        Assertions.assertEquals(2100, solution(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
        Assertions.assertEquals(3200, solution(new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}));
    }

    int N;
    int[][][] visited;
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Queue<Node> que;
    int result;

    public class Node {
        int r, c, d, cost;

        public Node(int r, int c, int d, int cost) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        visited = new int[N][N][4];
        result = Integer.MAX_VALUE;
        answer = bfs(board);
        return answer;
    }

    public int bfs(int[][] board) {
        que = new LinkedList<>();
        que.add(new Node(0, 0, -1, 0));
        while (!que.isEmpty()) {
            Node now = que.poll();
            if(now.r == N-1 && now.c == N-1) {
                result = Math.min(result,now.cost);
            }
            for (int d = 0; d < 4; d++) {
                int dirX = now.r + dirs[d][0];
                int dirY = now.c + dirs[d][1];
                if (dirX < 0 || dirX >= N || dirY < 0 || dirY >= N || board[dirX][dirY] == 1) {
                    continue;
                }
                int cost = now.cost;
                if (now.d == -1 || now.d == d) {
                    cost += 100;
                } else cost += 600;

                if(visited[dirX][dirY][d] == 0 || board[dirX][dirY] >= cost) {
                    que.add(new Node(dirX, dirY,d, cost));
                    visited[dirX][dirY][d] = 1;
                    board[dirX][dirY] = cost;
                }

            }
        }
        return result;
    }

}
