<h1>코딩테스트 문제 정답 코드 및 해결방안 정리 리포지토리</h1>
<hr>

- 문제 설명
  - 사진들을 보며 추억에 젖어 있던 루는 사진별로 추억 점수를 매길려고 합니다. 사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 됩니다. 예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)점이 됩니다. 다른 사진 속 인물의 이름이 ["kali", "mari", "don", "tony"]이고 ["kali", "mari", "don"]의 그리움 점수가 각각 [11점, 1점, 55점]]이고, "tony"는 그리움 점수가 없을 때,
  - 이 사진의 추억 점수는 3명의 그리움 점수를 합한 67(11 + 1 + 55)점입니다.
  - 그리워하는 사람의 이름을 담은 문자열 배열 name, 각 사람별 그리움 점수를 담은 정수 배열 yearning, 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때, 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.

- 제한사항
  - 3 ≤ name의 길이 = yearning의 길이≤ 100
  - 3 ≤ name의 원소의 길이 ≤ 7
  - name의 원소들은 알파벳 소문자로만 이루어져 있습니다.
  - name에는 중복된 값이 들어가지 않습니다.
  - 1 ≤ yearning[i] ≤ 100
  - yearning[i]는 i번째 사람의 그리움 점수입니다.
  - 3 ≤ photo의 길이 ≤ 100
  - 1 ≤ photo[i]의 길이 ≤ 100
  - 3 ≤ photo[i]의 원소(문자열)의 길이 ≤ 7
  - photo[i]의 원소들은 알파벳 소문자로만 이루어져 있습니다.
  - photo[i]의 원소들은 중복된 값이 들어가지 않습니다.

<h1>풀이</h1>
<hr>

- 우선 사람 이름에 따른 그리움 점수를 가지는 Map에 데이터를 정리한다.
~~~
static public Map<String,Integer> settingNameAndYearning(String[] peopleList, int[] yearning) {
Map<String, Integer> nameAndScore = new HashMap<>();

       for (int i = 0; i < peopleList.length; i++) {
           nameAndScore.put(peopleList[i],yearning[i]);
       }

       return nameAndScore;
    }
~~~

- 사람의 이름과 위 함수에서 세팅한 그리움 Map 변수를 받아 그리움 점수를 리턴하는 함수를 만든다.
~~~
    // HashMap에서 점수를 찾아 없으면 0, 있으면 해당 점수를 리턴하게한다.
    private static int findScore(String peopleName, Map<String,Integer> nameAndScore) {
        if(nameAndScore.get(peopleName) == null){
            return 0;
        }else{
            return nameAndScore.get(peopleName);
        }
    }
~~~

- 2중 for문을 통해 하나는 사진 장수대로 돌아가는 반복문, 안쪽은 사진속 사람의 그리움 점수를 구하는 for문을 돌린다.
~~~
        // 최종적으로 answer변수에 값을 담는 for문
        for (int i = 0; i < photo.length; i++) {
            int photoYearning = 0;
            for (int j = 0; j < photo[i].length; j++) {
                photoYearning += findScore(photo[i][j], settingScore);
            }
            answer[i] = photoYearning;
        }
~~~

- 위처럼 answer에 담으면 끝난다!    

