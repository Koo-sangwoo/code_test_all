package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 우선 함수로 역할을 삼분할하여 코드는 완성했지만,
 * 다른 코드를 보고 비슷하게 만들어보자
 */
public class OtherCode {

    // 변수 복붙~
    static String[] name = {"may", "kein", "kain", "radi" };
    static int[] yearning = {5, 10, 1, 3};

    static String[][] photo = {
            {"may", "kein", "kain", "radi" },
            {"may", "kein", "brin", "deny" },
            {"kon", "kain", "may", "coni" }
    };

    public static void main(String[] args) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameAndScore = new HashMap<>();

        // Map 세팅
        for (int i = 0; i < name.length; i++) {
            nameAndScore.put(name[i], yearning[i]);
        }

        // 점수 합산부
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                sum += (nameAndScore.get(photo[i][j]) == null) ? 0 : nameAndScore.get(photo[i][j]);
            }
            answer[i] = sum;
        }


        // 출력부, 무시
        for (int i = 0; i < answer.length; i++) {
            if(i == 0)
                System.out.print("answer : " + answer[i] + " , ");
            else if (i == answer.length-1){
                System.out.print(answer[i]);
            }else{
                System.out.print(answer[i] + " , ");
            }
        }
    }
}
