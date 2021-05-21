package Classes;

import java.util.ArrayList;

import Tools.Validadores;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private char genero;
    Validadores val = new Validadores();

    public Pessoa(String nome, String cpf, int idade, char genero) {
        
        this.nome = nome;
        this.cpf = val.validarCPF(cpf) ? tratarCpf(cpf) : "CPF_INVALIDO";
        this.idade = idade;
        this.genero = val.validarGenero(genero) ? genero : 'X';     
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return this.genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    private String tratarCpf(String cpf){
        String cpfTratado = new String();
        cpf.split("\\D");

        for (String s : cpf.split("\\D")) {
            cpfTratado += s;
        }

        cpfTratado = voltarOsPontos(cpfTratado);

        return cpfTratado;
    }

    private String voltarOsPontos(String cpfNumerico){
        char[] cpfChareado = cpfNumerico.toCharArray();
        String finalString = new String();
        ArrayList array = new ArrayList();

        for (char c : cpfChareado) {
            array.add(String.valueOf(c));
        }

        array.add(3, ".");
        array.add(7, ".");
        array.add(11, "-");

        for (int i = 0; i < array.size(); i++) {
            finalString += array.get(i);
        }

        return finalString;
    }

    public String getCpfNumerico (String cpf){
        String cpfTratado = new String();
        cpf.split("\\D");

        for (String s : cpf.split("\\D")) {
            cpfTratado += s;
        }
        return cpfTratado;
    }
}
