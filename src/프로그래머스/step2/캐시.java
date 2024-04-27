package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 캐시 {
    @Test
    public void correct() {
        Assertions.assertEquals(50, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        Assertions.assertEquals(21, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        Assertions.assertEquals(60, solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        Assertions.assertEquals(52, solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        Assertions.assertEquals(16, solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        Assertions.assertEquals(25, solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String str = cities[i].toUpperCase();
            if (cache.remove(str)) {
                answer += 1;
                cache.add(str);
            } else {
                answer += 5;
                if(cache.size()>=cacheSize)
                    cache.remove(0);
                cache.add(str);
            }
        }
        return answer;
    }
}
