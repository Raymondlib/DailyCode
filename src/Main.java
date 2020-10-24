
import java.util.*;

public class Main {
    static class node{
        int val;
        public node(int val){
            this.val = val;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x= 0;
        String s = sc.next();
        long a  = Long.parseLong(s);
        if(a<=100000) System.out.println((int)(a*0.1));

        else if (a<=200000){
            x= (int) (0.075*(a-100000));
            System.out.println(10000 + x);
        }else if(a<=400000){
            x = (int) (0.05*(a-200000));
            System.out.println(17500 +x);
        }else if(a<=600000){
            x = (int) (0.03*(a-400000));
            System.out.println(20000 + x);
        }else if(a<=1000000){
            x= (int) (0.015*(a-600000));
            System.out.println(30000 + x);
        }
        else {
            x =(int )(0.01*(a-1000000));
            System.out.println(50000 + x);
        }
    }



}