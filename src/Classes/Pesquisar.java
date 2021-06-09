package Classes;


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

