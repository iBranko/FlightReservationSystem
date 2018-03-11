import java.util.Scanner;

public class SystemRunner {

    public static void main(String[] args) {

        ControleDeVoos programa = new ControleDeVoos();

        Scanner input = new Scanner(System.in);

        String opt;

        do{
            System.out.println("FLIGHT CONTROLLER 1.0\n\n" +
                               "[1]Cadastrar novo voo\n" +
                               "[2]Cancelar voo\n" +
                               "[3]Nova reserva\n" +
                               "[4]Listar reservas\n" +
                               "[5]Listar voos\n" +
                               "[0]SAIR");

            opt = input.next();

            switch(opt) {
                case "1": {
                    System.out.print("Numero do voo: ");
                    int numeroVoo = input.nextInt();
                    input.nextLine();
                    System.out.print("Origem: ");
                    String origem = input.nextLine();
                    System.out.print("Destino: ");
                    String destino = input.nextLine();
                    System.out.print("Numero de assentos: ");
                    int numeroDeAssentos = input.nextInt();
                    input.nextLine();

                    programa.cadastrarVoo(numeroVoo, origem, destino, numeroDeAssentos);

                    break;
                }
                case "2": {
                    System.out.print("Numero do voo a ser cancelado: ");
                    int numeroVooCancelar = input.nextInt();
                    input.nextLine();
                    programa.cancelarVoo(numeroVooCancelar);
                    break;
                }
                case "3": {
                    System.out.print("Numero do voo onde a reserva sera feita: ");
                    int numeroVoo = input.nextInt();
                    input.nextLine();
                    if (programa.localizarVoo(numeroVoo)) {
                        System.out.print("Nome do passageiro: ");
                        String nome = input.nextLine();
                        System.out.print("CPF do passageiro: ");
                        String cpf = input.nextLine();
                        if (ValidadorCpf.validaCpf(cpf)) {
                            programa.cadastrarReserva(numeroVoo, nome, cpf);
                        }
                    } else {
                        System.out.println("Voo nao localizado. Tente novamente\n");
                    }
                    break;
                }
                case "4": {
                    System.out.print("\nInforme o numero do voo: ");
                    int numeroVoo = input.nextInt();
                    input.nextLine();

                    programa.listarReservas(numeroVoo);

                    break;
                }
                case "5": {
                    programa.listarVoos();
                    break;
                }
                case "0":
                    break;
                default:
                    System.out.println("Opcao invalida\n");
                    break;
            }
        }while (!"0".equals(opt));

    }
}
