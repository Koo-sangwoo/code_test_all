package org.example;

/**
 * 문제 설명
 * 사진들을 보며 추억에 젖어 있던 루는 사진별로 추억 점수를 매길려고 합니다.
 * 사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 됩니다.
 * 예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때,
 * 해당 사진의 추억 점수는 16(5 + 10 + 1)점이 됩니다.
 * 다른 사진 속 인물의 이름이 ["kali", "mari", "don", "tony"]이고
 * ["kali", "mari", "don"]의 그리움 점수가 각각 [11점, 1점, 55점]]이고,
 * "tony"는 그리움 점수가 없을 때, 이 사진의 추억 점수는 3명의 그리움 점수를 합한 67(11 + 1 + 55)점입니다.
 * <p>
 * 그리워하는 사람의 이름을 담은 문자열 배열 name,
 * 각 사람별 그리움 점수를 담은 정수 배열 yearning,
 * 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때,
 * 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * 3 ≤ name의 길이 = yearning의 길이≤ 100
 * 3 ≤ name의 원소의 길이 ≤ 7
 * name의 원소들은 알파벳 소문자로만 이루어져 있습니다.
 * name에는 중복된 값이 들어가지 않습니다.
 * 1 ≤ yearning[i] ≤ 100
 * yearning[i]는 i번째 사람의 그리움 점수입니다.
 * 3 ≤ photo의 길이 ≤ 100
 * 1 ≤ photo[i]의 길이 ≤ 100
 * 3 ≤ photo[i]의 원소(문자열)의 길이 ≤ 7
 * photo[i]의 원소들은 알파벳 소문자로만 이루어져 있습니다.
 * photo[i]의 원소들은 중복된 값이 들어가지 않습니다.
 */

/**
 * 제한사항
 * 3 ≤ name의 길이 = yearning의 길이≤ 100
 * 3 ≤ name의 원소의 길이 ≤ 7
 * name의 원소들은 알파벳 소문자로만 이루어져 있습니다.
 * name에는 중복된 값이 들어가지 않습니다.
 * 1 ≤ yearning[i] ≤ 100
 * yearning[i]는 i번째 사람의 그리움 점수입니다.
 * 3 ≤ photo의 길이 ≤ 100
 * 1 ≤ photo[i]의 길이 ≤ 100
 * 3 ≤ photo[i]의 원소(문자열)의 길이 ≤ 7
 * photo[i]의 원소들은 알파벳 소문자로만 이루어져 있습니다.
 * photo[i]의 원소들은 중복된 값이 들어가지 않습니다.
 */

/**
 * 우선 name 배열과 yearning 배열의 인덱스를 비교해 리턴하는 함수를 제작한다.
 * 이중 for문으로 들어가야한다.
 * 1차 for문은 리턴할 answer 배열의 값을 담는다.
 * 2차 for문에서는 위에 제작한 함수를 통해 각 photo요소의 점수를 합하도록한다.
 */
public class Main {
    String[] name = {"may", "kein", "kain", "radi" };
    static int[] yearning = {5, 10, 1, 3};

    static String[][] photo = {
            {"may", "kein", "kain", "radi" },
            {"may", "kein", "brin", "deny" },
            {"kon", "kain", "may", "coni" }
    };
    
    public static void main(String[] args) {
      
        int[] answer = new int[photo.length]; // 최종값을 받는 배열
        
        // 최종적으로 answer변수에 값을 담는 for문
        for (int i = 0; i < photo.length; i++) {
            int photoYearning = 0; // 해당 사진의 그리움 점수
            // photo의 값을 계산하고 더하는 for문
            for (int j = 0; j < photo[i].length; j++) {
                // 그리움 값을 리턴받는 함수
                // 해당 사람의 그리움 값을 사진 그리움 값에 추가
                photoYearning += yearningThisPeople(photo[i][j],photo[i]);
                System.out.println("=================================" );
            }
            System.out.println("photoYearning = " + photoYearning);
            answer[i] = photoYearning;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println("answer = " + answer[i]);
        }
    }

    /**
     * 1차 오류, 사람이 없을때를 생각하지 않고
     * 그저 List와 비교만함
     * @param peopleName
     * @param photoList
     * @return
     */
   static public int yearningThisPeople(String peopleName, String[] photoList){


        for (int i = 0; i < photoList.length; i++) {
            System.out.println("peopleName = " + peopleName);
            System.out.println("photoList[i] = " + photoList[i]);
            if(peopleName.equals(photoList[i])){
                System.out.println("yearning[i] = " + yearning[i]);
                return yearning[i];
            }
        }
        return 0;
    }
}