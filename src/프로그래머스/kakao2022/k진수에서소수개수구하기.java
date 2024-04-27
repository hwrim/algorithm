package 프로그래머스.kakao2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class k진수에서소수개수구하기 {

    @Test
    public void correct() {
        Assertions.assertEquals(2, solution(110011, 10));
    }

    public int solution(int n, int k) {
        int answer = 0;
        String chg = binaryChg(n, k);
        String[]arr = chg.split("0");
        for (String a : arr) {
            if(("").equals(a)) continue;
            if (isPrime(Long.valueOf(a))) {
                answer++;
            }
        }
        return answer;
    }

    public String binaryChg(int n, int k) {
        String result = "";
        while (n > 0) {
            result = n % k + result;
            n /= k;
        }
        return result;
    }

    public boolean isPrime(long n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
