//Program to calculate sin(x) of angle x using taylor's series of sin(x)

// sin(x) = x - (x^3)/3! + (x^5)/5! - (x^7)/7! + ..... where x in radians and value of x is between 0 to pi/2. Take x from user in degree's and then convert into radians.

// My approach is find the angle's value (bw 0 to pi/2) and also determine the quadrant in which x belongs to so that we can find its sign (whether positive or negative).

package Basics_Practice.Math_Functions_Programs;

import java.util.Scanner;

public class Sine_X {
    public static void main(String[] args) {
        char ch = 'y';
        double angle = 0;
        Scanner sc = new Scanner(System.in);
        while (ch == 'y') {
            System.out.print("\n Enter angle  x (in degree's) : ");
            angle = sc.nextDouble();

            // Convert angle in radians and also determine quadrant in which it belongs to
            int sign = 1;
            double temp = angle;
            // If angle is negative its sin will be same in magnitude but opposite in sign (
            // as sin(-x) = - sin(x) )
            if (angle < 0) {
                sign = -sign;
                angle = -angle;
            }

            // Since Modulus or Remainder operator can't works on double convert angle into
            // integer because we wants to make angle bw 0 to 360.
            int angle1 = (int) angle;
            double diff = angle - angle1;
            angle1 = angle1 % 360;
            angle = angle1 + diff;
            int quadrant = angle1 / 90;
            switch (quadrant) {
                case 0:
                    // First Quadrant Sin(x) is positive
                    break;
                case 1:
                    // Second Quadrant Sin(x) is positive
                    angle = 180 - angle;
                    break;
                case 2:
                    // Third Quadrant Sin(x) is negative
                    sign = -sign;
                    angle = angle - 180;
                    break;
                case 3:
                    // Forth Quadrant Sin(x) is negative
                    sign = -sign;
                    angle = 360 - angle;
                    break;
            }

            // Convert angle from degree to radians
            double pi = 22.0 / 7.0;
            angle = angle * pi / 180.0;

            double sin_x = computeSin_x(angle);
            sin_x = sign * sin_x;
            angle = temp;
            System.out.printf("\n sin(%.2f) = %.3f ", angle, sin_x);
            System.out.print("\n Do you wants to continue? (y/n) : ");
            sc.nextLine();
            ch = sc.nextLine().charAt(0);
        }
        sc.close();
    }

    public static double computeSin_x(double angle) {
        double sin_x = 0;
        // sin(x) = x - (x^3)/3! + (x^5)/5! - (x^7)/7! + .....
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0)
                sin_x = sin_x + power(angle, (2 * i - 1)) / factorial(2 * i - 1);
            else
                sin_x = sin_x - power(angle, (2 * i - 1)) / factorial(2 * i - 1);
        }
        return sin_x;
    }

    public static double power(double num, int n) {
        double power = 1;
        for (int i = 1; i <= n; i++) {
            power = power * num;
        }
        return power;
    }

    public static double factorial(int n) {
        double fact = 1;
        for (int i = 1; i <= n; i++)
            fact = fact * i;
        return fact;
    }
}
