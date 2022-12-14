package gui;

import dados.Reserve;
import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotFoundedException;
import excecao.TeacherNotFoundException;
import fachada.Sae;
import negocio.TeacherRegistration;

import java.util.Scanner;
public class app {

    // presets
    static String tableFormatReserve = "%-8s %-15s %-10s %-8s %-10s %-8s%n";
    static String tableFormatTeacher = "%-10s %-15s %-12s %-8s %n";
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
        int index, op, indexFound, num;
        boolean found;
        String newValue, name, goal, soliHour, devolHour, id, key, siape, age, acessLvl, room;
        Reserve re = new Reserve();
        TeacherRegistration tea = new TeacherRegistration();
        Teacher te;
        Sae sae = new Sae();
        Teacher teachers[];
        Reserve res[]; // for list reserves

        // register previous done
        Reserve reEliseu = new Reserve(
                "Eliseu Brito",
                "237",
                "Aula Prog",
                "13:00",
                "15:00",
                "462");
        sae.registerReservation(reEliseu);

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
                        System.out.print("Digite o Nome do professor: ");
                        name = input.next();
                        System.out.print("Digite o Siap: ");
                        Siap = input.next();
                        System.out.print("Digite o Nivel de Acesso: ");
                        NivelAcess = input.nextInt();
                        te = new Teacher(name,Siap,NivelAcess);
                        tea.insert(te);
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
                        id = input.nextLine();
//                        tea = new Teacher(name);
                        re = new Reserve(name, key, goal, soliHour, devolHour, id);
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
                        siape = input.nextLine();
                        // REMOVER PROFESSOR
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
                       System.out.println("Digite o Siap: ");
                       Siap = input.next();
                       System.out.println("Alterar nome: ");
                       name = input.next();
                       System.out.println("Alterar Siap: ");
                       Siap = input.next();
                       System.out.println("Alterar Nivel de Acesso: ");
                       NivelAcess = input.nextInt();
                      tea.change(name,Siap,NivelAcess);

                   }catch( TeacherNotFoundException| EmptyVectorException msg){
                    System.out.println(msg.getMessage());

                   }
                    break;
                case 8:
                    // change key
                    break;
                case 9:
                    // change reservation
                    break;
                case 10:
                    try{
                        System.out.println("=================================");
                        System.out.println("Siap: ");
                        Siap = input.next();
                        te = tea.consult(Siap);
                        System.out.println("Nome do professor: "+te.getName());
                        System.out.println("Siap: "+te.getSiap());
                        System.out.println("Nivel de acesso"+te.getNivelAcess());


                    } catch (TeacherNotFoundException |EmptyVectorException msg) {
                        System.out.println(msg.getMessage());
                    try {
                        System.out.printf("---------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                          "                CONSULTAR PROFESSOR                %n"+Color.RESET);
                        System.out.printf("---------------------------------------------------%n");
                        System.out.print(enterSIAPE);
                        siape = input.next();
                        re = sae.consultReserve(siape);
                        // metodo de consulta
                        System.out.printf("---------------------------------------------------%n");
                        System.out.printf(tableFormatTeacher, "SIAPE", "PROFESSOR", "NVL. ACESSO", "IDADE");
                        System.out.printf("---------------------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatTeacher,
                                re.getId(),  re.getTeacher(), re.getActivity(), re.getKey() /*metodos get*/);
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
                        teachers = tea.list();
                        for(int i =0;i<teachers.length; i=i=1+1) {
                            System.out.println("Nome do professor: " + teachers[i].getName());
                            System.out.println("Siap: " + teachers[i].getName());
                            System.out.println("Nivel de Acesso: "+teachers[i].getNivelAcess());
                        }
                    try {
                        res = sae.listReserves();
                        System.out.printf("---------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD+
                                "                LISTAR PROFESSORES                %n"+Color.RESET);
                        System.out.printf("---------------------------------------------%n");
                        System.out.printf(tableFormatTeacher, "SIAPE", "PROFESSOR", "NVL. ACESSO", "IDADE");
                        System.out.printf("---------------------------------------------%n");
                        for (int i = 0; i < res.length; i++) {
                            System.out.print(Color.CYAN);
                            System.out.printf(tableFormatTeacher,
                                    res[i].getId(),  res[i].getTeacher(), res[i].getActivity(), res[i].getKey()
                                    /*metodos get*/);
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
                                    res[i].getId(),  res[i].getTeacher(), res[i].getActivity(), res[i].getKey(),
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