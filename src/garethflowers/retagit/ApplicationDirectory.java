package garethflowers.retagit;

import java.io.File;

/**
 * Application Directory
 */
public class ApplicationDirectory {

    private static String path = null;

    private ApplicationDirectory() {
    }

    public static String getPath() {
        if (ApplicationDirectory.path == null) {
            String temppath = ApplicationDirectory.class.getProtectionDomain()
                    .getCodeSource().getLocation().getPath();

            try {
                temppath = java.net.URLDecoder.decode(temppath, "UTF-8");

                String osName = System.getProperty("os.name");

                if (osName.toUpperCase().contains("WINDOWS")) {
                    temppath = temppath.substring(1);
                }

                temppath = new File(temppath).getParent();
            } catch (java.io.UnsupportedEncodingException ex) {
                temppath = System.getProperty("user.dir");
            }

            ApplicationDirectory.path = temppath;
        }

        return ApplicationDirectory.path;
    }
}
