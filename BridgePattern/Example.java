package BridgePattern;

abstract class Remote {
    abstract void changeChannel();
}

abstract class TV {
    protected Remote remote;
    private Boolean isOn = false;

    TV(Remote r) {
        this.remote = r;
    }

    void onOffToggle() {
        this.isOn = !this.isOn;
    }

    Boolean isOn() {
        return isOn;
    }

    abstract void setChannel();

}

class Sony extends TV {

    Sony(Remote r) {
        super(r);
    }

    void setChannel() {
        this.remote.changeChannel();
    }

}

class NormalRemote extends Remote {

    @Override
    void changeChannel() {
        System.out.println("Change Channel with button clicks");
    }

}

class SmartRemote extends Remote {
    @Override
    void changeChannel() {
        System.out.println("Change Channel with voice input");
    }
}

public class Example {

    public static void main(String[] args) {

        Remote smartRemote = new SmartRemote();

        TV sony = new Sony(smartRemote);

        sony.setChannel();
    }
}
