package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 할인행사 {

    @Test
    public void correct() {
        Assertions.assertEquals(3, solution(new String[]{"banana", "apple", "rice", "pork", "pot"},new int[]{3, 2, 2, 2, 1},new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }

        int buyPeriod = 0;
        for (int i = 0; i < number.length; i++) {
            buyPeriod += number[i];
        }

        int startDay = 0;
        int lastDay = buyPeriod-1;
        int[] buyItem = new int[number.length];

        for (int i = 0; i < buyPeriod; i++) {
            if (map.containsKey(discount[i])) {
                buyItem[map.get(discount[i])]++;
            }
        }

        while (true) {
            if(isRange(number, buyItem)) answer++;

            if(map.containsKey(discount[startDay]))
                buyItem[map.get(discount[startDay])]--;

            startDay++;
            lastDay++;

            if(lastDay == discount.length) break;

            if(map.containsKey(discount[lastDay]))
                buyItem[map.get(discount[lastDay])]++;
        }

        return answer;
    }

    static Boolean isRange(int[] number, int[] buyItem) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > buyItem[i]) return false;
        }
        return true;
    }


}
