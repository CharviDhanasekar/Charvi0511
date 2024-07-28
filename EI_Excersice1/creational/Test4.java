
import java.util.HashMap;
import java.util.Map;

class ConfigurationManager {
    private static ConfigurationManager instance;
    private Map<String, String> configurations;

    private ConfigurationManager() {
        configurations = new HashMap<>();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void setConfiguration(String key, String value) {
        configurations.put(key, value);
    }

    public String getConfiguration(String key) {
        return configurations.get(key);
    }
}

// Usage
public class Test4 {
    public static void main(String[] args) {
        ConfigurationManager configManager1 = ConfigurationManager.getInstance();
        configManager1.setConfiguration("theme", "dark");

        ConfigurationManager configManager2 = ConfigurationManager.getInstance();
        System.out.println("Theme: " + configManager2.getConfiguration("theme"));  // Output: dark

        System.out.println(configManager1 == configManager2);  // Output: true
    }
}