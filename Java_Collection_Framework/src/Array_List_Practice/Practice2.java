package Array_List_Practice;

import java.util.*;

public class Practice2 {
    public static ArrayList <String> getData() {
        ArrayList <String> names = new ArrayList <String> ();
        System.out.print("\nEnter number of strings you wants to store in ArrayList : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("\nEnter " + n + " Strings : ");
        for(int i=0; i<n; i++)
            names.add(sc.next());
        sc.close();
        return names;
    }
    public static void main(String args[]) {
        ArrayList <String> name = new ArrayList<String>();
        //Adding input strings from user through getData method
        name.addAll(getData());
        //Display all Strings 
        for(String i: name)
        {
            System.out.println(i);
        }
    }
}
