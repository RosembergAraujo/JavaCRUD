package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import Classes.Loja;
import ConnectionFactory.ConnectionFactory;



public class LojaDAO {
    
    public void addLoja(Loja loja){
        String sql = "INSERT INTO lojas(nome, nomeDono, emailDono, cpfDono, senha, seguimentoDaLoja, numFuncionarios, aluguel, dataCadastro) " + 
        " VALUES ( '" + 
        loja.getNome() + "', '" +
        loja.getNomeDono() + "', '" +
        loja.getEmailDono() + "', " +
        "AES_ENCRYPT('" +loja.getCpfDono() + "','"+ loja.getHash() +"'), " +
        "AES_ENCRYPT('" + loja.getSenha() +"','"+ loja.getHash() +"'), '" +
        loja.getSeguimentoDaLoja() + "', " +
        loja.getNumFuncionarios() + ", " +
        loja.getAluguel() + ", '" +
        new Date(loja.getDataCadastro().getTime()) +"');";

        Connection conn = null;
        PreparedStatement pstm = null;

        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(pstm != null){
                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Loja> getLojas(){
        String sql = "SELECT * FROM lojas";

        List<Loja> lojas = new ArrayList<Loja>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;


        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Loja loja = new Loja(
                    rset.getString("nome"),
                    rset.getString("nomeDono"),
                    rset.getString("emailDono"),
                    rset.getString("cpfDono"),
                    rset.getString("senha"),
                    rset.getString("seguimentoDaLoja"),
                    rset.getInt("numFuncionarios"),
                    rset.getDouble("aluguel")
                );
                loja.setId(rset.getInt("id"));
                loja.setDataCadastro(rset.getDate("dataCadastro"));
                lojas.add(loja);               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rset != null){
                    rset.close();
                }
                if (pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lojas;
    }

    public String getWithParam(String param, int id){
        String sql = "SELECT * FROM lojas WHERE id = ?";

        String result = new String();

        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            if(rset.next()){
                result = (rset.getString(param)).toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rset != null){
                    rset.close();
                }
                if (pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public String getWithHash(String preHash,String hash, int id){
        String sql = "SELECT AES_DECRYPT("+ preHash+ ", '" + hash + "')FROM lojas Where id = " + id + "";

        String result = new String();

        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            rset = pstm.executeQuery();

            if(rset.next()){
                result = rset.getString("AES_DECRYPT(" + preHash + ", '" + hash + "')");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rset != null){
                    rset.close();
                }
                if (pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public void update(Loja loja){
		String sql = "UPDATE lojas " + 
        "SET " +
        "nome = '" + loja.getNome() + "', " +
        "nomeDono = '"+ loja.getNomeDono() + "', " +
        "emailDono = '" + loja.getEmailDono() + "', " +
        "cpfDono = " + "AES_ENCRYPT('" +loja.getCpfDono() + "','"+ loja.getHash() +"'), " +
        "senha = " + "AES_ENCRYPT('" + loja.getSenha() +"','"+ loja.getHash() +"'), " +
        "seguimentoDaLoja = '" + loja.getSeguimentoDaLoja() + "', " +
        "numFuncionarios = " + loja.getNumFuncionarios() + ", " +
        "aluguel = " + loja.getAluguel() +
        " WHERE id = " + loja.getId() + ";";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null){
                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM lojas WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null){
                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
