import org.apache.commons.lang3.builder.ToStringBuilder;

public class Country {

    private Integer id;
    private String code;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("code", getCode())
                .append("name", getName())
                .toString();
    }

}
