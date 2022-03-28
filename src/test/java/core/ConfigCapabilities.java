package core;

import com.google.gson.Gson;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ConfigCapabilities {

    private String jsonPath;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    public ConfigCapabilities(String jsonPath){
        this.jsonPath = jsonPath;
        loadCapabilities();
    }

    public void loadCapabilities() {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(jsonPath));

            Gson gson = new Gson();
            Map<String,String> mapCapabilities = gson.fromJson(reader,Map.class);

            for ( Map.Entry<String,String> capability : mapCapabilities.entrySet()) {
                capabilities.setCapability(capability.getKey(),capability.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }
}
