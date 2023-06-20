### 프로그래머스 - 옹알이(1) 오답노트

* 문제풀이 과정 :
    1. 문자열을 입력받고, 시작인덱스, 종료인덱스를 인수로 보냈을 때, 
    2. 조건에 충족하는지 확인 후
    3. 시작인덱스를 남은 문자열의 시작인덱스만큼 이동 후
    4. 재귀함수를 사용하고자 함.
    > 그런데 일단 재귀함수를 사용하면 런타임 에러가 발생할 가능성이 높다는 걸 간과한 점도 있음.
<hr/>

* 수정한 코드 : 
```java
public class Lv0_babbling2 {

    public static int solution(String[] babbling){
        int answer = 0;
        String[] babType = {"aya","ye","woo","ma"};
        for (String bab : babbling) {
        
            for (String type : babType) {
                if(bab.contains(type))
                    bab = bab.replace(type, "*");
                    //replace가 대체한 문자열을 '반환'한다는 것을 주의!!!
            }
            if(bab.replace("*", "").equals(""))
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] test = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.print(solution(test));
    }
}
```


* 알고가기 : 
    + String 메서드들
        - 포함 contains(s) s문자열 포함하는지 체크
        - 추출 substring(a,b) a부터 b전 까지 추출
        - 분리 split(r) 지정된 분리자로 문자배열 반환
        - 대체 replace(old,new) old문자열을 new문자열로 모두 바꿔서 반환


<hr>
* 느낀 점 : 사고 방식의 전환이 필요한 게 크게 느껴짐.
