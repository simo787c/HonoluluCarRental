public class Company extends Customer {
    private String companyName;
    private String companyAddress;
    private int companyPhone;
    private int companyRegistrationNumber;

    public Company(){}

    public Company(String dN, String a, int pC, String c, int mP, int p, String e, String cN, String cA, int cP, int cRN){
        super(dN,a,pC,c,mP,p,e);
        companyName = cN;
        companyAddress = cA;
        companyPhone = cP;
        companyRegistrationNumber = cRN;
    }

    public String getCompanyName(){return companyName;}
    public String getCompanyAddress(){return companyAddress;}
    public int getCompanyPhone(){return companyPhone;}
    public int getCompanyRegistrationNumber(){return companyRegistrationNumber;}

    @Override
    public String toString(){
        return (super.toString() + "\nCompany Name: " + companyName + "\nCompany Address: " + companyAddress + "\nCompany Phone: " + companyPhone);
    }
}
