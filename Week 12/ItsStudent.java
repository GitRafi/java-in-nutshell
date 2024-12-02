public class ItsStudent extends Person {
    public ItsStudent() {
        // super("Fira", "Tangerang", 19);
        System.out.println("Inside Constructor:Student\n");
    }
    
    //Override method getName from parent
    @Override
    public String getName() {
        System.out.println("Student Method getName");
        return name;
    }

    //Test Override final method
    // @Override
    // public void setName(String name) {
    //     this.name = name;
    // }

    public static void main(String[] args) {
        ItsStudent Eminem = new ItsStudent();
        Eminem.setName("Eminem");
        Eminem.setAddress("US");
        Eminem.setAge(51);

        //Accessor comes in
        System.out.println("Nama murid\t:" + Eminem.getName());
        System.out.println("Rumahnya di\t:" + Eminem.getAddress());
        System.out.println("Umurnya\t\t:" + Eminem.getAge());
    }
}

class Employee extends Person {

}