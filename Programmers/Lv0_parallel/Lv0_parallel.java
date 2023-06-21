package Lv0_parallel;

class Lv0_parallel{


    //기울기 반환 함수
    public  static double giulgi(int[] p1, int[]p2){
        int mx = p1[0]-p2[0];
        int my = p1[1]-p2[1];
        
        return (double)mx/my; //기울기 반환
    }

    public static int solution(int[][] dots){
        int answer = 0;

        // 0 , 1비교
        if(giulgi(dots[0], dots[1]) == giulgi(dots[2], dots[3]) || 
        giulgi(dots[0], dots[2]) == giulgi(dots[1], dots[3]) ||
        giulgi(dots[0], dots[3]) == giulgi(dots[1], dots[2])
        ){
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        System.out.println(solution(dots));
    }
}