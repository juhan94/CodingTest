### 프로그래머스 - 옹알이(1) 오답노트

풀이시간 : 70분 정답
* 문제풀이 과정 :
    1. 누가 누구한테 보냈는지 기록해야하니까 대충 2차원 배열 필요하겠다 생각함.
    2. 뭔가 id_list를 구분하고 찾으려면 key value 값이 있는 Map을 써야할 것 같다고 생각했는데, 맞는지 아니면 2차원배열만 써도 해결 되는지 명확하지 않았음.
    3. Map 사용법 기억안나서 찾아봄 (30분 지남)
    4. 입력한 2차원 배열을 돌면서 신고당한 사람이 몇번 신고 당했는지 k 값과 비교가 필요한데, 반복문의 i,j 그리고 신고자,신고당한자의 위치가 헷갈려서 오래걸림.
    5. k값 이상인 신고당한 자를 찾았을 때 누가 신고했는 지 또 찾는게 비효율적이지 않나? 라고 생각해서 주저함. 그냥 반복문 또 돌림. 이 과정에서 그냥 변수타입에 대한 실수가 있었음.

<hr/>
<!-- TODO -->
* 수정한 코드 : 이번엔 다른 사람 풀이에 대한 분석
```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
```
<hr>

<!-- TODO -->
* 알고가기 : 
    + Map 사용법(#Todo)


<hr>
* 느낀 점 : 여전히 풀이 속도가 느리다. 느린 이유는 

1. 무엇이 필요한 지 생각하는데 오래걸림
2. 확신이 없어서 맞는 지 고민이 필요함
3. 배열의 활용(종/횡) 헷갈려함
4. Map 사용법을 몰랐음
5. 코드 작성 중 필요한 변수타입의 정확한 정의와 쓰임을 몰라서 대충선언하게 됨 
> reportCheck[j][i]에서 <br> 
내가 반복문을 통해 하려는 게 무엇인 지 정확히 하고, <Br>
배열의 각 열이 무엇을 가르키는지 확인<br>
ex) "내가 '피신고자'에 대한 '신고자 수를 체크해서 k값과 비교해아하는 구나... 그러니까 피신고자는 고정이니까 i를 고정으로하고 j값을 반복하면 되겠구나" 라는 식의 생각이 필요함