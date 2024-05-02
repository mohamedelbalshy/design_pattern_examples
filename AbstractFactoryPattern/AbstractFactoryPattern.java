package AbstractFactoryPattern;

interface Button {
    String paint();
}

interface Checkbox {
    String paint();
}

class WindowsButton implements Button {
    @Override
    public String paint() {
        return "Windows Button";
    }
}

class WindowsCheckbox implements Checkbox {

    @Override
    public String paint() {
        return "Windows Checkbox";
    }
}


class MacButton implements Button {
    @Override
    public String paint() {
        return "Mac Button";
    }
}

class MacCheckbox implements Checkbox {

    @Override
    public String paint() {
        return "Mac Checkbox";
    }
}

abstract class GUIFactory {
    abstract Button createButton();
    abstract Checkbox createCheckbox();
}

class WindowsFactory extends GUIFactory {

    @Override
    Button createButton() {
        return new WindowsButton();
    }

    @Override
    Checkbox createCheckbox() {
       return new WindowsCheckbox();
    }
}

class MacFactory extends GUIFactory {
    @Override
    Button createButton() {
        return new MacButton();
    }

    @Override
    Checkbox createCheckbox() {
       return new MacCheckbox();
    }
}

class Client {
    public static void createUI(GUIFactory guiFactory){
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        System.out.println(button.paint());
        System.out.println(checkbox.paint());
    }
}


public class AbstractFactoryPattern {
    public static void main(String[] args) {
        GUIFactory windowsFactory = new WindowsFactory();
        GUIFactory macFactory = new MacFactory();

        System.out.println("Creating Windows UI:");
        Client.createUI(windowsFactory);

        System.out.println("Creating Mac UI:");
        Client.createUI(macFactory);
    }
}
