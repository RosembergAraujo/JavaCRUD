package GUI;

import javax.swing.JTable;

import Classes.Allotment;
import Classes.Contact;
import Classes.Store;
import Tools.Store.StoreTools;

public class Pesquisar {
    private static Object[][] listTable;
    private static int leng;


    public static void setTable(Object[][] args){
        listTable = args;
    }

    public static Object[][] getTable(){
        return listTable;
    }
    public static void setLeng(int len){
        leng = len;
    }

    public static int getLeng(){
        return leng;
    }



  

}

