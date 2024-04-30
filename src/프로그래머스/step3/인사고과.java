package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 인사고과 {
    @Test
    public void correct() {
        Assertions.assertEquals(4, solution(new int[][]{{2,2},{1,4},{3,2},{3,2},{2,1}}));
    }

    public int solution(int[][] scores) {
        int answer = 1;
        int[] me = scores[0];
        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0])
                    return 1;
                else if(o1[0] == o2[0]) {
                    if(o1[1] > o2[1])
                        return 1;
                    else
                        return -1;
                }
                else return -1;
            }
        });
        int mine = me[0] + me[1];
        int point = 0;
        for(int[] score : scores) {
            if(score[1] < point) {
                if(me[0] == score[0] && me[1] == score[1])
                    return -1;
            }
            else {
                point = Math.max(score[1], point);
                if(mine < score[0] + score[1])
                    answer++;
            }
        }
        return answer;
    }
}
