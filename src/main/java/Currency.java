import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Currency {
    private Integer id;
    private String code;
    @SerializedName("name_short")
    private String nameShort;
    @SerializedName("name_full")
    private String nameFull;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNameShort() {
        return nameShort;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("code", getCode())
                .append("nameShort", getNameShort())
                .append("nameFull", getNameFull())
                .toString();
    }

}
