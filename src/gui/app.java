package gui;

import dados.Reserve;
import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotFoundedException;
import fachada.Sae;

import java.util.Date;
import java.util.Date;
import java.util.Scanner;

public class app {

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_GREEN = "\u001B[32m";

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
            System.out.println(ANSI_GREEN+"0 - Exit"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"1 - Register (Teacher)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"2 - Register (Key)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"3 - Register (Reservation)"+ANSI_RESET);
            System.out.println("==============================");
            System.out.println(ANSI_GREEN+"4 - Remove (Teacher)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"5 - Remove (Key)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"6 - Remove (Reservation)"+ANSI_RESET);
            System.out.println("==============================");
            System.out.println(ANSI_GREEN+"7 - Change (Teacher)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"8 - Change (Key)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"9 - Change (Reservation)"+ANSI_RESET);
            System.out.println("==============================");
            System.out.println(ANSI_GREEN+"10 - Consult (Teacher)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"11 - Consult (Key)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"12 - Consult (Reservation)"+ANSI_RESET);
            System.out.println("==============================");
            System.out.println(ANSI_GREEN+"13 - List (Teacher)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"14 - List (Key)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"15 - List (Reservation)"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"Enter your option: "+ANSI_RESET);
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
                        System.out.println("Operação realizada com sucesso");
                    } catch (Exception e) {
                        System.out.println("ERROR Vetor cheio :" + e.getMessage());
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
                        System.out.println("NOME: "+name+"CHAVE: "+key+"ATIVIDADE: "+goal+" "+soliHour+devolHour+id);
                        re = new Reserve(name, key, goal, soliHour, devolHour, id);
                        System.out.println("RESERVA"+re);
                        sae.registerReservation(re);
                    } catch (Exception e) {
                        System.out.println("ERROR: " + e.getMessage());
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
                        System.out.println("Operação realizada com sucesso");
                    } catch (Exception e) {
                        System.out.println("ERROR: "+e.getMessage());
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
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    try {
                        System.out.println("===== LISTAR RESERVAS =====");
                        res = sae.listReserves();
                        for (int i = 0; i < res.length; i++) {
                            System.out.println("+++++++++++++++++++++++++++++++");
                            System.out.println("ID: "+res[i].getId());
                            System.out.println("Professor: "+res[i].getTeacher());
                            System.out.println("Atividade: "+res[i].getActivity());
                            System.out.println("Chave: "+res[i].getKey());
                            System.out.println("Hora de solicitação: "+res[i].getSolicitation_hour());
                            System.out.println("Hora de devolução: "+res[i].getDevolution_hour());
                            System.out.println("+++++++++++++++++++++++++++++++");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR: "+e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (op != 0);
    }

}
