package sprint1;

enum Type {
    Driver,
    Customer
}
public abstract class User {
    private String username;
    private String password;
    private String mobile;
    private boolean suspend;
    private Type type;
    private Registration registration;
    public User(String username, String password, String mobile, Type type) {
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.suspend = false;
        this.type = type;
       
    }
    
    public User() {
        this.username = "";
         this.password = "";
        this.mobile = "";
        this.suspend = false;
        this.registration = null;
    }
    
    public void register(){
        registration.register();
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
    
    

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public boolean isSuspend() {
        return suspend;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", suspend=" + suspend + ", type=" + type + ", registration=" + registration + '}';
    }
    
}