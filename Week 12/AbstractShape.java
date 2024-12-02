public abstract class AbstractShape {   
    abstract void getArea(double radius);
    abstract void getName(String name);
}

class Circle extends AbstractShape {
    @Override
    void getArea(double radius) {
        System.out.println("Luas lingkaran: " + (Math.PI * radius * radius) );
    }
    @Override
    void getName(String name) {
        System.out.println(name);
    }
}

class Square extends AbstractShape {
    @Override
    void getArea(double a) {
        System.out.println("Luas Persegi: " + (a * a) );
    }
    @Override
    void getName(String name) {
        System.out.println(name);
    }
}
