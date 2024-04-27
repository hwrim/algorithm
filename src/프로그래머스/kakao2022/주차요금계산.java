package 프로그래머스.kakao2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 주차요금계산 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{14600, 34400, 5000},
                solution(new int[]{180, 5000, 10, 600}
                        , new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }


    public int[] solution(int[] fees, String[] records) {
        int lastTime = getMin("23:59");
        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        List<String> cars = new ArrayList<>();

        for (String record : records) {
            String[] rc = record.split(" ");
            int time = getMin(rc[0]);
            String car = rc[1];

            if (!cars.contains(car)) {
                cars.add(car);
                times.put(car, 0);
            }

            if (parking.containsKey(car)) {
                times.put(car, times.get(car) + (time - parking.get(car)));
                parking.remove(car);
            } else {
                parking.put(car, time);
            }

        }

        int[] result = new int[cars.size()];
        Collections.sort(cars);

        for (int i = 0; i < cars.size(); i++) {
            result[i] = fees[1];
            String car = cars.get(i);
            int time = times.get(car) - fees[0];
            if (parking.containsKey(car))
                time += (lastTime - parking.get(car));
            if (time > 0)
                result[i] += (Math.ceil(time / (fees[2] * 1.0)) * fees[3]);
        }

        return result;
    }

    public int getMin(String time) {
        String[] t = time.split(":");
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }
}
