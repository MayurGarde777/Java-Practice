// Program to find square root of a number taken from user without using any library function
// Eg. Input : number = 196  ==> Output : sqrt = 14 , Input : number = 55 ==> Output : sqrt = 7.4162

package Basics_Practice.Math_Functions_Programs;

import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {
        double number, sqrt;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        number = sc.nextDouble();
        sc.close();
        if(number < 0)
        {
            System.out.println("Square Root of Negative number not possible.");
            return;
        }
        sqrt = squareRoot(number);
        System.out.printf("The square root of %.2f = %.4f",number,sqrt);
    }

    public static double squareRoot(double number) {

        //Finding square root using binary search by everytime checking square of mid with number.
        double sqrt = 0, min, max, mid, accuracy = 0.00001;
        min = 0;
        max = number;
        while(max > min)
        {
            mid = (max + min) / 2;
            double difference = (mid*mid - number) > 0 ? (mid*mid - number) : (number - mid*mid);

            if(difference > accuracy)
            {
                if(number > mid*mid)
                    min = mid;
                else
                    max = mid;
            }
            else
            {
                sqrt = mid;
                break;
            }
        }
        return sqrt;
    }
}
