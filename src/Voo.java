import java.util.ArrayList;

public class Voo {

    private String origem;
    private String destino;
    private int numero;
    private int assentosDisponiveis;
    private ArrayList<Reserva> listaDeReserva = new ArrayList<Reserva>();

    public Voo (int numero, String origem, String destino, int numeroDeAssentos) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.assentosDisponiveis = numeroDeAssentos;
    }

    public int getNumero() {
        return this.numero;
    }

    public boolean adicionarReserva(String nome, String cpf) {
        if (this.assentosDisponiveis > 0) {
            this.assentosDisponiveis --;
            return this.listaDeReserva.add(new Reserva(nome, cpf));
        } else {
            System.out.println("O voo encontra-se cheio.");
        }
        return false;
    }

    public ArrayList<Reserva> getListaDeReserva() {
        return this.listaDeReserva;
    }
}
