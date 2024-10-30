public class BukuAlamat{
    private String name;
    private String address;
    private String telp_number;
    private String email;

    private static int numberInstance = 0;

    public BukuAlamat() {
        numberInstance++;
    }

    public static int getInstanceCount() {
        return numberInstance;
    }

    //Accessor (Menampilkan seluruh data)
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelp() {
        return telp_number;
    }

    public String getEmail() {
        return email;
    }

    //Modifier (Update data)
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelp(String telp_number) {
        this.telp_number = telp_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}