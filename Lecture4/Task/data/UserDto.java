package data;

public class UserDto {
    private String email;
    private String password;
    private String id;
    private String registeredAt;
    private String usersToken;

    public String getToken() {
        return usersToken;
    }

    public void setToken(String usersToken) {
        this.usersToken = usersToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public UserDto(){
    }

    public UserDto(String email, String password, String usersToken){
        this.email = email;
        this.password = password;
        this.usersToken = usersToken;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}