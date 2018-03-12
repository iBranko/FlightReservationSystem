public class Reserva {

    private String nome;
    private String cpf;

    public Reserva(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void imprimeReserva() {
        System.out.println("Nome: " + this.nome +
                           "\nCPF: " + this.cpf);
    }

    public String getCpf() {
        return this.cpf;
    }
}
