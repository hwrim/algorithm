package 프로그래머스.devMatching21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map;

public class 다단계칫솔판매 {

    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{360, 958, 108, 0, 450, 18, 180, 1080},
                solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
                        , new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
                        , new String[]{"young", "john", "tod", "emily", "mary"}
                        , new int[]{12, 4, 2, 5, 10}));
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> child = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            child.put(enroll[i],i);
        }

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int money = amount[i]*100;
            while (!("-").equals(name)) {
                int giveMoney = money/10;
                int mine = money - giveMoney;
                answer[child.get(name)] += mine;
                name = parent.get(name);
                money /= 10;
                if (money<1) break;
            }
        }

        return answer;
    }
}
