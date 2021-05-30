package Tools;

import GUI.Consulta;

public class CheckAccount {
    
    private String password;
    private String user;
    private boolean accountExists = true;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getPassword(){
        return password;
    }

    public String getUser(){
        return user;
    }

    public void accountExists(boolean exist){
        this.accountExists = exist;
    }
    public boolean account(){
        return  accountExists;
    }

    public void screen(){
        Consulta screenConsulta = new Consulta();
        screenConsulta.setVisible(accountExists);
    }


}
