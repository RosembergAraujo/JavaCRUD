package DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Classes.*;
import ConnectionFactory.ConnectionFactory;
import Tools.Allotment.AllotmentTools;

public class AllotmentDAO {
    
    public static void createAllotment(Allotment allotment){
        String sql = "INSERT INTO allotment(rent, area, address) VALUES ("+
        allotment.getRent() + ", " +
        "'" + allotment.getArea() + "', "+
        "'" + allotment.getAddress() +"');";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            if(AllotmentTools.getWithName("address", "address", "'"+allotment.getAddress()+"'").get(0) == null){
                pstm.execute();
            }else {
                System.out.println("JÁ EXISTE UM LOTE COM ESTE NOME");
            }
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

    public static List<Allotment> getAllotments(){
        String sql = "SELECT * FROM allotment";

        List<Allotment> allotments = new ArrayList<Allotment>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;


        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Allotment allotment = new Allotment(
                    rset.getString("address"),
                    rset.getDouble("rent"),
                    rset.getString("area"),
                    rset.getBoolean("available")
                );
                allotments.add(allotment);               
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

        return allotments;
    }

    public static List<Object> getWithName(String columnName, String whereFind,  String equalsTo){
        String sql = "SELECT " + columnName +" FROM allotment WHERE "+ whereFind +" = "+ equalsTo +"";

        List<Object> returns = new ArrayList<Object>();

        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){
                returns.add(rset.getObject(columnName));
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

        return returns;
    }

    public static Allotment getObject(String address){
        String sql = "SELECT * FROM allotment WHERE address = '"+address+"'";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;


        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                Allotment allotment = new Allotment(
                    rset.getString("address"),
                    rset.getDouble("rent"),
                    rset.getString("area"),
                    rset.getBoolean("available")
                );
                allotment.setStore_id(rset.getInt("store_id"));
                return allotment;
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

        return null;
    }

    public static void updateAllotment(Allotment allotment){
		String sql = "UPDATE allotment SET " +
        "address = '" + allotment.getAddress() + "', "+
        "rent = " + allotment.getRent() + ", "+
        "area = '" + allotment.getArea() + "', "+
        "available = " + allotment.getAvailable() + ", " +
        "store_id = " + allotment.getStore_id() + " WHERE address = '"+allotment.getAddress()+"'";

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

    public static void deleteAllotment(String address){
        String sql = "DELETE FROM allotment WHERE address = '" + address + "';";
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
}
