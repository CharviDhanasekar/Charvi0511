interface AdStrategy {
    String execute(String adContent);
}

// Concrete strategies
class VideoAdStrategy implements AdStrategy {
    public String execute(String adContent) {
        return "Playing video ad: " + adContent;
    }
}

class BannerAdStrategy implements AdStrategy {
    public String execute(String adContent) {
        return "Displaying banner ad: " + adContent;
    }
}

class PopupAdStrategy implements AdStrategy {
    public String execute(String adContent) {
        return "Showing popup ad: " + adContent;
    }
}

// Context to use strategies
class AdPlatform {
    private AdStrategy strategy;

    public AdPlatform(AdStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AdStrategy strategy) {
        this.strategy = strategy;
    }

    public String showAd(String adContent) {
        return strategy.execute(adContent);
    }
}

// Usage
public class Test1 {
    public static void main(String[] args) {
        AdPlatform adPlatform = new AdPlatform(new VideoAdStrategy());
        System.out.println(adPlatform.showAd("Cool product video!"));

        adPlatform.setStrategy(new BannerAdStrategy());
        System.out.println(adPlatform.showAd("Buy now banner!"));
    }
}