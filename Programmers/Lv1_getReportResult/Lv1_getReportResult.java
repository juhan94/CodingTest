package Lv1_getReportResult;

import java.util.HashMap;

class Lv1_getReportResult{




    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //reportCheck은 누가 누구를 신고했는지 기록하는데 필요
        //map은 각 아이디에 인덱스를 부여해서 reportCheck를 활용(신고한 id와 신고당한 id에 따라 각 인덱스에 표시함)하기 위해 필요
        int[][] reportCheck = new int[id_list.length][id_list.length];
        HashMap<String, Integer> map = new HashMap<String,Integer>();

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }


        for (int i = 0; i < report.length; i++) {
            String[] res = report[i].split(" ");
            int singoja = map.get(res[0]);
            int dangham = map.get(res[1]);

            reportCheck[singoja][dangham] = 1;
        }

        //신고 당한 횟수 추출
    
        
        for (int i = 0; i < reportCheck.length; i++) {
            int kCount = 0;
            // int[] mailCount = new int[id_list.length];
            // 메일카운트가 필요없는게 그냥 다시 repourtCheck를 돌면되기 때문에
            for (int j = 0; j < reportCheck.length; j++) {
                if(reportCheck[j][i] == 1){
                    kCount++;
                    // mailCount[j] = 1;
                }
            }
            if(kCount >= k){
                //i를 신고한 사람 메일 수 ++ 
                for (int j = 0; j < reportCheck.length; j++) {
                    // if(mailCount[j] == 1)
                    if(reportCheck[j][i] == 1)
                        answer[j] ++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] answer = solution(id_list,report,k);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}