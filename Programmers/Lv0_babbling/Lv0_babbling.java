public class Lv0_babbling {


    static boolean babCheck(int strIndex, int endIndex, String remain) {
        int remainLength = endIndex - strIndex + 1;
        //남은 길이 제거
        if(remainLength <2)
            return false;
        
        switch(remain.charAt(strIndex)){
            case 'a' :{
                if(remain.substring(strIndex,strIndex+3).equals("aya")){
                    
                    if(remainLength - 3 > 1){
                        return babCheck(strIndex + 3, endIndex, remain);
                    }else if(remainLength -3  == 0){
                        return true;
                    }
            
                }else{
                    return false;
                }
                break;
                
            }
            case 'y' :{
                if(remain.substring(strIndex,strIndex+2).equals("ye")){
                    
                    if(remainLength - 2 > 1){
                        return babCheck(strIndex + 2, endIndex, remain);
                    }else if(remainLength -2 == 0){
                        return true;
                    }
            
                }else{
                    return false;
                }
                break;
            }
            case 'w' :{
                if(remain.substring(strIndex, strIndex+3).equals("woo")){
                    
                    if(remainLength - 3 > 1){
                        return babCheck(strIndex + 3, endIndex, remain);
                    }else if(remainLength - 3 == 0){
                        return true;
                    }
            
                }else{
                    return false;
                }
                break;
            }
            case 'm' :{
                if(remain.substring(strIndex, strIndex+2).equals("ma")){
                    
                    if(remainLength - 2  > 1){
                        return babCheck(strIndex + 2, endIndex, remain);
                    }else if(remainLength - 2 == 0){
                        return true;
                    }
            
                }else{
                    return false;
                }
                break;
            }default :{
                break;
            }
        }
        return false;
    }

    public static int solution(String[] babbling) {
        int answer = 0;


        for (String bab : babbling) {

            if(babCheck(0, bab.length()-1, bab)){
                answer++;
            }
            
        }
        
        return answer;
    }

    public static void main(String[] args) {
        String[] babbling = {"yayaeye"};
        int test = solution(babbling);
        System.out.println(test);
    }


    
}

