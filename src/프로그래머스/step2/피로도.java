package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 피로도 {
    @Test
    public void correct() {
        Assertions.assertEquals(3, solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    static boolean[]visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        return answer;
    }

    public void dfs(int k, int[][] dungeons, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, depth+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }

}
