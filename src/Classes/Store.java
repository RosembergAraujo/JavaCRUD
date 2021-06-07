package Classes;

public class Store {

    private int id;
    private String fantasy_name;
    private String CNPJ;
    private String allotment_address;
    private String social_reason;
    private String activity;
    private String model;
    private String salesOrServiceProvision;
    private String obsText;
    private int contact_id;
    private Contact contact;
    
    private Allotment allotment;

    public Store(String fantasy_name, String CNPJ, String social_reason, String activity, String model, String note, String salesOrServiceProvision) {
        this.fantasy_name = fantasy_name;
        this.CNPJ = CNPJ;
        this.social_reason = social_reason;
        this.activity = activity;
        this.model = model;
        this.obsText = note;
        this.salesOrServiceProvision = salesOrServiceProvision;
    }

    public int getId() {
        return this.id;
    }

    public String getSocial_reason() {
        return social_reason;
    }

    public void setSocial_reason(String social_reason) {
        this.social_reason = social_reason;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSalesOrServiceProvision() {
        return salesOrServiceProvision;
    }

    public void setSalesOrServiceProvision(String salesOrServiceProvision) {
        this.salesOrServiceProvision = salesOrServiceProvision;
    }

    public String getObsText() {
        return obsText;
    }
    
    public void setObsText(String obsText) {
        this.obsText = obsText;
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
