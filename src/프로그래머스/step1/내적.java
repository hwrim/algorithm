package 프로그래머스.step1;

public class 내적 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {-3,-1,0,2};
        System.out.println(solution(a,b));
    }
    //내적 = a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]
    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
}
