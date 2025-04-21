package apollohospitals.urology.utilities;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonReader {
    public static Log LOGGER = LogFactory.getLog(JsonReader.class);
    public static List<Map<String, String>> getJsonDataToMap(String filePath) throws IOException {
        LOGGER.info("🧠🧠Entering method: `getJsonDataToMap(String)` in apollohospitals.urology.utilities.JsonReader 🧠🧠");
        LOGGER.info("📂📂Requested file path: " + filePath + " 📂📂");
        // Convert relative path to absolute path
        File file = Paths.get(System.getProperty("user.dir") + "/" + filePath).toFile();
        LOGGER.info("🛣️🛣️Resolved absolute path: " + file.getAbsolutePath() + " 🛣️🛣️");
        // Step 2: Parse using Jackson
        ObjectMapper mapper = new ObjectMapper();
        LOGGER.info("🔧🔧Jackson ObjectMapper initialized🔧🔧");
        List<Map<String, String>> data = mapper.readValue(file, new TypeReference<List<Map<String, String>>>() {});
        LOGGER.info("📊📊JSON file parsed successfully. Records loaded: " + data.size() + " 📊📊");
        LOGGER.info("🏁🏁Exiting method: `getJsonDataToMap(String)` in JsonReader 🏁🏁\n");
        return data;
    }
}
