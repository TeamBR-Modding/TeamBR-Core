package manual;

import java.util.HashMap;

public class ManualDirector {

    /**
     * The Collection of all the registries
     */
    private static HashMap<Class, ManualRegistry> registries = new HashMap<>();

    public static void registerManual(Class modClass) {
        registries.put(modClass, new ManualRegistry(modClass));
    }

    public static ManualRegistry getManualRegistry(Class modClass) {
        return registries.get(modClass);
    }
}
