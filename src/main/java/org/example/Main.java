package org.example;

/**
 * @author sangu02
 * @since 2024-09-05
 * @implNote 프로그래머스 문제 해결
 */

/**
 * 문제 설명
 * 정수 num1과 num2가 매개변수로 주어집니다.
 * 두 수가 같으면 1 다르면 -1을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * 0 ≤ num1 ≤ 10,000
 * 0 ≤ num2 ≤ 10,000
 */

/**
 * 우선 매우 간단한 테스트로, 생각할 것이 많지 않다.
 * 숫자 1과 숫자 2를 비교하여 같은지를 판단한다.
 * 리턴 숫자를 같으면 1, 다르면 2로 세팅한다.
 * 삼항 연산식을 통해 1줄의 코드로 선언이 가능하고,
 * 조건문(IF)를 사용하여 각기 다른 리턴을 주거나 수만 정의한 뒤 작동부의 마지막에 코드를 삽입할 수 있다.
 */
public class Main {
    public static void main(String[] args) {
        // 테스트는 우선 10회
        for (int i = 0; i < 10 ; i++) {
            // Math.random() 함수는 소수점으로 반환하기때문에, 우선 백의 자리수까지 가져오기위한 배열을 선언한다.
            int[] random = {10,100,1000,10,100,1000,10,100,1000,100};

            // 랜덤한 양 수를 가져온다.
            int ranNum1 = (int) (Math.random() * random[i]);
            int ranNum2 = (int) (Math.random()*  random[i]);

            // 두 수가 같으면 1, 다르면 -1을 반환하게끔 한다.
            int returnNum = (ranNum1 == ranNum2) ? 1 : -1;
        }

        /**
         * 출력 로그
         ----------- i = 0 ---------------
         ranNum1 = 2
         ranNum2 = 0
         returnNum = -1
         ----------- i = 1 ---------------
         ranNum1 = 5
         ranNum2 = 51
         returnNum = -1
         ----------- i = 2 ---------------
         ranNum1 = 159
         ranNum2 = 17
         returnNum = -1
         ----------- i = 3 ---------------
         ranNum1 = 7
         ranNum2 = 8
         returnNum = -1
         ----------- i = 4 ---------------
         ranNum1 = 11
         ranNum2 = 73
         returnNum = -1
         ----------- i = 5 ---------------
         ranNum1 = 771
         ranNum2 = 787
         returnNum = -1
         ----------- i = 6 ---------------
         ranNum1 = 6
         ranNum2 = 6
         returnNum = 1
         ----------- i = 7 ---------------
         ranNum1 = 16
         ranNum2 = 82
         returnNum = -1
         ----------- i = 8 ---------------
         ranNum1 = 395
         ranNum2 = 343
         returnNum = -1
         ----------- i = 9 ---------------
         ranNum1 = 84
         ranNum2 = 25
         returnNum = -1
         */


    }
}