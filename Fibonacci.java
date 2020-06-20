
public class Fibonacci{
    public static int of(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        else{
            return of(n - 1) + of(n - 2);
        }
    }

    public static void main(String args[]){
        for(int i = 1; ;i ++){
            if(Fibonacci.of(i) > 200)
            break;
            System.out.println(Fibonacci.of(i));
        }
    }
}


