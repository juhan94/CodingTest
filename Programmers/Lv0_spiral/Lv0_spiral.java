package Lv0_spiral;
class Lv0_spiral{
    
    public static int[][] solution(int n){
        int[][] answer = new int[n][n];
         //2차원 배열 선언 해깔림.
        int[] cur = {0,-1};
        int[][] directions = {{0,1}, {1,0}, {0,-1},{-1,-0}}; 
        //굳이 상관없지만 그냥 방향 값을 x, y 1차원 배열로 각각 만드는게 코딩하는데는 더 편할듯.
        int dirCount = 0;

        //배열을 초기화하지 않으면 값은 0이기 때문에 하지 않아도 되긴함.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = 0;
            }
        }
        
        for (int i = 1; i <= n*n; i++) {
            int curx = cur[1] + directions[dirCount][1];
            int cury = cur[0] + directions[dirCount][0];

            //더이상 못가는 곳인가,방문했나 check
            if(curx >= n || cury >= n || curx < 0 || cury < 0 || answer[cury][curx] != 0){
                dirCount++;
                i--;
                if(dirCount == 4) 
                    dirCount = 0;
                //dirCount % 4 = dirCount; 가 더 깔끔했을 듯.

            }else{
                answer[cury][curx] = i;
                cur[0] = cury;
                cur[1] = curx;
            }
                    
        }

        return answer;
    }
    
    public static void main(String[] args) {
        int[][] test = solution(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(test[i][j]);
            }
            System.out.println();
        }
    }
}