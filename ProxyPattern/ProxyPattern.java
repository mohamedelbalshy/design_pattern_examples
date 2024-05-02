package ProxyPattern;

interface FetchComponent {
    public void post(String url);
}

class Axios implements FetchComponent {

    private String base_url;

    Axios(String base_url) {
        this.base_url = base_url;
    }

    public void post(String url) {
        System.out.println("Fetching data from " + base_url + "/" + url);
    }
}

class Proxy implements FetchComponent {

    Axios axios;
    private String base_url;

    Proxy(String base_url) {
        this.base_url = base_url;
    }

    public void post(String url) {
        if (axios == null) {
            axios = new Axios(this.base_url);

        }
        axios.post(url);
    }
}

public class ProxyPattern {

    public static void main(String[] args) {
        FetchComponent proxy = new Proxy("https://google.com");
        proxy.post("users/mohamedelbalshy");
    }
}
