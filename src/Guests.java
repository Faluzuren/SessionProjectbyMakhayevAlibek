import java.io.Serializable;

public class Guests implements Serializable {
    private Integer id;
    private String nickName;
    private String password;
    private String region;

    public Guests() {
    }

    public Guests(Integer id, String nickName, String password, String region) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return  id + " " +nickName+" "+password+" "+region;
    }
}

