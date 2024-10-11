package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
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


            int deleteDate = 0;
            if(todayYear == collectYear){ // 연수가 같으면 월 수로만 계산하여 뺀다.
                for (int j = 0; j < termList.size(); j++) {
                    System.out.println(collectType);
                    Integer month = termList.get(j).get(collectType);
                    System.out.println("month = " + month);
                    if (month != null) {
                        deleteDate = month * 28;
                    }
                }
                // 연수가 같으면 무조건 금일 월수와 같거나 작을수밖에없음
                int lateDate = (todayMonth - collectMonth) * 28
                        + (todayDate - collectDay);
                System.out.println("lateDate + \"/\" + deleteDate = " + lateDate + "/" + deleteDate);
                if(lateDate >= deleteDate){
                    valueList.add(i+1);
                }
            } else if (todayYear != collectYear) {
                int year = todayYear - collectYear;
                int month =(year * 12) + todayMonth - collectMonth;
                int date = todayDate - collectDay;

                int lateDate = month * 28 + date;

                for (int j = 0; j < termList.size(); j++) {
                    Integer typeMonth = termList.get(j).get(collectType);
                    if (typeMonth != null) {
                        deleteDate = typeMonth * 28;
                    }
                }



                if(lateDate >= deleteDate){
                    valueList.add(i+1);
                }
            }
        }

        for (int i = 0; i < valueList.size(); i++) {
            answer = new int[valueList.size()];
            answer[i] = valueList.get(i);
        }
        return answer;
    }
}


