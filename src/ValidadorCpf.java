import com.sun.xml.internal.bind.v2.TODO;

public class ValidadorCpf {

    private static boolean isValido = false;

    public static boolean validaCpf (String cpf) {

        String parte1;
        String parte2;
        String dv;

        cpf = cpf.replaceAll("[^0-9]+","");

        try{
            parte1 = cpf.substring(0, 9);
        }catch(IndexOutOfBoundsException e){
            System.out.println("CPF invalido");
            return isValido;
        }

        parte2 = cpf.substring(cpf.length() - 2);

        dv = calculaDV(parte1);

        parte1 += dv;

        dv += calculaDV(parte1);

        if (dv.equals(parte2)) {
            isValido = true;
        } else {
            System.out.println("Digito verificador do CPF invalido");
        }

        return isValido;
    }

    private static String calculaDV(String cpf) {

        int soma = 0;
        int multiplicador = 2;
        int resto;
        String dv;

        for(int i = cpf.length()-1; i >= 0; i--, multiplicador++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * multiplicador;
        }

        resto = soma % 11;

        if (resto < 2) {
            dv = String.valueOf(0);
        } else {
            dv = String.valueOf(11 - resto);
        }

        return dv;
    }
}
