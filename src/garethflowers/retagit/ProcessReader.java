package garethflowers.retagit;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/**
 * ProcessReader
 */
public class ProcessReader extends Thread {

    private InputStream is;
    private Collection<String> result;

    public ProcessReader(InputStream is) {
        this.is = is;
        this.result = new ArrayList<String>();
    }

    @Override
    public void run() {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line = null;

        try {
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    public String[] GetResult() {
        try {
            return result.toArray(new String[0]);
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            return new String[0];
        }
    }
}
