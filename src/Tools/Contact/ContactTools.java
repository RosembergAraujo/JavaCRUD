package Tools.Contact;

import java.util.*;
import Classes.*;
import DAOs.*;

public class ContactTools {

    public static void listContacts(){
        for (Contact c : ContactDAO.getContacts()){
            System.out.println( 
                "=============================" +
                " contact_id: " + c.getContact_id() + "\n" +
                " == responsible: " + c.getResponsible() + "\n" +
                " == email: " + c.getEmail() + "\n" +
                " == phone_1: " + c.getPhone_1() + "\n" +
                " == phone_2: " + c.getPhone_2() + "\n"
            );
        }
    }

    public static List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<Contact>();
        
        for (Contact c : ContactDAO.getContacts()) {
            contacts.add(c);
        }

        return contacts;
    }

    public static void createContact(Contact contact){
        ContactDAO.createContact(contact);
    }

    public static void updateContact(Contact contact){
        ContactDAO.updateContact(contact);
    }

    public static void deleteContact(int id){
        ContactDAO.deleteContact(id);
    }

    public static int getLastContactId(){
        return ContactDAO.getLastContactId();
    }

    public static List<Object> getWithName(String columnName,String whereFind , String equalsTo){
        List<Object> listOfObjects = new ArrayList<Object>();

        if(!ContactDAO.getWithName(columnName, whereFind, equalsTo).equals(new ArrayList<Object>())){
            for (Object c : ContactDAO.getWithName(columnName, whereFind, equalsTo)) {
                listOfObjects.add(c);         
            }
        }else{
            listOfObjects.add(null);
        }
    
        return listOfObjects;
    }

    public static Contact getObject(int contact_id){
        return ContactDAO.getObject(contact_id);
    }
}
