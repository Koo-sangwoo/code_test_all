<h1>코딩테스트 문제 정답 코드 및 해결방안 정리 리포지토리</h1>
<br>


- 문제 설명
- 2자리 이상의 정수 number가 주어집니다. 주어진 코드는 이 수를 2자리씩 자른 뒤, 자른 수를 모두 더해서 그 합을 출력하는 코드입니다. 
- 코드가 올바르게 작동하도록 한 줄을 수정해 주세요.

- 제한사항
- 10 ≤ number ≤ 2,000,000,000
- number의 자릿수는 2의 배수입니다.


- 디버깅(Debugging)은 이미 완성된 코드에서 버그를 찾아 수정하는 문제 타입입니다.
- 1줄만 수정하여 버그를 고치세요. 
- 2줄 이상 수정할 경우, 실행 결과에 에러 메시지가 표시됩니다.
  

- 1차 시도 코드
  - 결과 : 실패 
  - Why? 4자리 수만 들어오지않는다.
  - 반복문은 힌트, 계속해서 2자리 수를 구하고 해당 값을 더해야함
  - 1줄만 바꿔야하기때문에 조건문을 수정해야한다.

```
  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int number = sc.nextInt();
  int answer = 0;

        for(int i=0; i<1; i++){
            answer += number % 100;
            answer += number / 100;
        }

        System.out.println(answer);
  }
```    

- 2차 시도 및 코드
  - 4자릿수만 생각함.(for문 사용 이유 해답)
  - 문제를 읽고 제대로 상기해야함
  - for문 조건문을 수정해야한다고 생각
  - Integer가 아니기때문에 length()함수를 이용한 조건 불사
  - for문은 돌리고 끝이 아니라 항상 조건문과 i를 비교한다. 그러면 number가 나누어져 0이되면 알아서 종료하게하면된다.
  - length에 number를 넣어야한다고 생각
  - 테스트 결과 통과
  - 최종 채점 통과

```

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

```