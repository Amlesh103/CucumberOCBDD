package awesomecucumber.domainobjects;

public class BillingDetails {


    private String billingFirstName;
    private String billingLastName;
    private String billingCountry;
    private String billingAddressLine1;
    private String billingCity;
    private String billingState;
    private String billingZip;
    private String billingEmail;

    public BillingDetails(String billingFirstName, String billingLastName, String billingCountry,
                          String billingAddressLine1, String billingCity, String billingState,
                          String billingZip, String billingEmail) {
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingCountry = billingCountry;
        this.billingAddressLine1 = billingAddressLine1;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingZip = billingZip;
        this.billingEmail = billingEmail;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingAddressLine1() {
        return billingAddressLine1;
    }

    public void setBillingAddressLine1(String billingAddressLine1) {
        this.billingAddressLine1 = billingAddressLine1;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

}
