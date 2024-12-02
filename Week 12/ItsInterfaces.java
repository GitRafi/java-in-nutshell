public interface ItsInterfaces {
    boolean isEqual(Object a, Object b);
}

class TestingInterface implements ItsInterfaces {
    public boolean isEqual(Object a, Object b) {
            return (a.equals(b));
    }
}

