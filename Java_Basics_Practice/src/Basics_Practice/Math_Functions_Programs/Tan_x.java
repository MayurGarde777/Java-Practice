// Computing tan(x) by using sin(x)  and cos(x) results 

package Basics_Practice.Math_Functions_Programs;

import java.util.Scanner;

public class Tan_x {
    public static void main(String[] args) {
        double angle = 0, tan_x = 0;
        int sign = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an angle ( in degree's ) : ");
        angle = sc.nextDouble();
        sc.close();
        double temp = angle;
        if(angle < 0)
        {
            sign = -sign;
            angle = -angle;
        }
        int angle1 = (int) angle;
        double diff = angle - angle1;
        angle1 = angle1 % 360;
        angle = (double) angle1 + diff;
        // convert into radians
        double pi = 22.0/7.0;
        angle = angle * pi/180.0;
        double sin = Sine_X.computeSin_x(angle);
        double cos = Cos_x.computeCosx(angle);
        angle = temp;
        if(cos < 0.0001)
            System.out.printf("\n tan(%.2f) = Undefined ", angle);
        else
        {
            tan_x = sin/cos;
            tan_x = tan_x * sign;
            System.out.printf("\n tan(%.2f) = %.3f", angle, tan_x);
        }
    }
}
