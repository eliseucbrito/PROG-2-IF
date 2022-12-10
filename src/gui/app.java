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

    private static final int MAX = 100;
    public static void main(String[] args) throws EmptyVectorException, ReserveNotFoundedException {
        Scanner input = new Scanner(System.in);
        int index, op, indexFound;
        boolean found;
        String newValue, name, goal, soliHour, devolHour, id, key;
        Reserve re = new Reserve();
        Teacher tea = new Teacher();
        Sae sae = new Sae();

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
                        System.out.println("Nome do professor: ");
                        name = input.next();
                        System.out.println("Numero da chave: ");
                        key = input.next();
                        System.out.println("Atividade: ");
                        goal = input.next();
                        System.out.println("Hora de solicitação: ");
                        soliHour = input.next();
                        System.out.println("Hora de devolução: ");
                        devolHour = input.next();
                        System.out.println("ID: ");
                        id = input.next(); // hour in miliseconds
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
                    System.out.println("Digite o ID da reserva que ");
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
                        System.out.println("Digite o ID da reserve que deseja consultar: ");
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
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (op != 0);
    }

}
