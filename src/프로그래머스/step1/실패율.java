package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class 실패율 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{3, 4, 2, 1, 5}, solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int member = stages.length;

        List<Stage> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int num = 0;
            for (int j = 0; j < stages.length; j++) {
                //실패 인원수 찾기
                if (i == stages[j]) {
                    num++;
                }
            }
            if (num == 0) {
                list.add(new Stage(i, 0));
                continue;
            }
            list.add(new Stage(i, (double) num / member)); //소수점계산
            member -= num;
        }

        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).idx;
        }

        return answer;
    }

    static class Stage implements Comparable<Stage> {
        int idx;
        double rate;

        public Stage(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }

        @Override
        public int compareTo(Stage o) {
            //기본 return은 내림차순
            //같은 실패율, 앞 스테이지부터 내림차순
            if (this.rate == o.rate) {
                return this.idx - o.idx;
            }
            return Double.compare(o.rate, this.rate);
        }
    }
}
