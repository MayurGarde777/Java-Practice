//Program to create basic console based Calculator 

package Basics_Practice;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int num1, num2, op=0;
        char ch = 'y';
        Scanner sc = new Scanner(System.in);
        while(ch == 'y') {
            System.out.print("\n Menu \n 1. Addition \n 2. Subtraction \n 3. Multiplication \n 4. Division \n\n Enter operation you wants to perform : ");
            try {
                op = sc.nextInt();
                if(op >4 || op <1)
                    throw new Exception();
            }
            catch(Exception e) {
                System.out.println("Enter valid option from given menu only. \n");
                System.out.print("Do you wants to continue? (press 'n' if no) : ");
                ch = sc.next().charAt(0);
                System.out.println("\n ");
                continue;
            }

            System.out.print("Enter First Integer : ");
            num1 = sc.nextInt();
            System.out.print("Enter Second Integer : ");
            num2 = sc.nextInt();

            switch(op)
            {
                case 1 : 
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
                case 2 : 
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
                case 3 : 
                System.out.println(num1 + " x " + num2 + " = " + (num1 * num2) );
                break;
                case 4 :
                if(num2 != 0)
                    System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
                else 
                    System.out.println("\n Division by zero not possible");
            }

            System.out.print("Do you wants to continue? (press 'y' if you wants to do further) : ");
            ch = sc.next().charAt(0);
        }
        sc.close();
    }
}
