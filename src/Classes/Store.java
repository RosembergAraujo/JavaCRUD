package Classes;

public class Store {

    private int id;
    private String fantasy_name;
    private String CNPJ;
    private String allotment_address;
    private int contact_id;
    private Contact contact;
    private Allotment allotment;

    public Store( 
        String fantasy_name, 
        String CNPJ
    ) {
        this.fantasy_name = fantasy_name;
        this.CNPJ = CNPJ;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFantasy_name() {
        return this.fantasy_name;
    }

    public void setFantasy_name(String fantasy_name) {
        this.fantasy_name = fantasy_name;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getAllotment_address() {
        return this.allotment_address;
    }

    public void setAllotment_address(String allotment_address) {
        this.allotment_address = allotment_address;
    }

    public int getContact_id() {
        return this.contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
        this.contact_id = (int) contact.getContact_id();
    }

    public Allotment getAllotment() {
        return this.allotment;
    }

    public void setAllotment(Allotment allotment) {
        this.allotment = allotment;
        this.allotment_address = allotment.getAddress();
    }


}
