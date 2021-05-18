package Loja;

import java.util.Date;

public class Loja {
    private int id;
    private String nomeDono;
    private String emailDono;
    private String cpfDono;
    private String senha;
    private int numFuncionarios;
    private double aluguel;
    private Date dataCadastro;
    private String hash = "hash";

    public Loja (
        String nomeDono, 
        String emailDono, 
        String cpfDono, 
        String senha, 
        int numFuncionarios, 
        double aluguel,
        Date dataCadastro){
            this.nomeDono = nomeDono;
            this.emailDono = emailDono;
            this.cpfDono = cpfDono;
            this.senha = senha;
            this.numFuncionarios = numFuncionarios;
            this.aluguel = aluguel;
            this.dataCadastro = dataCadastro;
    }

    public void exibir() {
        System.out.println(
            "nome: " + this.nomeDono + "\n" +
            "email: " + this.emailDono + "\n" +
            "cpfDono: " + this.cpfDono + "\n" +
            "senha: " + this.senha + "\n" +
            "func: " + this.numFuncionarios + "\n" +
            "aluguel: " + this.aluguel + "\n" +
            "data: " + this.dataCadastro + "\n"
        );
    }

    public int getId(){
        return id;
    }

    public String getNomeDono(){
        return nomeDono;
    }

    public String getEmailDono(){
        return emailDono;
    }

    public String getCpfDono(){
        return cpfDono;
    }

    public String getSenha(){
        return senha;
    }

    public int getNumFuncionarios(){
        return numFuncionarios;
    }

    public double getAlugel(){
        return aluguel;
    }

    public Date getDataCadastro(){
        return dataCadastro;
    }

    public String getHash(){
        return hash;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNomeDono(String nome){
        this.nomeDono = nome;
    }

    public void setEmailDono(String emailDono){
        this.emailDono = emailDono;
    }

    public void setCpfDono(String cpfDono){
        this.cpfDono = cpfDono;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setNumFuncionarios(int numFuncionarios){
        this.numFuncionarios = numFuncionarios;
    }

    public void setDataCadastro(Date dataCadastro){
        this.dataCadastro = dataCadastro;
    }

    public void setHash(String hash){
        this.hash = hash;
    }

}
