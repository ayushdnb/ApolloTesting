package apollohospitals.dataproviders;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.DataProvider;

import apollohospitals.urology.utilities.JsonReader;
	
public class RequestCallBackFormData {
	public Log LOGGER = LogFactory.getLog(this.getClass());
	@DataProvider(name = "invalidFormData")
    public Object[][] getInvalidFormData() throws IOException {
        LOGGER.info("🧠🧠Entering DataProvider: `getInvalidFormData()` in "
        		+ "apollohospitals.dataproviders.RequestCallBackFormData 🧠🧠");
        // Step 1: Load JSON test data from file
        LOGGER.info("📥📥Reading JSON test data from: `RequestCallBackFormTestData.json` 📥📥");
        List<Map<String, String>> data = JsonReader.getJsonDataToMap(
        		"src/test/java/apollohospitals/resources/testdata/RequestCallBackFormTestData.json");
        LOGGER.info("📊📊Total records loaded: " + data.size() + " 📊📊");
        // Step 2: Convert List<Map<String, String>> to Object[][]
        Object[][] result = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
            LOGGER.info("📦📦Loaded row " + (i + 1) + ": " + data.get(i) + " 📦📦");
        }
        LOGGER.info("✅✅Test data transformation to Object[][] completed✅✅");
        LOGGER.info("🏁🏁Exiting DataProvider: `getInvalidFormData()` in "
        		+ "apollohospitals.dataproviders.RequestCallBackFormData 🏁🏁\n");
        return result;
    }
}
