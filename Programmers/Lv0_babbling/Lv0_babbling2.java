public class Lv0_babbling2 {

    public static int solution(String[] babbling){
        int answer = 0;
        String[] babType = {"aya","ye","woo","ma"};
        for (String bab : babbling) {
        
            for (String type : babType) {
                if(bab.contains(type))
                    bab = bab.replace(type, "*");
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
