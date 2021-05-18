import java.util.Date;
import Loja.Loja;
import DAO.LojaDAO;

public class App {

    public static void listarLojas(){
        LojaDAO dao = new LojaDAO();

        for (Loja c : dao.getLojas()){
            System.out.println( 
                "=============================" +
                " ID: " + c.getId() + "\n" +
                " == Nome: " + c.getNomeDono() + "\n" +
                " == Email: " + c.getEmailDono() + "\n" +
                " == CPF: " + c.getCpfDono() + "\n" +
                " == Senha: " + c.getSenha() + "\n" +
                " == Funcionarios: " + c.getNumFuncionarios() + "\n" +
                " == Aluguel: " + c.getAlugel() + "\n" +
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
        
        dao.save(loja);
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
        Loja loja = new Loja(
            "primeiroDono",
            "donoDaLoja@gmail.com",
            "cpf dono 12345678",
            "123456",
            250,
            1500.75,
            new Date()
        );

        loja.setHash("G3J4H56K6J12");
        
        addLoja(loja);
        addLoja(loja);
        listarLojas();
        //updateLoja(loja);
        //deleteLoja(loja);
        // System.out.println(getWithHash("cpfDono","hash", 1));
        //System.out.println(getWithParam("nomeDono", 1));

    }
}
