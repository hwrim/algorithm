package 프로그래머스.kakao2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class 양과늑대 {

    @Test
    public void correct() {
        Assertions.assertEquals(5,
                solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}));
    }

    static int maxSheep;
    static int[] list;
    static boolean[][][] visited;
    static ArrayList<Integer>[] map;

    public int solution(int[] info, int[][] edges) {
        maxSheep = 0;
        list = info;
        visited = new boolean[info.length][info.length + 1][info.length + 1];
        map = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            map[start].add(end);
            map[end].add(start);
        }

        dfs(0, 0, 0);

        return maxSheep;
    }

    public static void dfs(int now, int sheep, int wolf) {
        if (list[now] == 0) sheep++;
        else if (list[now] == 1) wolf++;
        if (wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);

        for (int i = 0; i < map[now].size(); i++) {
            int next = map[now].get(i);
            int tmp = list[now];

            if (!visited[next][sheep][wolf]) {
                list[now] = -1;
                visited[now][sheep][wolf] = true;
                dfs(next, sheep, wolf);
                list[now] = tmp;
                visited[now][sheep][wolf] = false;
            }

        }


    }

}
