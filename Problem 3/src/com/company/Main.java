package com.company;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(9);
        s.push(6);
        s.push(8);
        s.push(5);
        s.push(4);
        s.push(11);
        s.push(4);
        System.out.println("Input: " + s.toString());
        System.out.println("Output: " + sort(s).toString());
    }

    static Stack<Integer> sort(Stack<Integer> s) {
        // create new empty stack
        Stack<Integer> outStack = new Stack<>();
        // if stack to be sorted is empty, return an empty stack
        if (s.isEmpty())
            return outStack;
        Stack<Integer> auxStack = new Stack<>();
        // while stack to be sorted is not empty
        while (!s.isEmpty()) {
            int tmp = s.pop();
            // if the sorted stack is empty, push the first value of the incoming stack onto the sorted stack
            if(outStack.isEmpty())
                outStack.push(tmp);
            else {
                // while the first value of the sorted stack is greater than the incoming value
                while (outStack.peek() > tmp) {
                    // pop the sorted stack and push it onto an auxiliary stack
                    auxStack.push(outStack.pop());
                }
                // push the new value onto the sorted stack
                outStack.push(tmp);
                // push the auxiliary stack onto the sorted stack
                while(!auxStack.isEmpty()) {
                    outStack.push(auxStack.pop());
                }
            }
        }
        return outStack;
    }
}
