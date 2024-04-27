package 프로그래머스.step3;


import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 부대복귀 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{1, 2}, solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1));
        Assertions.assertArrayEquals(new int[]{2, -1, 0}, solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5));
    }

    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    static Queue<Integer> que;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        list = new ArrayList<>();
        visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int [] road : roads){
            int from = road[0];
            int to = road[1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        for(int i =1; i<visited.length; i++){
            System.out.print(visited[i]+" ");
        }
        System.out.println();
        dijkstra(destination);

        for(int i =1; i<visited.length; i++){
            System.out.print(visited[i]+" ");
        }
        System.out.println();


        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = (visited[sources[i]] < Integer.MAX_VALUE) ? visited[sources[i]] : -1;
        }
        return answer;
    }
    public static void dijkstra(int destination) {
        que = new LinkedList<>();
        que.add(destination);
        visited[destination] = 0;

        while (!que.isEmpty()){
            int start = que.poll();
            for(int i =0; i<list.get(start).size(); i++){
                int next = list.get(start).get(i);
                if(visited[next]>visited[start]+1){
                    visited[next] = visited[start]+1;
                    que.add(next);
                }
            }
        }
    }
}
