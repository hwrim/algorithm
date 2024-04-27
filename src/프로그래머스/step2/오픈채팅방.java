package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 오픈채팅방 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}
                , solution(new String[]{
                        "Enter uid1234 Muzi",
                        "Enter uid4567 Prodo",
                        "Leave uid1234",
                        "Enter uid1234 Prodo",
                        "Change uid4567 Ryan"}));
    }

    public String[] solution(String[] record) {
        StringTokenizer st;
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String log : record) {
            st = new StringTokenizer(log);
            String command = st.nextToken();
            String id = st.nextToken();
            String name = "";
            if (!"Leave".equals(command)) {
                name = st.nextToken();
            }
            switch (command) {
                case "Enter":
                    map.put(id, name);
                    list.add(id + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(id + "님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(id, name);
                    break;
            }
        }
        String[] answer = new String[list.size()];
        int idx = 0;
        for (String a : list) {
            int loc = a.indexOf("님");
            String id = a.substring(0,loc);
            answer[idx++] = a.replace(id,map.get(id));
        }

        return answer;
    }
}
