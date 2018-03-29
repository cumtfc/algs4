package ACM;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ArrayCombine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int count = 0;
            count += scanner.nextInt();
            count += scanner.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while (count > 0) {
                int nextInt = scanner.nextInt();
                if (!pq.contains(nextInt)) {
                    pq.add(nextInt);
                }
                count--;
            }
            while (!pq.isEmpty()) {
                if (pq.size() == 1) {
                    System.out.print(pq.poll());
                }else {
                    System.out.print(pq.poll()+" ");
                }
            }
            System.out.println();
        }
    }

}