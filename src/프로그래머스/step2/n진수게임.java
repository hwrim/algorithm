package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class n진수게임 {

    @Test
    public void correct() {
        Assertions.assertEquals("0111", solution(2, 4, 2, 1));
        Assertions.assertEquals("02468ACE11111111", solution(16, 16, 2, 1));
        Assertions.assertEquals("13579BDF01234567", solution(16, 16, 2, 2));
    }

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        //n 진법
        //t 미리 구할 숫자의 갯수
        //m 게임에 참가하는 인원
        //p 튜브의 순서

        String game = "";
        int count = t * m;
        int idx = 0;

//        System.out.println("start : " + game.length());
        while (game.length() < count) {
            game += Integer.toString(idx++, n);
//            System.out.println(game);
        }

        for (int i = p - 1; i < count; i += m) {
//            System.out.println(game.charAt(i));
            answer+=game.charAt(i);
        }

        return answer.toUpperCase();
    }


}
