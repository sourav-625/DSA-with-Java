package DSA;

import java.util.EmptyStackException;

public class Stack<T> {
    int top=-1;
    T[]ar;
    int size;
    @SuppressWarnings("unchecked")
    Stack(int size){
        this.size=size;
        ar=(T[])new Object[size];
    }
    //Pushes an element into the stack
    void push(T element){
        if(top+1==size) System.out.println("Stack overflow!");
        else{
            top++;
            ar[top]=element;
        }
    }
    //pops an element out from the stack
    T pop() throws EmptyStackException{
        if(top==-1) throw new EmptyStackException();
        else{
            top--;
            return ar[top];
        }
    }
    //Returns the top element of the stack
    T top() throws EmptyStackException{
        if(top==-1) throw new EmptyStackException();
        else{
            return ar[top];
        }
    }
    //Displays the elements of the stack
    void display(){
        if(top==-1) System.out.println("Stack is empty!");
        else{
            for(int i=top;i>-1;i--){
                System.out.println(ar[i]);
            }
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>(5);
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.display();
        s.pop();
        s.display();
    }
}
