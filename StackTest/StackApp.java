package com.study.DataStructure;

public class StackApp{
    public static void main(String[] args) {
        Stack theStack=new Stack(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(80);
        theStack.push(60);
    while (!theStack.isEmpty()){
        long value=theStack.pop();
        System.out.println(value);
    }
        System.out.println(theStack.isFull());
    }
}
class Stack{
    private int maxSize;
    private long [] stackArray;
    private int top=-1;
    private int size=0;
    public Stack(int maxSize){
        this.maxSize=maxSize;
        stackArray=new long[maxSize];
    }
    public void push(long j){
        stackArray[++top]=j;
        size++;
    }
    public long pop(){
        size--;
        return stackArray[top--];
    }
    public long peel(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top==-1);
    }
    public boolean isFull(){
        return (size==maxSize-1);
    }


}