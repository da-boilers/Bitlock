package com.helloworld.passport.UserMGT;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
public class User
{
    private String uN = "";
    private String pwd = "";
    //private String fileName = "userinfo.txt";
    //private String filename = "SampleFile.txt";
    //private String filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/instinctcoder/readwrite/";
    private String line = null;



    public boolean checkInfo(String uN, String pwd, Context context)
    {
        boolean matches = false;

        try
        {
            File root = android.os.Environment.getExternalStorageDirectory();

            // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder

            File dir = new File (root.getAbsolutePath() + "/download");
            File file = new File(dir, "myData.txt");

            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(file));
            ArrayList<String> vals = new ArrayList<String>(2);
            while((line = bufferedReader.readLine()) != null) {
                vals.add(line);
            }
            Log.e("User", vals.get(0));
            Log.e("User", vals.get(1));
            if (vals.get(0).equals(uN) && vals.get(1).equals(pwd))
            {
                matches = true;
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            Log.e("User", ex.toString());
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return matches;
    }

    public void writeInfo() {
        // Find the root of the external storage.
    // See http://developer.android.com/guide/topics/data/data-  storage.html#filesExternal

    File root = android.os.Environment.getExternalStorageDirectory();

    // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder

    File dir = new File (root.getAbsolutePath() + "/download");
    dir.mkdirs();
    File file = new File(dir, "myData.txt");

    try {
        FileOutputStream f = new FileOutputStream(file);
        PrintWriter pw = new PrintWriter(f);
        pw.println("Admin");
        pw.println(".");
        Log.e("User", "File created");
        pw.flush();
        pw.close();
        f.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        Log.e("User", "******* File not found. Did you" +
                " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
    } catch (IOException e) {
        e.printStackTrace();
    }
   }

}