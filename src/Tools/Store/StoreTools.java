package Tools.Store;

import java.util.*;
import Classes.*;
import DAOs.*;

public class StoreTools {
    public static void listStores(){
        for (Store c : StoreDAO.getStores()){
            Contact contact = c.getContact();
            Allotment allotment = c.getAllotment();
            System.out.println( 
                "=============================" +
                " ID: " + c.getId() + "\n" +
                " == fantasy_name: " + c.getFantasy_name() + "\n" +
                " == CNPJ: " + c.getCNPJ() + "\n\n" +
                " == ALLOTMENT address: " + allotment.getAddress() + "\n" +
                " == ALLOTMENT rent: " + allotment.getRent() + "\n" +
                " == ALLOTMENT area: " + allotment.getArea() + "\n" +
                " == ALLOTMENT available: " + allotment.getAvailable() + "\n" +
                " == ALLOTMENT store_id: " + allotment.getStore_id() + "\n\n" + 
                " == CONTACT contact_id: " + contact.getContact_id() + "\n" +
                " == CONTACT responsible: " + contact.getResponsible() + "\n" +
                " == CONTACT email: " + contact.getEmail() + "\n" +
                " == CONTACT phone_1: " + contact.getPhone_1() + "\n" +
                " == CONTACT phone_2: " + contact.getPhone_2() + "\n"
            );
        }
    }


    public static List<Store> getStores(){
        List<Store> stores = new ArrayList<Store>();
        for (Store c : StoreDAO.getStores()){
            stores.add(c);
        }
        return stores;
    }

    public static List<Object> getWithName(String columnName,String whereFind , String equalsTo){
        List<Object> listOfObjects = new ArrayList<Object>();

        if(!StoreDAO.getWithName(columnName, whereFind, equalsTo).equals(new ArrayList<String>())){
            for (Object c : StoreDAO.getWithName(columnName, whereFind, equalsTo)) {
                listOfObjects.add(c);         
            }
        }else{
            listOfObjects.add(null);
        }
        return listOfObjects;
    }

    public static Store getObject(int id){
        return (Store) StoreDAO.getObject(id);
    }

    public static void createStore(Store store){
        StoreDAO.createStore(store);
    }

    public static int getLastStoreId(){
        return StoreDAO.getLastStoreId();
    }
}
