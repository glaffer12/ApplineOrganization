import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CompanyType {
    private Integer id;
    @SerializedName("name_short")
    private String nameShort;
    @SerializedName("name_full")
    private String nameFull;

    public void setId(Integer id) {
        this.id=id;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public Integer getId() {
        return id;
    }

    public String getNameShort() {
        return nameShort;
    }

    public String getNameFull() {
        return nameFull;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("nameShort", getNameShort())
                .append("nameFull", getNameFull())
                .toString();
    }



}
