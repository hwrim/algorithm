public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        System.out.println(solution("1zerotwozero3"));
    }
    static String[] word = {"zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine"};
    static String[] num ={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static int solution(String s) {
        for (int i = 0; i < 10; i++) {
            s = s.replace(word[i], num[i]);
        }
        return Integer.parseInt(s);
    }
}
