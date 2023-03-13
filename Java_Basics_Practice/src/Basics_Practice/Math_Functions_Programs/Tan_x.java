// Computing tan(x) by using sin(x)  and cos(x) results 

package Basics_Practice.Math_Functions_Programs;

import java.util.Scanner;

public class Tan_x {
    public static void main(String[] args) {
        double angle = 0, tan_x = 0;
        int sign = 1;
        char ch = 'y';
        Scanner sc = new Scanner(System.in);
        while (ch == 'y') {
            System.out.print("\n Enter an angle ( in degree's ) : ");
            angle = sc.nextDouble();
            double temp = angle;
            if (angle < 0) {
                sign = -sign;
                angle = -angle;
            }
            int angle1 = (int) angle;
            double diff = angle - angle1;
            angle1 = angle1 % 360;
            // Find quadrant and make angle in range 0 to 90
            int q = angle1 / 90;
            switch(q)
            {
                case 0 : 
                    //First Quadrant tan is positive
                    break;
                case 1 :
                    // Second quadrant tan is negative
                    sign = - sign;
                    angle1 = 180 - angle1;
                    break;
                case 2 :
                    // Third quadrant tan is positive
                    angle1 = angle1 - 180;
                    break;
                case 3 :
                    // Fourth quadrant tan is negative
                    sign = -sign;
                    angle1 = 360 - angle1;
                    break;
            }
            angle = (double) angle1 + diff;
            // convert into radians
            double pi = 22.0 / 7.0;
            angle = angle * pi / 180.0;
            double sin = Sine_X.computeSin_x(angle);
            double cos = Cos_x.computeCosx(angle);
            angle = temp;
            if (cos >= 0.0001) {
                tan_x = sin / cos;
                tan_x = tan_x * sign;
                System.out.printf("\n tan(%.2f) = %.3f", angle, tan_x);
            } 
            else
                System.out.printf("\n tan(%.2f) = Undefined ", angle);

            System.out.print("\n\n Do you wants to continue? (y/n) : ");
            sc.nextLine();
            ch = sc.nextLine().charAt(0);
        }
        sc.close();
    }
}
