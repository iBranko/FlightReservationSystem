import java.util.ArrayList;
import java.util.Scanner;

public class ControleDeVoos {

    private ArrayList<Voo> listaDeVoos = new ArrayList<>();

    private void cadastrarVoo(int numeroVoo, String origem, String destino, int numeroDeAssentos) {

        if (this.listaDeVoos.add(new Voo(numeroVoo, origem, destino, numeroDeAssentos))) {
            System.out.println("Voo cadastrado com sucesso\n");
        } else {
            System.out.println("Nao foi possivel cadastrar o voo. Tente novamente\n");
        }
    }

    private void cancelarVoo(int numeroVoo) {
        if(listaDeVoos.size() > 0) {
            Voo v = this.localizarVoo(numeroVoo);
            if (v != null) {
                if (listaDeVoos.remove(v)) {
                    System.out.println("Voo cancelado com sucesso\n");
                } else {
                    System.out.println("Nao foi possivel cancelar o voo. Tente novamente\n");
                }
            }
        } else {
            System.out.println("Voo nao encontrado\n");
        }
    }

    private Voo localizarVoo(int numeroVoo) {
        Voo v = null;
        for (Voo listaDeVoo : listaDeVoos) {
            if (listaDeVoo.getNumero() == numeroVoo) {
                v = listaDeVoo;
                break;
            }
        }
        return v;
    }

    private void cadastrarReserva(int numeroVoo, String nome, String cpf) {
//        TODO - Retornar representação visual dos assentos
        if (ValidadorCpf.validaCpf(cpf)) {
            Voo v = this.localizarVoo(numeroVoo);
            if (v != null) {
                if (v.adicionarReserva(nome, cpf)) {
                    System.out.println("Reserva efetuada com sucesso\n");
                } else {
                    System.out.println("Nao foi possivel efetuar a reserva. Tente novamente\n");
                }
            }
        }
    }

    private void cancelarReserva(int numeroVoo, String cpf) {
        cpf = cpf.replaceAll("[^0-9]+","");
        Voo v = this.localizarVoo(numeroVoo);
        if (v != null) {
            for (Reserva r : v.getListaDeReserva()) {
                if (cpf.equals(r.getCpf().replaceAll("[^0-9]+", ""))) {
                    if (v.getListaDeReserva().remove(r)) {
                        System.out.println("Reserva cancelada com sucesso");
                        break;
                    } else {
                        System.out.println("Nao foi possivel cancelar a reserva. Tente novamente\n");
                        break;
                    }
                }
            }
        } else {
            System.out.println("Reserva nao encontrada. Tente novamente\n");
        }
    }

    private void listarReservas(int numeroVoo) {
//        TODO - Retornar representacao visual dos assentos
        Voo v = this.localizarVoo(numeroVoo);
        if (v != null) {
            ArrayList<Reserva> listaDeReserva = v.getListaDeReserva();
            if(listaDeReserva.size() > 0){
                for (Reserva r : listaDeReserva) {
                    r.imprimeReserva();
                    return;
                }
            } else {
                System.out.println("Nao existem reservas para o voo solicitado\n");
                return;
            }
        }
        System.out.println("Voo nao encontrado. Tente novamente\n");
    }

    private void listarVoos() {
//        TODO - Retornar os voos, origem, destino e numero de assentos disponiveis
        System.out.println("Voos: ");
        for (Voo v : listaDeVoos) {
            System.out.println(v.getNumero());
        }
        System.out.println();
    }

    private void exibirAssentos(Voo v) {

    }

    public void menu() {

        Scanner input = new Scanner(System.in);

        String opt;

        do{
            System.out.println("FLIGHT CONTROLLER 1.0\n\n" +
                    "[1]Cadastrar novo voo\n" +
                    "[2]Cancelar voo\n" +
                    "[3]Nova reserva\n" +
                    "[4]Cancelar reserva\n" +
                    "[5]Listar reservas\n" +
                    "[6]Listar voos\n" +
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

                    this.cadastrarVoo(numeroVoo, origem, destino, numeroDeAssentos);

                    break;
                }
                case "2": {
                    System.out.print("Numero do voo a ser cancelado: ");
                    int numeroVooCancelar = input.nextInt();
                    input.nextLine();
                    this.cancelarVoo(numeroVooCancelar);
                    break;
                }
                case "3": {
                    System.out.print("Numero do voo onde a reserva sera feita: ");
                    int numeroVoo = input.nextInt();
                    input.nextLine();
                    if (this.localizarVoo(numeroVoo) != null) {
                        System.out.print("Nome do passageiro: ");
                        String nome = input.nextLine();
                        System.out.print("CPF do passageiro: ");
                        String cpf = input.nextLine();
                        if (ValidadorCpf.validaCpf(cpf)) {
                            this.cadastrarReserva(numeroVoo, nome, cpf);
                        }
                    } else {
                        System.out.println("Voo nao localizado. Tente novamente\n");
                    }
                    break;
                }
                case "4": {
                    System.out.print("Numero do voo: ");
                    int numeroVoo = input.nextInt();
                    input.nextLine();
                    if (!(this.localizarVoo(numeroVoo) == null)) {
                        System.out.print("CPF do passageiro: ");
                        String cpf = input.nextLine();
                        cancelarReserva(numeroVoo, cpf);
                    } else {
                        System.out.print("Voo nao localizado. Tente novamente\n");
                    }
                    break;
                }
                case "5": {
                    System.out.print("\nInforme o numero do voo: ");
                    int numeroVoo = input.nextInt();
                    input.nextLine();

                    this.listarReservas(numeroVoo);

                    break;
                }
                case "6": {
                    this.listarVoos();
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
