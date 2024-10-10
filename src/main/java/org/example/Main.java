package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // 개인정보 유형에 따라 달을 가져오게끔 만든다.
    // 이후 해당 월 수에 28을 곱해 일 수로 변경한다.
    // 차이나는 연수는 1보다 크면 그냥 삭제다. 인덱스에 +1을 해서 그냥 넘긴다.

    // 보관기간을 나타내는 배열의 테스트값
    private static String[] terms = {"A 6", "B 12", "C 3"};

    // 클라이언트의 개인정보 동의 날짜 및 유형
    private static String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

    // 테스트 데이터
    private static String today = "2022.05.19";

    public static void main(String[] args) {
        // 리턴값
        int[] answer = {};
        List<Integer> valueList = new ArrayList<>();

        String[] todayVal = today.split("\\.");

        int todayYear = Integer.parseInt(todayVal[0]);
        int todayMonth = Integer.parseInt(todayVal[1]);
        int todayDate = Integer.parseInt(todayVal[2]);

        // 파기조건 월수를 담는 로직
        List<Map<String, Integer>> termList = new ArrayList<>();
        for (String termStr : terms) {
            Map<String, Integer> termMap = new HashMap<>();
            String[] splitVal = termStr.split(" ");
            termMap.put(splitVal[0], Integer.valueOf(splitVal[1]));
            termList.add(termMap);
        }

        for (int i=0; i < privacies.length; i++) {
            String[] splitVal = privacies[i].split(" ");
            String collectDate = splitVal[0];
            String collectType = splitVal[1];
            
            String[] splitDate = collectDate.split("\\.");
            int collectYear = Integer.parseInt(splitDate[0]);
            int collectMonth = Integer.parseInt(splitDate[1]);
            int collectDay = Integer.parseInt(splitDate[2]);
            System.out.println("todayYear + \",\" + collectYear = " + todayYear + "," + collectYear);

            int deleteDate = 0;
            if(todayYear == collectYear){ // 연수가 같으면 월 수로만 계산하여 뺀다.
                System.out.println("여기");
                for (int j = 0; j < termList.size(); j++) {
                    System.out.println(collectType);
                    Integer month = termList.get(j).get(collectType);
                    System.out.println("month = " + month);
                    if (month != null) {
                        deleteDate = month * 28;
                    }
                }
                // 연수가 같으면 무조건 금일 월수와 같거나 작을수밖에없음
                int lateDate = (todayMonth - collectMonth) * 28 + (todayDate - collectDay);
                System.out.println("lateDate + \"/\" + deleteDate = " + lateDate + "/" + deleteDate);
                if(lateDate >= deleteDate){
                    System.out.println("들어간다~");
                    valueList.add(i+1);
                }
            } else if (todayYear != collectYear) {
                System.out.println("여기 2");
                int year = todayYear - collectYear;
                int month =(year * 12) + todayMonth - collectMonth;
                int date = todayDate + collectDay;
                
                int lateDate = month * 28 + date;
                
                for (int j = 0; j < termList.size(); j++) {
                    System.out.println(collectType);
                    Integer typeMonth = termList.get(j).get(collectType);
                    System.out.println("typeMonth = " + typeMonth);
                    if (typeMonth != null) {
                        deleteDate = typeMonth * 28;
                    }
                }
                System.out.println("lateDate + \"/\" + deleteDate = " + lateDate + "/" + deleteDate);

                if(lateDate >= deleteDate){
                    System.out.println("들어간다~");
                    valueList.add(i+1);
                }
            }
        }

        for (int i = 0; i < valueList.size(); i++) {
            answer = new int[valueList.size()];
            answer[i] = valueList.get(i);
            System.out.println("answer[i] = " + answer[i]);
        }
        
    }
}