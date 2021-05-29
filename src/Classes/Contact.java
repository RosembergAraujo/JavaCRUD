package Classes;

public class Contact {

    private int contact_id;
    private String responsible;
    private String email;
    private String phone_1;
    private Object phone_2 = null;
    
    public Contact(
        String responsible,
        String email,
        String phone_1
    ) {
        this.responsible = responsible;
        this.email = email;
        this.phone_1 = phone_1;
    }


    public Object getContact_id() {
        return this.contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getResponsible() {
        return this.responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_1() {
        return this.phone_1;
    }

    public void setPhone_1(String phone_1) {
        this.phone_1 = phone_1;
    }

    public Object getPhone_2() {
        return this.phone_2;
    }

    public void setPhone_2(Object phone_2) {
        this.phone_2 = phone_2;
    }
}
