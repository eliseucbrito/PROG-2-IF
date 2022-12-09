package gui;

import dados.Reserve;
import dados.Teacher;
import excecao.FullVectorException;
import java.util.Date;
import java.util.Date;
import java.util.Scanner;

public class app {

    private static final int MAX = 100;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int index, op, indexFound;
        boolean found;
        String newValue, name, goal, soli_hour, devol_hour, id;
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
            System.out.println("13 - List (Teacher)");
            System.out.println("14 - List (Key)");
            System.out.println("15 - List (Reservation)");
            System.out.println("Enter your option: ");
            op = input.nextInt();

            switch (op) {
                case 0:
                    System.out.println("See you later");
                    break;
                case 1:
                    try { // Quem tá responsavel pelo TEACHER, muda isso aqui, fiz só pra testar
                        System.out.println("Teacher name: ");
                        name = input.nextLine();
                        tea = new Teacher(name);
                        System.out.println("Operation successful");
                    } catch (Exception e) {
                        System.out.println("Full vector ERROR:" + e.getMessage());
                    }
                case 2:
                    // register key
                    break;
                case 3:
                    try {
                        System.out.println("Teacher name: ");
                        name = input.nextLine();
                        System.out.println("Goal: ");
                        goal = input.nextLine();
                        System.out.println("Solicitation hour: ");
                        soli_hour = input.nextLine();
                        System.out.println("Devolution hour: ");
                        devol_hour = input.nextLine();
                        id = String.valueOf(new Date().getTime()); // hour in miliseconds
                        tea = new Teacher(name);
                        re = new Reserve(tea, goal, soli_hour, devol_hour, id);
                        // fazer consulta nos professores, para achar qual o novo com base no nome ou SIAPE

                    } catch (Exception e) {
                        System.out.println("ERROR" + e.getMessage());
                    }
                    break;
                case 4:
                    // remove teacher
                    break;
                case 5:
                    // remove key
                    break;
                case 6:
                    // remove reservation
                    break;
                case 7:
                    // change teacher
                    break;
                case 8:
                    // change key
                    break;
                case 9:
                    // change reservation
                    break;
                case 10:
                    // consult teacher
                    break;
                case 11:
                    // consult key
                    break;
                case 12:
                    // consult reservation
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (op != 0);
    }

}
