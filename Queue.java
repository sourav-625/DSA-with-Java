package DSA;

public class Queue<T> {
    int front, rear, size;
    T[]ar;
    @SuppressWarnings("unchecked")
    Queue(int size){
        front=rear=0;
        this.size=size;
        ar=(T[])new Object[size];
    }
    //Adds an element to the queue
    void enqueue(T element){
        if(rear==size) System.out.println("Queue is full");
        else{
            ar[rear]=element;
            rear++;
        }
    }
    //removes the front element from the queue
    void dequeue(){
        if(front==rear) System.out.println("Queue is empty");
        else{
            T ans=ar[front];
            front++;
            System.out.println(ans+" has been removed from the queue");
        }
    }
    //Displays the queue
    void display(){
        for(int i=front;i<rear;i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
    //Returns the element at a position
    T elementAt(int position){
        T element=ar[front];
        for(int i=front;i<position;i++){
            element=ar[front];
        }
        return element;
    }

    public static void main(String[] args) {
        Queue<Integer> q=new Queue<>(5);
        q.display();
    }
}
