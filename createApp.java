// REFERENCE FOR CREATING FILES
package fileapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class createApp {
    public static void main(String[] args) {
        String pathName = "/Users/dylantan/Documents/Courses/NUS_ISS_SWE/02_SSF/src/practice/creatingFile/data";
        String fileName = "/Hello.txt";

        // creating folder path 
        File dir = new File(pathName);

        createDirectory(dir);

        // create file in folder path
        File createFile = new File(dir, fileName);

        // adding content to directory
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(createFile))) {
            writer.write("Hello NEW Content");

        } catch(IOException e) {
            e.getMessage();
        }
    }

    // method to create directory
    public static void createDirectory(File dir) {
        // creating directory with folder path
        Boolean booleanDir = dir.mkdirs();

        // checking if directory has been created
        if(booleanDir) {
            System.out.println("Directory created");
        } else {
            System.out.println("Directory not created");
        }
    }
}
