package org.example;

import java.util.Scanner;
/**
 * 문제 설명
 * 2자리 이상의 정수 number가 주어집니다. 주어진 코드는 이 수를 2자리씩 자른 뒤, 자른 수를 모두 더해서 그 합을 출력하는 코드입니다. 코드가 올바르게 작동하도록 한 줄을 수정해 주세요.
 *
 * 제한사항
 * 10 ≤ number ≤ 2,000,000,000
 * number의 자릿수는 2의 배수입니다.
 */

/**
 * 디버깅(Debugging)은 이미 완성된 코드에서 버그를 찾아 수정하는 문제 타입입니다.
 * 1줄만 수정하여 버그를 고치세요.
 * 2줄 이상 수정할 경우, 실행 결과에 에러 메시지가 표시됩니다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;

        for(int i=0; i<number; i++){
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer);
    }
}