package garethflowers.retagit;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * @author Gareth Flowers
 */
public class ApplicationDirectory {

    private static String path = null;

    private ApplicationDirectory() {
    }

    public static String getPath() {
        if (ApplicationDirectory.path == null) {
            String temppath;
            try {
                temppath = URLDecoder.decode(ApplicationDirectory.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");

                String osName = System.getProperty("os.name");

                if (osName.toLowerCase().contains("windows")) {
                    temppath = temppath.substring(1);
                }

                temppath = new File(temppath).getParent();
            } catch (UnsupportedEncodingException ex) {
                temppath = System.getProperty("user.dir");
            }

            ApplicationDirectory.path = temppath;
        }

        return ApplicationDirectory.path;
    }
}
