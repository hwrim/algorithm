package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 뉴스클러스터링 {

    @Test
    public void correct() {
        Assertions.assertEquals(16384, solution("FRANCE", "french"));
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                set1.add(first + "" + second);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                set2.add(first + "" + second);
            }
        }

        Collections.sort(set1);
        Collections.sort(set2);

        for (String s : set1) {
            if (set2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        for (String s : set2) {
            union.add(s);
        }

        double jakard = 0;

        if (union.size() == 0)
            jakard = 1;
        else
            jakard = (double) intersection.size() / (double) union.size();

        answer = (int) (jakard*65536);


        return answer;
    }
}
