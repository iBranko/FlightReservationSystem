import java.util.ArrayList;

public class ControleDeVoos {

    private ArrayList<Voo> listaDeVoos = new ArrayList<Voo>();

    public void cadastrarVoo(int numeroVoo, String origem, String destino, int numeroDeAssentos) {

        if (this.listaDeVoos.add(new Voo(numeroVoo, origem, destino, numeroDeAssentos))) {
            System.out.println("Voo cadastrado com sucesso\n");
        } else {
            System.out.println("Nao foi possivel cadastrar o voo. Tente novamente\n");
        }
        return;
    }

    public void cancelarVoo(int numeroVoo) {
        if(listaDeVoos.size() > 0) {
            for (Voo v : listaDeVoos) {
                if (v.getNumero() == numeroVoo) {
                    if (listaDeVoos.remove(v)) {
                        System.out.println("Voo cancelado com sucesso\n");
                        break;
                    } else {
                        System.out.println("Nao foi possivel cancelar o voo. Tente novamente\n");
                    }
                }
            }
        } else {
            System.out.println("Voo nao encontrado\n");
        }
        return;
    }

    public boolean localizarVoo(int numeroVoo) {
//        TODO - Utilizar o metodo localizarVoo para todos os metodos que buscam se o voo existe
        boolean vooLocalizado = false;

        for (Voo v : listaDeVoos) {
            if (v.getNumero() == numeroVoo) {
                vooLocalizado = true;
                break;
            }
        }
        return vooLocalizado;
    }

    public void cadastrarReserva(int numeroVoo, String nome, String cpf) {
//        TODO - Retornar representação visual dos assentos
        if (ValidadorCpf.validaCpf(cpf)) {
            for (Voo v : listaDeVoos) {
                if (v.getNumero() == numeroVoo) {
                    if (v.adicionarReserva(nome, cpf)) {
                        System.out.println("Reserva efetuada com sucesso\n");
                    } else {
                        System.out.println("Nao foi possivel efetuar a reserva. Tente novamente\n");
                    }
                }
            }
        }
    }

    public void listarReservas(int numeroVoo) {
//        TODO - Retornar representacao visual dos assentos
        for (Voo v : listaDeVoos) {
            if (v.getNumero() == numeroVoo) {
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
        }
        System.out.println("Voo nao encontrado. Tente novamente\n");
        return;
    }

    public void listarVoos() {
//        TODO - Retornar os voos, origem, destino e numero de assentos disponiveis
        System.out.println("Voos: ");
        for (Voo v : listaDeVoos) {
            System.out.println(v.getNumero());
        }
        System.out.println();
        return;
    }

//    TODO - Incluir metodo cancelarReserva
}
