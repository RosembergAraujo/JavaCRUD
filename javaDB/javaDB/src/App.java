import java.util.Date;

import Classes.Funcionario;
import Classes.Loja;
import DAO.LojaDAO;
import Tools.Validadores;


public class App {

    public static void listarLojas(){
        LojaDAO dao = new LojaDAO();

        for (Loja c : dao.getLojas()){
            System.out.println( 
                "=============================" +
                " ID: " + c.getId() + "\n" +
                " == Nome: " + c.getNome() + "\n" +
                " == NomeDono: " + c.getNomeDono() + "\n" +
                " == Email: " + c.getEmailDono() + "\n" +
                " == CPF: " + c.getCpfDono() + "\n" +
                " == Senha: " + c.getSenha() + "\n" +
                " == Seguimento: " + c.getSeguimentoDaLoja() + "\n" +
                " == Funcionarios: " + c.getNumFuncionarios() + "\n" +
                " == Aluguel: " + c.getAluguel() + "\n" +
                " == Data: " + c.getDataCadastro() + "\n"
            );
        }
    }

    public static String getWithHash(String preHash,String hash, int id){
        LojaDAO dao = new LojaDAO();
        
        return dao.getWithHash(preHash, hash, id);
    }

    public static String getWithParam(String param, int id){
        LojaDAO dao = new LojaDAO();
        
        return dao.getWithParam(param, id);
    }

    public static void addLoja(Loja loja){
        LojaDAO dao = new LojaDAO();
        
        dao.addLoja(loja);
    }

    public static void updateLoja(Loja loja){
        LojaDAO dao = new LojaDAO();

        dao.update(loja);
    }

    public static void deleteLoja(int id){
        LojaDAO dao = new LojaDAO();

        dao.delete(id);
    }
    public static void main(String[] args) {
        Validadores val = new Validadores();
        String cpfTESTE = "008.036.990-18";

        Loja loja = new Loja(
            "lojinhaDoSeuZe2",
            "NOVOnovoDono",
            "donoDaLoja@gmail.com",
            "cpf dono 12345678",
            "1234",
            "esportivo",
            250,
            1500.75
        );
        loja.setId(1);
        loja.setHash("hash");
        loja.setDataCadastro(new Date());



        //loja.setHash("G3J4H56K6J12");
        // addLoja(loja);
        // addLoja(loja);
        // updateLoja(loja);
        // listarLojas();
        //deleteLoja(loja);
        // System.out.println(getWithHash("senha","hash", 1));
        // System.out.println(getWithParam("senha", 1));



        Funcionario fun = new Funcionario(
            loja,
            "joaozinho",
            "meuovo@gmail.com",
            cpfTESTE,
            15,
            'M',
            12345567,
            2050.90,
            "vagabundo",
            "123456678990"
        );
        
    }
}
