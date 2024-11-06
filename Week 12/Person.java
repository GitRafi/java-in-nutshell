public class Person {
    protected String name;
    protected String address;
    protected int age;

    public Person() {
        System.out.println("Inside Constructore:Person");
    }

    //Second Constructor
    public Person(String name, String address, int age) {
        this.name = name; this.age = age; this.address = address;
        System.out.println("From Constructor : ");
        System.out.println(this.name);
        System.out.println(this.address);
        System.out.println(this.age);
        System.out.println();
    }

    //Accessor
    public String getName() {
        System.out.println("Parent Method getName");
        return name;
    }

    public String getAddress() {
        System.out.println("Parent Method getAddress");
        return address;
    }
    public int getAge() {
        System.out.println("Parent Method getInt");
        return age;
    }

    //Modifier final
    public final void setName(String name) {
        this.name = name;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

    public final void setAge(int age) {
        this.age = age;
    }
}
