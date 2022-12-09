package gui;

import dados.Reserve;
import dados.Teacher;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int index, op, indexFound;
        boolean found;
        String newValue;
        Reserve re = new Reserve();
        Teacher tea = new Teacher();

        do {
            System.out.println("0 - Exit");
            System.out.println("1 - Register (Teacher)");
            System.out.println("2 - Register (Key)");
            System.out.println("3 - Register (Reservation)");
            System.out.println("==============================");
            System.out.println("4 - Remove (Teacher)");
            System.out.println("5 - Remove (Key)");
            System.out.println("6 - Remove (Reservation)");
            System.out.println("==============================");
            System.out.println("7 - Change (Teacher)");
            System.out.println("8 - Change (Key)");
            System.out.println("9 - Change (Reservation)");
            System.out.println("==============================");
            System.out.println("10 - Consult (Teacher)");
            System.out.println("11 - Consult (Key)");
            System.out.println("12 - Consult (Reservation)");
            System.out.println("==============================");
            System.out.println("10 - List (Teacher)");
            System.out.println("11 - List (Key)");
            System.out.println("12 - List (Reservation)");
            System.out.println("Enter your option: ");
            op = input.nextInt();

            switch (op) {

            }
        } while (op != 0);
    }

}
