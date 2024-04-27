package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 귤고르기 {
    @Test
    public void correct() {
        Assertions.assertEquals(3, solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        Assertions.assertEquals(2, solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        Assertions.assertEquals(1, solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    static Map<Integer, Integer>map;
    public int solution(int k, int[] tangerine) {
        map = new HashMap<>();
        int answer = 0;

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t,0)+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new customComparator());

        for (Integer l : list) {
            if (k <= 0) {
                break;
            }
            answer++;
            k -= map.get(l);
        }

        return answer;
    }
    static class customComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }
}
