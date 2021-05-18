package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import ConnectionFactory.ConnectionFactory;
import Loja.Loja;



public class LojaDAO {
    
    public void save(Loja loja){
        String sql = "insert into lojas(nomeDono, emailDono, cpfDono, senha, numFuncionarios, aluguel, dataCadastro) " + 
        " values ( " + 
        "?," +
        "?, " +
        "AES_ENCRYPT(?,'"+ loja.getHash() +"')," +
        "AES_ENCRYPT(?,'"+ loja.getHash() +"')," +
        "?," +
        "?," +
        "? " +
        ");";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, loja.getNomeDono());
            pstm.setString(2, loja.getEmailDono());
            pstm.setString(3, loja.getCpfDono());
            pstm.setString(4, loja.getSenha());
            pstm.setInt(5, loja.getNumFuncionarios());
            pstm.setDouble(6, loja.getAlugel());
            pstm.setDate(7, new Date(loja.getDataCadastro().getTime()));
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
                    rset.getString("nomeDono"),
                    rset.getString("emailDono"),
                    rset.getString("cpfDono"),
                    rset.getString("senha"),
                    rset.getInt("numFuncionarios"),
                    rset.getDouble("aluguel"),
                    rset.getDate("dataCadastro")
                );
                loja.setId(rset.getInt("id"));
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
            // pstm.setInt(1, id);
            
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
        "SET nomeDono = ?, " + 
        "emailDono = ?, " +
        "cpfDono = AES_ENCRYPT(?,'hash'), " +
        "senha = AES_ENCRYPT(?,'hash'), " +
        "numFuncionarios = ?, " +
        "aluguel = ?, " +
        "dataCadastro =? " +
        "WHERE id = ?;";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, loja.getNomeDono());
            pstm.setString(2, loja.getEmailDono());
            pstm.setString(3, loja.getCpfDono());
            pstm.setString(4, loja.getSenha());
            pstm.setInt(5, loja.getNumFuncionarios());
            pstm.setDouble(6, loja.getAlugel());
            pstm.setDate(7, new Date(loja.getDataCadastro().getTime()));
            pstm.setInt(8, loja.getId());

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
