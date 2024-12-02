public class Polymorphism {
    public static void main(String[] args) {
        Person ref;
        
        ItsStudent studentObject = new ItsStudent();
        studentObject.setName("Rawrrr");
        Employee employeeObject = new Employee();
        employeeObject.setName("Miawww");

        ref = studentObject;
        String temp = ref.getName();
        System.out.println(temp);

        ref = employeeObject;
        temp = ref.getName();
        System.out.println(temp);
    }
}
