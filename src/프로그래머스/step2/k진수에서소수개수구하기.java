package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class k진수에서소수개수구하기 {

    @Test
    public void correct() {
        Assertions.assertEquals(3, solution(437674, 3));
        Assertions.assertEquals(2, solution(110011, 10));
    }

    public String toNum(int n, int k) {
        String result = "";
        while (n > 0) {
            result = n % k + result;
            n/=k;
        }
        return result;
    }

    public Boolean isPrime(long num){
        if(num<2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String str = toNum(n, k);
        String[] arr = str.split("0");
        for (String s : arr) {
            if(s.equals("")) continue;
            Long num = Long.parseLong(s);
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }



}
