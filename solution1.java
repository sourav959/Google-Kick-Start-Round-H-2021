import java.util.*;
class Solution{
    static int answer(String S, String F){
        if(F.length()==1){
            int comp=F.charAt(0);
            int sum=0;
            int n=S.length();
            for(int i=0;i<n;i++){
                int temp=S.charAt(i);
                int dif=Math.abs(temp-comp);
                if(dif>13)
                    dif=26-dif;
                sum+=dif;
            }
            return sum;
        }else{
            Set<Character> f=new HashSet<>();
            for(int i=0;i<F.length();i++){
              f.add(F.charAt(i));
            }
            int n=S.length(),sum=0;
            for(int i=0;i<n;i++){
                char c=S.charAt(i);
                if(!f.contains(c)){
                    int min=Integer.MAX_VALUE;
                    for (char s:f){
                        int temp=Math.abs(c-s);
                        if(temp>13)
                            temp=26-temp;
                        if(temp<min)
                            min=temp;
                    }
                    sum+=min;
                }
            }
            return sum;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            String S=sc.next();
            String F=sc.next();
            System.out.println("Case #"+(i+1)+": "+answer(S,F));
        }
    }
}