// cos(x) = 1 - (x^2)/2! + (x^4)/4! - (x^6)/6! + ..... where x in radians and between 0 to pi/2.

package Basics_Practice.Math_Functions_Programs;

import java.util.Scanner;

public class Cos_x {
    public static void main(String[] args) {
        double angle=0, cos_x = 0;
        char ch = 'y';
        int sign = 1;
        Scanner sc = new Scanner(System.in);
        while(ch == 'y') {
        System.out.print("Enter an angle (in degree) :  ");
        angle = sc.nextDouble();
        double temp = angle;
        if(angle < 0)
            angle = -angle;

        //Convert angle radians and make it bw 0 to 90 and find its quadrant
        int angle1 = (int) angle;
        double diff = angle -(double) angle1;
        angle1 = angle1 % 360;
        angle = (double) angle1 + diff; // Here angle is bw 0 to 360

        int quadrant = angle1 / 90;
        switch (quadrant) {
            case 0:
                //In first quadrant Cos is positive
                break;
            case 1:
                // In second quadrant Cos is negative
                sign = -sign;
                angle = 180 - angle;
                break;
            case 2:
                // In third quadrant cos is negative
                sign = -sign;
                angle = angle - 180;
                break;
            case 3:
                // In fourth quadrant cos is positive
                angle = 360 - angle;
                break;
            default:
                break;
        }
        // Now angle is between 0 to 90 and in degree's
        double pi = 22.0 / 7.0;
        angle = angle * pi / 180;
        cos_x = computeCosx(angle);
        cos_x = cos_x * sign;
        angle = temp;
        System.out.printf("\n cos(%.2f) = %.3f",angle, cos_x);
        System.out.printf("\n \n Do you wants to continue? (y/n) : ");
        sc.nextLine();
        ch = sc.nextLine().charAt(0);
    }
    sc.close();
    }

    public static double computeCosx(double angle) {
        double cos_x = 0;
        
        // cos(x) = 1 - (x^2)/2! + (x^4)/4! - (x^6)/6! + ....
        for(int i=1; i<=10; i++)
        {
            if(i % 2 == 0)
                cos_x = cos_x - Sine_X.power(angle, (2*i-2))/Sine_X.factorial(2*i - 2); 
            // power() and factorial functions are defined in Class Sin_x in Sin_x.java file
            else
                cos_x = cos_x + Sine_X.power(angle, (2*i - 2))/Sine_X.factorial(2*i - 2);
        }
        return cos_x;
    }
}
