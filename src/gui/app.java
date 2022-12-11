package gui;

import dados.Reserve;
import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotFoundedException;
import fachada.Sae;

import java.util.Scanner;
public class app {

    // max teachers, keys and reserves.
    private static final int MAX = 100;
    public static void main(String[] args) throws EmptyVectorException, ReserveNotFoundedException {
        Scanner input = new Scanner(System.in);
        int index, op, indexFound;
        boolean found;
        String newValue, name, goal, soliHour, devolHour, id, key;
        Reserve re = new Reserve();
        Teacher tea = new Teacher();
        Sae sae = new Sae();
        Reserve res[]; // for list reserves

        do {
            System.out.print(Color.GREEN_BOLD);
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
            System.out.print(Color.RESET);
            System.out.print("Enter your option: ");
            op = input.nextInt();
            input.nextLine();

            switch (op) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    try { // Quem tá responsavel pelo TEACHER, muda isso aqui, fiz só pra testar
                        System.out.println("Nome do professor: ");
                        name = input.nextLine();
                        tea = new Teacher(name);
                        System.out.println(Color.GREEN_BACKGROUND+"Operação realizada com sucesso"+Color.RESET);
                    } catch (Exception e) {
                        System.out.println(Color.RED_BACKGROUND+"ERROR Vetor cheio :" + e.getMessage()+Color.RESET);
                    }
                case 2:
                    // register key
                    break;
                case 3:
                    try {
                        System.out.println("--------------------");
                        System.out.print("Nome do professor: ");
                        name = input.nextLine();
                        System.out.print("Numero da chave: ");
                        key = input.nextLine();
                        System.out.print("Atividade: ");
                        goal = input.nextLine();
                        System.out.print("Hora de solicitação: ");
                        soliHour = input.nextLine();
                        System.out.print("Hora de devolução: ");
                        devolHour = input.nextLine();
                        System.out.print("ID: ");
                        id = input.nextLine(); // hour in miliseconds
//                        tea = new Teacher(name);
                        re = new Reserve(name, key, goal, soliHour, devolHour, id);
                        sae.registerReservation(re);

                        System.out.println(Color.WHITE_BOLD);
                        System.out.println(Color.GREEN_BACKGROUND+"Operação realizada com sucesso"+Color.RESET);
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD);
                        System.out.println(Color.RED_BACKGROUND+"ERROR: " + e.getMessage()+Color.RESET);
                    }
                    break;
                case 4:
                    // remove teacher
                    break;
                case 5:
                    // remove key
                    break;
                case 6:
                    try {
                        System.out.println("===== REMOVER RESERVA =====");
                        System.out.print("Digite o ID: ");
                        id = input.nextLine();
                        sae.removeReserve(id);
                        System.out.println(Color.WHITE_BOLD);
                        System.out.println(Color.GREEN_BACKGROUND+"Operação realizada com sucesso"+Color.RESET);
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD);
                        System.out.println(Color.RED_BACKGROUND+"ERROR: "+e.getMessage()+Color.RESET);
                    }
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
                    try {
                        System.out.println("===== CONSULTAR RESERVA =====");
                        System.out.println("Digite o ID: ");
                        id = input.next();
                        re = sae.consultReserve(id);
                        System.out.println("+++++++++++++++++++++++++++++++");
                        System.out.println("ID: "+re.getId());
                        System.out.println("Professor: "+re.getTeacher());
                        System.out.println("Atividade: "+re.getActivity());
                        System.out.println("Chave: "+re.getKey());
                        System.out.println("Hora de solicitação: "+re.getSolicitation_hour());
                        System.out.println("Hora de devolução: "+re.getDevolution_hour());
                        System.out.println("+++++++++++++++++++++++++++++++");
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD);
                        System.out.println(Color.RED_BACKGROUND+"ERROR: " + e.getMessage()+Color.RESET);
                    }
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    try {
                        res = sae.listReserves();

                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf("                         LISTAR RESERVAS                        %n");
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf("| %-4s | %-10s | %-10s | %4s | %4s | %4s |%n",
                                "ID", "PROFESSOR", "ATIVIDADE", "CHAVE", "H. SOLIC", "H. DEVOL");
                        System.out.printf("----------------------------------------------------------------%n");
                        for (int i = 0; i < res.length; i++) {
                            System.out.printf("| %-4s | %-10s | %-10s | %5s | %6s | %6s |%n",
                                    res[i].getId(),  res[i].getTeacher(), res[i].getActivity(), res[i].getKey(),
                                    res[i].getSolicitation_hour(), res[i].getDevolution_hour());
                        }
                        System.out.printf("----------------------------------------------------------------%n");
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD);
                        System.out.println(Color.RED_BACKGROUND+"ERROR: "+e.getMessage()+Color.RESET);
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (op != 0);
    }

}

// CASE 15
//try {
//        System.out.printf("--------------------------------%n");
//        System.out.printf("    LISTAR RESERVAS      %n");
//        System.out.printf("--------------------------------%n");
//        res = sae.listReserves();
//        for (int i = 0; i < res.length; i++) {
//        System.out.println("+++++++++++++++++++++++++++++++");
//        System.out.println("ID: "+res[i].getId());
//        System.out.println("Professor: "+res[i].getTeacher());
//        System.out.println("Atividade: "+res[i].getActivity());
//        System.out.println("Chave: "+res[i].getKey());
//        System.out.println("Hora de solicitação: "+res[i].getSolicitation_hour());
//        System.out.println("Hora de devolução: "+res[i].getDevolution_hour());
//        System.out.println("+++++++++++++++++++++++++++++++");
//        }
//        } catch (Exception e) {
//        System.out.println("ERROR: "+e.getMessage());
//        }
//        break;