package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class 포켓몬 {
    @Test
    public void correct(){
        Assertions.assertEquals(3, solution(new int[]{3,3,3,2,2,4}));
    }

    public int solution(int[] nums) {
        int answer = nums.length/2;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        if (set.size() > answer) {
            return answer;
        } else {
            return set.size();
        }
    }

}
