import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private Integer id;
    private String code;
    @SerializedName("name_full")
    private String nameFull;
    @SerializedName("name_short")
    private String nameShort;
    private String inn;
    @SerializedName("company_type")
    private CompanyType companyType;
    private String ogrn;
    @SerializedName("egrul_date")
    private String egrulDate;
    private Country country;
    private String fioHead;
    private String address;
    private String phone;
    @SerializedName("e_mail")
    private String eMail;
    private String www;
    @SerializedName("is_resident")
    private boolean isResident;
    private List<Security> securities = new ArrayList<Security>();

    public Company() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setСompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public void setOgrn (String ogrn) {
        this.ogrn = ogrn;
    }

    public void setEgrulDate (String egrulDate) {
        this.egrulDate = egrulDate;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public void setResident(Boolean isResident) {
        this.isResident = isResident;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNameFull() {
        return nameFull;
    }

    public String getNameShort() {
        return nameShort;
    }

    public String getInn() {
        return inn;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public String getOgrn() {
        return ogrn;
    }

    public LocalDate getEgrulDate() {
        return LocalDate.parse(this.egrulDate);
    }

    public String getAddress() {
        return address;
    }

    public String getFioHead() {
        return fioHead;
    }

    public Country getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getEMail() {
        return eMail;
    }

    public String getWww() {
        return www;
    }

    public boolean isResident() {
        return isResident;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public static LocalDate parseDate(String strDate){

        try{
            if((strDate != null) && !("").equals(strDate)){

                DateTimeFormatter parser = DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd/MM/yy][dd.MM.yyyy][dd.MM.yy]");
                LocalDate date = LocalDate.parse(strDate, parser);
                return date;
            }
        } catch (NullPointerException | DateTimeParseException e) {
            System.out.println("Неверный формат даты.");
        }
        return null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("code", code)
                .append("nameFull", nameFull)
                .append("nameShort", nameShort)
                .append("inn", inn)
                .append("companyType", companyType)
                .append("ogrn", ogrn)
                .append("egrulDate", egrulDate)
                .append("country", country)
                .append("fioHead", fioHead)
                .append("address", address)
                .append("phone", phone)
                .append("eMail", eMail)
                .append("www", www)
                .append("isResident", isResident)
                .append("securities", securities)
                .toString();
    }
}
