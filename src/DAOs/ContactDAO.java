package DAOs;

import java.sql.*;
import java.util.*;

import Classes.*;
import ConnectionFactory.ConnectionFactory;

public class ContactDAO {

      
    public static void createContact(Contact contact){
        String sql;
        if (contact.getPhone_2() == null){
            sql = "INSERT INTO contact (responsible, email, phone_1) VALUES ('"+
                contact.getResponsible() + "', " +
                "'" + contact.getEmail() + "', "+
                "'" + contact.getPhone_1() +"');";
        }else{
            sql = "INSERT INTO contact (responsible, email, phone_1, phone_2) VALUES ('"+
                contact.getResponsible() + "', " +
                "'" + contact.getEmail() + "', "+
                "'" + contact.getPhone_1() + "', "+
                "'" + contact.getPhone_2() +"');";
        }

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

    public static List<Contact> getContacts(){
        String sql = "SELECT * FROM contact";

        List<Contact> contacts = new ArrayList<Contact>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;


        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Contact contact = new Contact(
                    rset.getString("responsible"),
                    rset.getString("email"),
                    rset.getString("phone_1")
                );
                contact.setPhone_2(rset.getObject("phone_2"));
                contact.setContact_id(rset.getInt("contact_id"));
                contacts.add(contact);               
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

        return contacts;
    }

    public static int getLastContactId(){
        String sql = "SELECT MAX(contact_id) as contact_id FROM contact;";

        int lastContactId = -1;

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;


        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            lastContactId = (rset.next()) ? rset.getInt("contact_id") : -1;

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

        return lastContactId;
    }

    public static Contact getObject(int contact_id){
        String sql = "SELECT * FROM contact WHERE contact_id = "+contact_id+"";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;


        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                Contact contact = new Contact(
                    rset.getString("responsible"),
                    rset.getString("email"),
                    rset.getString("phone_1")
                );
                contact.setPhone_2(rset.getObject("phone_2"));
                contact.setContact_id(rset.getInt("contact_id"));
                return contact;
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

    public static List<Object> getWithName(String columnName, String whereFind,  String equalsTo){
        String sql = "SELECT " + columnName +" FROM contact WHERE "+ whereFind +" = "+ equalsTo +"";

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

    public static void updateContact(Contact contact){

        String sql = "";

        if (contact.getPhone_2() == null){
            sql = "UPDATE contact " +
            "SET responsible = '" + contact.getResponsible() + "', "+
            "email = '" + contact.getEmail() + "', " +
            "phone_1 = '" + contact.getPhone_1() + "' " +
            "WHERE contact_id = "+contact.getContact_id()+"";
        }else {
            sql = "UPDATE contact " +
            "SET responsible = '" + contact.getResponsible() + "', "+
            "email = '" + contact.getEmail() + "', " +
            "phone_1 = '" + contact.getPhone_1() + "', " +
            "phone_2 = '" + contact.getPhone_2() + "' " +
            "WHERE contact_id = "+contact.getContact_id()+"";
        }


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

    public static void deleteContact(int id){
        String sql = "DELETE FROM contact WHERE contact_id = '" + id + "';";
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
