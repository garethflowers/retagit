package garethflowers.retagit.process;

/**
 * @author Gareth Flowers
 */
public class Executer {

    private String[] result;

    public Executer() {
    }

    public void ExecCommand(String Command) {
        try {
            String[] cmd = new String[3];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = Command;

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd);

            StreamReader outputGobbler = new StreamReader(proc.getInputStream());
            outputGobbler.start();
            StreamReader errorGobbler = new StreamReader(proc.getErrorStream());
            errorGobbler.start();

            proc.waitFor();
            outputGobbler.join();
            errorGobbler.join();

            String[] output = outputGobbler.GetResult();
            String[] error = errorGobbler.GetResult();

            result = new String[output.length + error.length];
            System.arraycopy(output, 0, result, 0, output.length);
            System.arraycopy(error, 0, result, output.length, error.length);
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    public String[] GetResult() {
        return this.result;
    }
}
