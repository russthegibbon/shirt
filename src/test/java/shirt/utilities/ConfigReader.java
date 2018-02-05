package shirt.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.file.Paths;

public class ConfigReader {
    private String configPath;
    private Logger log = LogManager.getLogger("com.peppermintspencer");

    public ConfigReader(String configPath) {
        // TODO: read the data in once, then store it in memory.
        this.configPath = configPath;
    }

    public JSONObject getValue(String key) {
        log.debug("Looking for "+ key + " configuration in the json file.");
        log.debug("Current directory: " + Paths.get(".").toAbsolutePath().normalize().toString());
        JSONObject jsonObject = new JSONObject();
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader(configPath));
            jsonObject = (JSONObject) object;
        } catch (Exception exception) {
            log.fatal(exception.getMessage());
        }
        return (JSONObject) jsonObject.get(key);
    }

    public String getId(String type, String key) {
        JSONArray jsonArray = new JSONArray();
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader(configPath));
            JSONObject jsonObject = (JSONObject) object;
            jsonArray = (JSONArray) jsonObject.get(type);
        } catch (Exception exception) {
            log.fatal(exception.getMessage());
        }
        for (Integer i = 0; i < jsonArray.size(); i++) {
            // TODO: check for duplicate items in the json.
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if (jsonObject.get("name").equals(key)) {
                log.debug("Found a matching " + type + " item for " + key + " with ID: " + jsonObject.get("id"));
                return ((String) jsonObject.get("id"));
            }
        }
        log.fatal("Could not find " + type + " ID for: " + key);
        return "";
    }
}
