package ObserverPattern;

import java.util.ArrayList;

interface Buyer {

    void custom_notify();
}

class DirectBuyer implements Buyer {
    private String full_name;
    private String mobile_no;

    DirectBuyer(String full_name, String mobile_no) {
        this.full_name = full_name;
        this.mobile_no = mobile_no;
    }

    @Override
    public void custom_notify() {
        System.out.println("message sent to: " + this.mobile_no);
        System.out.println(this.full_name + " notified!");
    }
}

class PartnerBuyer implements Buyer {
    private String company_name;
    private String mobile_no;

    PartnerBuyer(String company_name, String mobile_no) {
        this.company_name = company_name;
        this.mobile_no = mobile_no;
    }

    @Override
    public void custom_notify() {
        System.out.println("message sent to: " + this.mobile_no);
        System.out.println(this.company_name + " notified!");
    }
}

class Shop {
    private ArrayList<Buyer> buyers = new ArrayList<Buyer>();

    Shop() {
    }

    void notify_buyers() {
        for (int i = 0; i < buyers.size(); i++) {
            Buyer b = buyers.get(i);
            b.custom_notify();
            System.out.println("===============");
        }
    }

    boolean register_buyer(Buyer b) {
        return this.buyers.add(b);
    }

    boolean unregister_buyer(Buyer b) {
        return this.buyers.remove(b);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Buyer mohamed = new DirectBuyer("Mohamed Elbalshy", "+201008997139");
        Buyer garmentIO = new PartnerBuyer("Garment IO", "+20100851369");
        shop.register_buyer(mohamed);
        shop.register_buyer(garmentIO);
        shop.notify_buyers();

    }
}
