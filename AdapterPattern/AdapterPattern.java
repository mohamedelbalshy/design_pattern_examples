package AdapterPattern;

interface Legacy {
    public void process(Double d);
}

interface New {
    void process(Integer n);
}

class LegacyProcessor implements Legacy {

    public void process(Double number) {
        System.out.println("processing in legacy: " + number);
    }
}

class Adapter implements New {

    public void process(Integer number) {
        Double d = Double.valueOf(number);
        new LegacyProcessor().process(d);
    }
}

public class AdapterPattern {

    public static void main(String[] args) {
        Integer x = 10;
        new Adapter().process(x);

    }

}
