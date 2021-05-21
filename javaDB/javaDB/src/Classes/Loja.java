package Classes;

import java.util.Date;

public class Loja {
    private int id;
    private String nome = "nomeDaLojaPADRAO";
    private String nomeDono = "nomePADRAO"; //valores só pra n ter q ficar criando obrigatoriamente td hora
    private String emailDono = "emailPADRAO";
    private String cpfDono = "cpfPADRAO";
    private String senha = "senhaPADRAO";
    private String seguimentoDaLoja = "seguimentoPADRAO";
    private int numFuncionarios = 123;
    private double aluguel = 1234;
    private Date dataCadastro = new Date();
    private String hash = "hash";

    public Loja (
        String nome,
        String nomeDono, 
        String emailDono, 
        String cpfDono, 
        String senha,
        String seguimentoDaLoja, 
        int numFuncionarios, 
        double aluguel){
            this.nome = nome;
            this.nomeDono = nomeDono;
            this.emailDono = emailDono;
            this.cpfDono = cpfDono;
            this.senha = senha;
            this.seguimentoDaLoja = seguimentoDaLoja;
            this.numFuncionarios = numFuncionarios;
            this.aluguel = aluguel;
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

    public String getNomeDono() {
        return this.nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getEmailDono() {
        return this.emailDono;
    }

    public void setEmailDono(String emailDono) {
        this.emailDono = emailDono;
    }

    public String getCpfDono() {
        return this.cpfDono;
    }

    public void setCpfDono(String cpfDono) {
        this.cpfDono = cpfDono;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSeguimentoDaLoja() {
        return this.seguimentoDaLoja;
    }

    public void setSeguimentoDaLoja(String seguimentoDaLoja) {
        this.seguimentoDaLoja = seguimentoDaLoja;
    }

    public int getNumFuncionarios() {
        return this.numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    public double getAluguel() {
        return this.aluguel;
    }

    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
