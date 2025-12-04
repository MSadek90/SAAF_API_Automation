import java.util.List;
import com.example.utils.JsonReader;

public class Base {







public static Object[][] getDataProvider(String filename, String className){
        try {
            Class<?> clazz = Class.forName(className);
            List<?> payload = JsonReader.readJsonList(filename, clazz);
            Object[][] data = new Object[payload.size()][];
            for (int i = 0; i < payload.size(); i++) {
                data[i] = new Object[] { payload.get(i) };
            }
            return data;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generic helper to obtain a List of objects from a JSON array.
     */
    public static <T> List<T> getDataList(String filename, Class<T> clazz) {
        return JsonReader.readJsonList(filename, clazz);
    }


}

