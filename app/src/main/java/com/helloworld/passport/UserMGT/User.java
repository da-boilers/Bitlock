import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
public class User
{
    private String uN = "";
    private String pwd = "";
    private String fileName = "UserInfo.txt";
    private String line = null;



    public boolean checkInfo(String uN, String pwd)
    {
        boolean matches = false;

        try
        {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            ArrayList<String> vals = new ArrayList<String>(2);
            while((line = bufferedReader.readLine()) != null) {
                vals.add(line);
            }

            if (vals.get(0).equals(uN) && vals.get(1).equals(pwd))
            {
                matches = true;
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return matches;
    }


    public void writeInfo(String uN, String pwd)
    {
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            bufferedWriter.write(uN);
            bufferedWriter.newLine();
            bufferedWriter.write(pwd);
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '" + fileName + "'");
        }
    }
}