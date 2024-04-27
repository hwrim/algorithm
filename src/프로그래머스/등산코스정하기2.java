package 프로그래머스;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 등산코스정하기2 {

    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{5,3},
                solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}
                        , new int[]{1,3}, new int[]{5}));
    }

    static class Node {
        int e, w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
    static List<List<Node>> graph;


    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int s = path[0];
            int e = path[1];
            int w = path[2];

            if (isGate(s, gates) || isSummit(e, summits)) {
                graph.get(s).add(new Node(e, w));
            }else if (isGate(e, gates) || isSummit(s, summits)) {
                graph.get(e).add(new Node(s, w));
            }else{
                graph.get(s).add(new Node(e, w));
                graph.get(e).add(new Node(s, w));
            }
            dijkstra(n, gates, summits);
        }
        int[] answer = {};
        return answer;
    }
    static boolean isGate(int s, int[] gates) {
        for (int i : gates) {
            if (s == i) {
                return true;
            }
        }
        return false;
    }

    static boolean isSummit(int s, int[] summits) {
        for (int i : summits) {
            if (s == i) {
                return true;
            }
        }
        return false;
    }

    static void dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> que = new LinkedList<>();
        int[] visited = new int[n+1];

        Arrays.fill(visited, Integer.MAX_VALUE);

        for (int i : gates) {
            que.offer(new Node(i, 0));
            visited[i] = 0;
        }

        while (!que.isEmpty()) {
            Node now = que.poll();
            if(now.w < visited[now.e]) continue;
            for (int i = 0; i < graph.get(now.e).size(); i++) {

            }
        }

    }

}
