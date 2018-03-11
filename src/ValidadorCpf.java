import com.sun.xml.internal.bind.v2.TODO;

public class ValidadorCpf {

    private static boolean isValido = false;

    public static boolean validaCpf (String cpf) {

        String[] parts = cpf.split("-");
        String string1 = parts[0];
        String string2 = parts[1];
        int[] part1 = new int[9];
        int multiplicador = 2;

        string1 = string1.replaceAll("[^0-9]+","");

        if (string1.length() != 9 || string2.length() != 2) {
            System.out.println("CPF invalido");
        } else {
//          TODO - Incluir validacao de CPF
            isValido = true;
        }

        return isValido;
    }
}
