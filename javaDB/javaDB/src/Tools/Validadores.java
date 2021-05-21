package Tools;

import java.util.regex.Pattern;

public class Validadores {
    private char[] generos = { 'm', 'M', 'f', 'F' };

    public boolean validarCPF(String cpf) {

        String cpfChecker = new String();
        String cpfOrignalWithoutChecker = new String();
        String[] cpfOriginal = new String[cpf.length()];
        boolean b = Pattern.compile("\\D").matcher(cpf).find();
        if (b) {
            cpfOriginal = cpf.split("\\D");
            for (int i = 0; i < cpfOriginal.length; i++) {
                if (i <= 2) {
                    cpfChecker += cpfOriginal[i];
                }
                cpfOrignalWithoutChecker += cpfOriginal[i];
            }
        } else {
            for (int i = 0; i < cpf.length() - 2; i++) {
                cpfChecker += String.valueOf(cpf.charAt(i));
                // System.out.println(cpfChecker.length());
            }
            cpfOrignalWithoutChecker += cpf;
            // System.out.println(cpfOrignalWithoutChecker.length());
        }
        char[] iguais = cpfOrignalWithoutChecker.toCharArray();
        boolean igual = true;
        for (int i = 0; i < iguais.length -1; i++) {
            igual = iguais[i] == iguais[i+1] && igual ? true : false;
        }
        if (cpfOrignalWithoutChecker.length() == 11 && !igual) {
            int mult = cpfChecker.length() + 1;
            double cont = 0;
            for (int i = 0; i < cpfChecker.length(); i++) {
                int digit = Integer.parseInt(String.valueOf(cpfChecker.charAt(i)));
                cont = cont + mult * digit;
                if (i == cpfChecker.length() - 1 && cpfChecker.length() < 11) {
                    double rest = 11 - (cont % 11);
                    int removerCasaDecimais = (int) rest;
                    cpfChecker += String.valueOf(removerCasaDecimais);
                    cont = 0;
                    mult = cpfChecker.length() + 1;
                    i = 0;
                }
                mult -= 1;
            }
            if  (cpfOrignalWithoutChecker.equals(cpfChecker)){
                return true;
            }else {
                return false;
            }
        } return false;
    }

    public boolean validarGenero(char g) {
        for (char c : generos) {
            if (g == c) {
                return true;
            }
        }
        return false;
    }
}
