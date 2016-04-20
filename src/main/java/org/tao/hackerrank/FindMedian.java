package org.tao.hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMedian {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Comparator des = new Comparator<Float>(){
            @Override
            public int compare(Float o1, Float o2) {
                return (int)(o2.floatValue() - o1.floatValue());
            }
        };
        PriorityQueue<Float> smallQueue = new PriorityQueue(1,des);
        PriorityQueue<Float> largeQueue = new PriorityQueue();
        Scanner in = new Scanner(System.in);
        int count =  in.nextInt();
        while (count-->0) {
            float nmb = in.nextInt();
            if (smallQueue.size()==0 || nmb<smallQueue.peek())
                smallQueue.add(nmb);
            else 
                largeQueue.add(nmb);
            //System.out.println("Adding ... "+nmb);
            balanceQueue(smallQueue, largeQueue);
            //System.out.println(smallQueue.peek()+" "+largeQueue.peek());
            if (smallQueue.size()==largeQueue.size())
                System.out.println((smallQueue.peek()+largeQueue.peek())/2);
            else {
                PriorityQueue lg = smallQueue.size()>largeQueue.size()?smallQueue:largeQueue;
                System.out.println(lg.peek());
            }
        }
    }
        
    public static void balanceQueue(PriorityQueue smallQueue, PriorityQueue largeQueue) {
        //System.out.println(smallQueue.size()+" ? "+largeQueue.size());
        if (Math.abs(smallQueue.size()-largeQueue.size())>=2) {
            PriorityQueue from = smallQueue.size()>largeQueue.size()?smallQueue:largeQueue;
            PriorityQueue to = from==largeQueue?smallQueue:largeQueue;
            while (Math.abs(from.size()-to.size())>=2)
                to.add(from.poll());
            //System.out.println(smallQueue.size()+" <=> "+largeQueue.size());
        }
    }
}
