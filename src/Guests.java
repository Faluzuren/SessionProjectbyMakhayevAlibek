import java.io.Serializable;

public class Guests implements Serializable {
    private Integer id;
    private String nickName;
    private String password;
    private String email;
    private String region;
    private String status;

    public Guests() {
    }

    public Guests(Integer id, String nickName, String password, String email, String region, String status) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.region = region;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  id + " " +nickName+" "+password+" "+email+" "+region+" "+status;
    }
}

