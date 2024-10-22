public class RecursiveMethod {

    public static void sayHello(int count) {
        System.out.println("Hello");

        if (count <= 1) {
            return;
        }

        sayHello(count - 1);
    }
    public static void main(String[] args) {
       sayHello(3); 
    }
}
