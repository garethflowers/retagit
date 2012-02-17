package garethflowers.retagit;

/**
 * Settings
 * 
 * @author Gareth Flowers <gareth@garethflowers.com>
 */
public class Settings {

    private Settings() {
        Settings.AtomicParsley = null;
    }

    private static String AtomicParsley;

    public static String getAtomicParsley() {
        if (Settings.AtomicParsley == null) {
            java.io.File tmpAtomicParsley = new java.io.File(
                    ApplicationDirectory.getPath()
                            + System.getProperty("file.separator")
                            + "atomicparsley");

            if (!tmpAtomicParsley.exists()) {
                Settings.AtomicParsley = "AtomicParsley";
            } else {
                Settings.AtomicParsley = tmpAtomicParsley.getAbsolutePath();
            }
        }

        return Settings.AtomicParsley;
    }
}
