package Classes;

import java.util.Date;

public class Funcionario extends Pessoa {
    private Loja loja;
    private String email;
    private int cracha;
    private double salario;
    private String cargo;
    private String telefone;
    private Date dataCadastro; 


    public Funcionario(
        Loja loja,
        String nome,
        String email, 
        String cpf, 
        int idade, 
        char genero,
        int cracha,
        double salario,
        String cargo,
        String telefone
    ) {
            super(nome, cpf, idade, genero);
            this.loja = loja;
            this.email = email;
            this.cracha = cracha;
            this.salario = salario;
            this.cargo = cargo;
            this.telefone = telefone;
    }


    public Loja getLoja() {
        return this.loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCracha() {
        return this.cracha;
    }

    public void setCracha(int cracha) {
        this.cracha = cracha;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }   
}
