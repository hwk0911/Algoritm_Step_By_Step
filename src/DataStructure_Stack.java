import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataStructure_Stack {
    static int[] stack = {0,0,0,0,0};
    static int top = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] work;

        while(true){
            work = br.readLine().split(" ");

            if(work[0].equals("push")){
                push(Integer.parseInt(work[1]));
            }
            else if(work[0].equals("pop")){
                pop();
            }

            checkStack(stack);
        }
    }

    public static void push(int data) {
        if(top == stack.length){
            System.out.println("Stack Overflow Error");
        }
        else{
            stack[top] = data;
            ++top;
        }
    }

    public static void pop() {
        if(top == 0){
            System.out.println("Stack Overflow Error");
        }
        else{
            --top;
            stack[top] = 0;
        }
    }

    public static void checkStack(int[] stack) {
        for(int index = 0, size = stack.length ; index < size ; ++index){
            if(stack[index] != 0){
                System.out.print(stack[index] + " ");
            }
        }
        System.out.println();
    }
}
