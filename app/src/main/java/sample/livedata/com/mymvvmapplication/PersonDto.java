package sample.livedata.com.mymvvmapplication;

public class PersonDto {

    private String name;
    private String email;

    public PersonDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
