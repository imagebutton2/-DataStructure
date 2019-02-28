package com.study.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {
    public static void main(String[] args) throws IOException{
        String input=null,output;
        while (true){
            System.out.println("input String:");
            System.out.flush();
            try {
                input=getString();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (input.equals(""))
                    break;
                Reverse theReverse=new Reverse(input);
                output=theReverse.doRev();
                System.out.println("Reverse:"+output);
            }

        }

    }
    public static String getString()throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
            String s=br.readLine();
        return s;
    }
}
class Reverse{
    private String input;
    private String output;
    public Reverse(String in){
        input=in;
    }
    public String doRev(){
        int stackSize=input.length();
        StackX theStack=new StackX(stackSize);
        for (int j=0;j<input.length();j++){
            char ch=input.charAt(j);
            theStack.push(ch);
        }
        output="";
        while (!theStack.isEmpty()){
            char ch=theStack.pop();
            output=output+ch;
        }
        return output;
    }
}
class StackX{
    private int maxSize;
    private char [] stackArray;
    private int top=-1;
    public StackX(int max){
        this.maxSize=max;
        stackArray=new char[maxSize];
    }
    public void push(char j){
        stackArray[++top]=j;
    }
    public char pop(){
        return stackArray[top--];
    }
    public char peel(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top==-1);
    }

}