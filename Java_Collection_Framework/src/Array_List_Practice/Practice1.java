package Array_List_Practice;

import java.util.*;

public class Practice1 {
    public static void main(String args[]) {
        ArrayList <Integer> numbers = new ArrayList<Integer>();
        System.out.print("\nEnter total number of integers you wants to add in Array-List : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter " + size + " integers : ");
        for(int i=1; i<=size; i++) 
        {
            numbers.add(sc.nextInt());
        }
        sc.close();
        System.out.println("Displaying ArrayList Elements : ");
        for(Integer num: numbers)
        {
            System.out.println(num);
        }
        //sorting arrayList elements
        Collections.sort(numbers);
        System.out.println("ArrayList elements after sorting : ");
        for(Integer num: numbers)
        {
            System.out.println(num);
        }
    }
}
