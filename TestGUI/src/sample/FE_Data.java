package sample;

public class FE_Data {
    private String CustomerType;
    private String State;
    private String CreditBureau;
    private Boolean PEP;
    private Boolean OnlineBanking;
    private Boolean ForeignIndicator;
    private Boolean SpecialUse;
    private Integer CreditLow;
    private Integer CreditHigh;
    private String FirstName;
    private String LastName;
    private Integer Age;
    private String City;
    private String Zipcode;
    private String SS_Num;

    public FE_Data() {
        CustomerType = "";
        State = "";
        CreditBureau = "";
        this.PEP = false;
        OnlineBanking = false;
        ForeignIndicator = false;
        SpecialUse = false;
        CreditLow = 0;
        CreditHigh = 850;
        FirstName = "";
        LastName = "";
        Age = 0;
        City = "";
        Zipcode = "000000";
        this.SS_Num = "000-00-0000";
    }

    public FE_Data(final FE_Data copy) {
        CustomerType = copy.CustomerType;
        State = copy.State;
        CreditBureau = copy.CreditBureau;
        this.PEP = copy.PEP;
        OnlineBanking = copy.OnlineBanking;
        ForeignIndicator = copy.ForeignIndicator;
        SpecialUse = copy.SpecialUse;
        CreditLow = copy.CreditLow;
        CreditHigh = copy.CreditHigh;
        FirstName = copy.FirstName;
        LastName = copy.LastName;
        Age = copy.Age;
        City = copy.City;
        Zipcode = copy.Zipcode;
        this.SS_Num = copy.SS_Num;
    }

    public FE_Data(String customerType, String state, String creditBureau, Boolean PEP, Boolean onlineBanking,
                   Boolean foreignIndicator, Boolean specialUse, Integer creditLow, Integer creditHigh,
                   String firstName, String lastName, Integer age, String city, String zipcode, String SS_Num) {
        CustomerType = customerType;
        State = state;
        CreditBureau = creditBureau;
        this.PEP = PEP;
        OnlineBanking = onlineBanking;
        ForeignIndicator = foreignIndicator;
        SpecialUse = specialUse;
        CreditLow = creditLow;
        CreditHigh = creditHigh;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        City = city;
        Zipcode = zipcode;
        this.SS_Num = SS_Num;
    }

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String customerType) {
        CustomerType = customerType;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCreditBureau() {
        return CreditBureau;
    }

    public void setCreditBureau(String creditBureau) {
        CreditBureau = creditBureau;
    }

    public Boolean getPEP() {
        return PEP;
    }

    public void setPEP(Boolean PEP) {
        this.PEP = PEP;
    }

    public Boolean getOnlineBanking() {
        return OnlineBanking;
    }

    public void setOnlineBanking(Boolean onlineBanking) {
        OnlineBanking = onlineBanking;
    }

    public Boolean getForeignIndicator() {
        return ForeignIndicator;
    }

    public void setForeignIndicator(Boolean foreignIndicator) {
        ForeignIndicator = foreignIndicator;
    }

    public Boolean getSpecialUse() {
        return SpecialUse;
    }

    public void setSpecialUse(Boolean specialUse) {
        SpecialUse = specialUse;
    }

    public Integer getCreditLow() {
        return CreditLow;
    }

    public void setCreditLow(Integer creditLow) {
        CreditLow = creditLow;
    }

    public Integer getCreditHigh() {
        return CreditHigh;
    }

    public void setCreditHigh(Integer creditHigh) {
        CreditHigh = creditHigh;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getSS_Num() {
        return SS_Num;
    }

    public void setSS_Num(String SS_Num) {
        this.SS_Num = SS_Num;
    }
}
