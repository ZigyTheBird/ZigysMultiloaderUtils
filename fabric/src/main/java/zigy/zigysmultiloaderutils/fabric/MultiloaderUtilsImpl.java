package zigy.zigysmultiloaderutils.fabric;

import zigy.zigysmultiloaderutils.fabric.events.ClientLoginEvent;
import zigy.zigysmultiloaderutils.fabric.events.ServerLoginEvent;

public class MultiloaderUtilsImpl {
    public static void forceClientToHaveMod(String mod_id, String version) {
        ServerLoginEvent.requiredMods.put(mod_id, version);
    }

    public static void forceServerToHaveMod(String mod_id, String version) {
        ClientLoginEvent.requiredMods.put(mod_id, version);
    }
}
