package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 뉴스클러스터링2 {

    @Test
    public void correct() {
        Assertions.assertEquals(16384, solution("FRANCE", "french"));
        Assertions.assertEquals(65536, solution("handshake", "shake hands"));
        Assertions.assertEquals(43690, solution("aa1+aa2", "AAAA12"));
        Assertions.assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));
    }

    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        List<String> union = new ArrayList<>(); //합집합
        List<String> intersection = new ArrayList<>();//교집합

        for (int i = 0; i < str1.length() - 1; i++) {
            char fir = str1.charAt(i);
            char sec = str1.charAt(i + 1);
            if (fir >= 'a' && fir <= 'z' && sec >= 'a' && sec <= 'z') {
                set1.add(fir + "" + sec);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char fir = str2.charAt(i);
            char sec = str2.charAt(i + 1);
            if (fir >= 'a' && fir <= 'z' && sec >= 'a' && sec <= 'z') {
                set2.add(fir + "" + sec);
            }
        }
        Collections.sort(set1);
        Collections.sort(set2);

        for (String s : set1) {
            if (set2.remove(s)) {//교집합
                intersection.add(s);
            }
            union.add(s);
        }
        for (String s : set2) {
            union.add(s);
        }

        double jakard = 0;
        if (union.size() == 0) {
            jakard = 1;
        }else{
            jakard = (double) intersection.size() / (double) union.size();
        }

        answer = (int) (jakard*65536);

        return answer;
    }

}
