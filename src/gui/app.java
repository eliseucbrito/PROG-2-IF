package gui;

import dados.Reserve;
import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotFoundedException;
import excecao.TeacherNotFoundException;
import fachada.Sae;
import fachada.SaeTeacher;
import negocio.TeacherRegistration;

import java.util.Scanner;
public class app {

    // presets
    static String tableFormatReserve = "%-8s %-15s %-10s %-8s %-10s %-8s%n";
    static String tableFormatTeacher = "%-10s %-15s %-12s %n";
    static String tableFormatKey = "%-8s %-15s %n";

    static String enterID= Color.GREEN_BOLD+"Digite o ID: "+Color.RESET;
    static String enterSIAPE= Color.GREEN_BOLD+"Digite o SIAPE: "+Color.RESET;
    static String enterKey= Color.GREEN_BOLD+"Digite o número da chave: "+Color.RESET;

    // color + background
    static String successOp = Color.GREEN_BACKGROUND+"Operação realizada com sucesso"+Color.RESET;
    static String failedOp = Color.RED_BACKGROUND+"ERROR: " +Color.RESET;
    static String invalidOp = Color.RED_BACKGROUND+"Invalid option!"+Color.RESET;

    // max teachers, keys and reserves.
    private static final int MAX = 100;

    public static void main(String[] args) throws EmptyVectorException, ReserveNotFoundedException, FullVectorException {
        Scanner input = new Scanner(System.in);
        int index, op, indexFound, num, NivelAcess;
        boolean found;
        String newValue, name, goal, soliHour, devolHour, id, key, Siap, age, acessLvl, room;
        Reserve re = new Reserve();
        TeacherRegistration tea = new TeacherRegistration();
        Teacher te;
        Sae sae = new Sae();
        Teacher teachers[];
        Reserve res[]; // for list reserves
        SaeTeacher saeTeacher = new SaeTeacher();

        do {
            System.out.print(Color.GREEN_BOLD);
            System.out.println("================================");
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
            System.out.print(Color.BLUE_BOLD+"Enter your option: "+Color.RESET);
            op = input.nextInt();
            input.nextLine();

            switch (op) {
                case 0:
                    System.out.println(Color.WHITE_BOLD+"Saindo...");
                    break;
                case 1:
                    try {
                        System.out.print("Nome do professor: ");
                        name = input.nextLine();
                        System.out.print("Siap: ");
                        Siap = input.next();
                        System.out.print("Nivel de Acesso: ");
                        NivelAcess = input.nextInt();
                        te = new Teacher(name,Siap,NivelAcess);
                        saeTeacher.insertTeacher(te);
                    } catch (FullVectorException msg) {
                        System.out.println(msg.getMessage());
                    }
                   break;
                case 2:
                    // register
                    System.out.print("Número: ");
                    num = input.nextInt();
                    System.out.print("Sala de acesso: ");
                    room = input.nextLine();
                    System.out.println(Color.WHITE_BOLD+successOp);
                    break;
                case 3:
                    try {
                        System.out.println("--------------------");
                        System.out.print("SIAPE do professor: ");
                        Siap = input.nextLine();
                        System.out.print("Numero da chave: ");
                        key = input.nextLine();
                        System.out.print("Atividade: ");
                        goal = input.nextLine();
                        System.out.print("Hora de solicitação: ");
                        soliHour = input.nextLine();
                        System.out.print("Hora de devolução: ");
                        devolHour = input.nextLine();
                        System.out.print("ID: ");
                        id = input.nextLine();
                        te = saeTeacher.consultTeacher(Siap);
                        re = new Reserve(te, key, goal, soliHour, devolHour, id);
                        sae.registerReservation(re);
                        System.out.println(Color.WHITE_BOLD+successOp);
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 4:
                    try {
                        System.out.printf("---------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                          "        REMOVER PROFESSOR        %n"+Color.RESET);
                        System.out.printf("---------------------------------%n");
                        System.out.print(enterSIAPE);
                        Siap = input.nextLine();
                        saeTeacher.removeTeacher(Siap);
                        System.out.println(Color.WHITE_BOLD+successOp);
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 5:
                    try {
                        System.out.printf("---------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                          "           REMOVER CHAVE          %n"+Color.RESET);
                        System.out.printf("---------------------------------%n");
                        System.out.print(enterKey);
                        key = input.nextLine();
                        // REMOVER CHAVE

                        System.out.println(Color.WHITE_BOLD+successOp);
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 6:
                    try {
                        System.out.printf("--------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+"         REMOVER RESERVA        %n"+Color.RESET);
                        System.out.printf("--------------------------------%n");
                        System.out.print(enterID);
                        id = input.nextLine();
                        sae.removeReserve(id);
                        System.out.println(Color.WHITE_BOLD+successOp);
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 7:
                   try{
                       System.out.printf("----------------------------------------------------------------%n");
                       System.out.printf(Color.GREEN_BOLD+
                               "                        ALTERAR PROFESSOR                        %n"+Color.RESET);
                       System.out.printf("----------------------------------------------------------------%n");
                       System.out.print("Digite o SIAPE que deseja alterar: ");
                       Siap = input.nextLine();
                       System.out.println("Alterar nome: ");
                       name = input.nextLine();
                       System.out.println("Alterar Siap: ");
                       Siap = input.nextLine();
                       System.out.println("Alterar Nivel de Acesso: ");
                       NivelAcess = input.nextInt();
                       saeTeacher.changeTeacher(name,Siap,NivelAcess);

                   } catch( TeacherNotFoundException| EmptyVectorException msg){
                    System.out.println(msg.getMessage());
                   }
                    break;
                case 8:
                    // change key
                    break;
                case 9:
                    try {
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                "                        ALTERAR RESERVA                        %n"+Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.print("Digite o ID da reserva que deseja consultar: ");
                        id = input.next();
                        re = sae.consultReserve(id);
                        System.out.printf(Color.GREEN_BOLD+
                                "                        RESERVA ATUAL                        %n"+Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(tableFormatReserve, "ID", "PROFESSOR", "ATIVIDADE", "CHAVE", "H. SOLIC", "H. DEVOL");
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatReserve,
                                re.getId(),  re.getTeacher(), re.getActivity(), re.getKey(),
                                re.getSolicitation_hour(), re.getDevolution_hour()+Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");

                        System.out.println("=====================");
                        System.out.println("1 - Professor ");
                        System.out.println("2 - Chave ");
                        System.out.println("3 - Atividade ");
                        System.out.println("4 - Hora de Solicitação ");
                        System.out.println("5 - Hora de Devolução ");
                        System.out.println("=====================");
                        System.out.print("Escolha uma opção para alterar: ");
                        op = input.nextInt();
                        input.nextLine(); // BUG FILHA DA PUTA

                        switch (op) {
                            case 1: // Professor
                                System.out.println("Digite o SIAPE do novo Professor: ");
                                Siap = input.nextLine();
                                System.out.println(saeTeacher.consultTeacher(Siap).getName());
                                sae.changeReserve(id, op, Siap);
                                System.out.println(successOp);
                                break;
                            case 2: // key
                                break;
                            case 3: // Atividade
                                System.out.println("Digite a nova atividade: ");
                                goal = input.nextLine();
                                sae.changeReserve(id, op, goal);
                                System.out.println(successOp);
                                break;
                            case 4: // H. SOli
                                System.out.println("Digite a nova Hora de Solicitação: ");
                                soliHour = input.nextLine();
                                sae.changeReserve(id, op, soliHour);
                                System.out.println(successOp);
                                break;
                            case 5: // H. Devo
                                System.out.println("Digite a nova Hora de Devolução: ");
                                devolHour = input.nextLine();
                                sae.changeReserve(id, op, devolHour);
                                System.out.println(successOp);
                                break;
                            default:
                                System.out.println(invalidOp);
                        }

                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 10:
                    try {
                        System.out.printf("---------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                          "                CONSULTAR PROFESSOR                %n"+Color.RESET);
                        System.out.printf("---------------------------------------------------%n");
                        System.out.print(enterSIAPE);
                        Siap = input.next();
                        te = tea.consult(Siap);
                        System.out.printf("---------------------------------------------------%n");
                        System.out.printf(tableFormatTeacher, "SIAPE", "PROFESSOR", "NVL. ACESSO");
                        System.out.printf("---------------------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatTeacher,
                                te.getSiap(),  te.getName(), te.getNivelAcess() /*metodos get*/);
                        System.out.printf("---------------------------------------------------%n");
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 11:
                    try {
                        System.out.printf("-----------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                          "    CONSULTAR CHAVE    %n"+Color.RESET);
                        System.out.printf("-----------------------%n");
                        System.out.print(enterKey);
                        key = input.next();
                        re = sae.consultReserve(key);
                        // metodo de consulta
                        System.out.printf("-----------------------%n");
                        System.out.printf(tableFormatKey, "NUMERO", "SALA DE ACESSO");
                        System.out.printf("-----------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatKey,
                                re.getId(),  re.getActivity() /*metodos get*/+Color.RESET);
                        System.out.printf("-----------------------%n");
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 12:
                    // consult reservation
                    try {
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                "                        CONSULTAR RESERVA                        %n"+Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.print(enterID);
                        id = input.next();
                        re = sae.consultReserve(id);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(tableFormatReserve, "ID", "PROFESSOR", "ATIVIDADE", "CHAVE", "H. SOLIC", "H. DEVOL");
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatReserve,
                                re.getId(),  re.getTeacher(), re.getActivity(), re.getKey(),
                                re.getSolicitation_hour(), re.getDevolution_hour()+Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 13:
                    try {
                        teachers = saeTeacher.listTeacher();
                        System.out.printf("---------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                "                LISTAR PROFESSORES                %n"+Color.RESET);
                        System.out.printf("---------------------------------------------%n");
                        System.out.printf(tableFormatTeacher, "SIAPE", "PROFESSOR", "NVL. ACESSO");
                        System.out.printf("---------------------------------------------%n");
                        for (int i = 0; i < teachers.length; i++) {
                            System.out.print(Color.CYAN);
                            System.out.printf(tableFormatTeacher,
                                    teachers[i].getSiap(),  teachers[i].getName(), teachers[i].getNivelAcess());
                        }
                        System.out.printf("---------------------------------------------%n");
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 14:
                    try {
                        res = sae.listReserves();
                        System.out.printf("-----------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                          "     LISTAR CHAVES     %n"+Color.RESET);
                        System.out.printf("-----------------------%n");
                        System.out.printf(tableFormatKey, "NUMERO", "SALA DE ACESSO");
                        System.out.printf("-----------------------%n");
                        for (int i = 0; i < res.length; i++) {
                            System.out.print(Color.CYAN);
                            System.out.printf(tableFormatKey,
                                    res[i].getId(),  res[i].getActivity() /*metodos get*/+Color.RESET);
                        }
                        System.out.printf("-----------------------%n");
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                case 15:
                    try {
                        res = sae.listReserves();
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                "                         LISTAR RESERVAS                        %n"+Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(tableFormatReserve, "ID", "PROFESSOR", "ATIVIDADE", "CHAVE", "H. SOLIC", "H. DEVOL");
                        System.out.printf("----------------------------------------------------------------%n");
                        for (int i = 0; i < res.length; i++) {
                            System.out.print(Color.CYAN);
                            System.out.printf(tableFormatReserve,
                                    res[i].getId(),  res[i].getTeacher().getName(), res[i].getActivity(), res[i].getKey(),
                                    res[i].getSolicitation_hour(), res[i].getDevolution_hour()+Color.RESET);
                        }
                        System.out.printf("----------------------------------------------------------------%n");
                    } catch (Exception e) {
                        System.out.println(Color.WHITE_BOLD+failedOp+ e.getMessage()+Color.RESET);
                    }
                    break;
                default:
                    System.out.println(Color.WHITE_BOLD+invalidOp);
            }
        } while (op != 0);
    }

}