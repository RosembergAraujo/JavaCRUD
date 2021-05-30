package Tools.Allotment;

import java.util.*;
import Classes.*;
import DAOs.*;

public class AllotmentTools {
    

    public static void listAllotments(){
        for (Allotment c : AllotmentDAO.getAllotments()){
            System.out.println( 
                "=============================" +
                " address: " + c.getAddress() + "\n" +
                " == rent: " + c.getRent() + "\n" +
                " == area: " + c.getArea() + "\n" +
                " == available: " + c.getAvailable() + "\n" +
                " == store_id: " + c.getStore_id() + "\n"
            );
        }
    }

    public static List<Allotment> getAllotments(){
        List<Allotment> allotments = new ArrayList<Allotment>();
        
        for (Allotment c : AllotmentDAO.getAllotments()) {
            allotments.add(c);
        }

        return allotments;
    }

    public static void createAllotment(Allotment allotment){
        AllotmentDAO.createAllotment(allotment);
    }

    public static void updateAllotment(Allotment allotment){
        AllotmentDAO.updateAllotment(allotment);
    }

    public static void deleteAllotment(String address){
        AllotmentDAO.deleteAllotment(address);
    }

    public static List<Object> getWithName(String columnName,String whereFind , String equalsTo){
        List<Object> listOfObjects = new ArrayList<Object>();

        if(!AllotmentDAO.getWithName(columnName, whereFind, equalsTo).equals(new ArrayList<String>())){
            for (Object c : AllotmentDAO.getWithName(columnName, whereFind, equalsTo)) {
                listOfObjects.add(c);         
            }
        }else{
            listOfObjects.add(null);
        }
    
        return listOfObjects;

    }

    public static Allotment getObject(String address){
        return AllotmentDAO.getObject(address);
    }



}
