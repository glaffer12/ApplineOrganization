import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;

public class Security {

    private Integer id;
    private String code;
    @SerializedName("name_full")
    private String nameFull;
    private String cfi;
    @SerializedName("date_to")
    private String dateTo;
    @SerializedName("state_reg_date")
    private String stateRegDate;
    private State state;
    private Currency currency;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNameFull() {
        return nameFull;
    }

    public String getCfi() {
        return cfi;
    }

    public LocalDate getDateTo() {
        return LocalDate.parse(this.dateTo);
    }

    public String getStateRegDate() {
        return  stateRegDate;
    }

    public State getState() {
        return state;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCfi(String cfi) {
        this.cfi = cfi;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public void setStateRegDate(String stateRegDate) {
        this.stateRegDate = stateRegDate;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("code", getCode())
                .append("nameFull", getNameFull())
                .append("cfi", getCfi())
                .append("dateTo", getDateTo())
                .append("stateRegDate", getStateRegDate())
                .append("state", getState())
                .append("currency", getCurrency())
                .toString();
    }

}
