//Program to find n th root of a number 
// Eg. Input : number = 1000 , n = 3  ===> Output : 10
// Approach for this program is using binary search method to check mid's nth power matches with number if matched approximately then it will be the output i.e. nth root of given number.

package Basics_Practice.Math_Functions_Programs;

import java.util.Scanner;


public class NthRoot {
    private static double number;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Enter a number : ");
        number = sc.nextDouble();
        System.out.print("\n Enter n (nth root of number) : ");
        n = sc.nextInt();
        sc.close();
        System.out.printf("\nThe nth root of %.3f = %.5f",number, nthRoot(number, n));
    }
    
    public static double nthRoot(double number, int n) {
        double root = 0, min = 0, max = number, mid, accuracy= 0.0001;
        while(max > min)
        {
            mid = (min + max)/2;
            double power = 1;
            for(int i=1; i<=n; i++)
            {
                power = power * mid;
            }
            //mid ^ n = power
            double difference = (power - number) > 0 ? (power-number) : (number-power);

            if(difference > accuracy)
            {
                if(power > number)
                    max = mid;
                else
                    min = mid;
            }
            else
            {
                root = mid;
                break;
            }
        }
        return root;
    }
}
