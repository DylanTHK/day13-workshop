package com.day13_Workshop.addressBook.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

// static class for methods
public class IOUtils {
    
    public static void createDirectory(String pathName) {
        System.out.println("createDirectory initialised");
        // create path object
        File dir = new File(pathName);
			
        // create folder with path
        Boolean isDirCreated = dir.mkdirs();

        if (isDirCreated) {
            String osName = System.getProperty("os.name");
            System.out.println("OS Name: " + osName);

            // setting permission for created directory (OS and Linux)
            if (!osName.contains("Windows")) {
                try {
                    String perm = "rwxrwx---";
                    Set<PosixFilePermission> permissions = 
                            PosixFilePermissions.fromString(perm);
                    Files.setPosixFilePermissions(dir.toPath(), permissions);
                    System.out.printf("Permission for %s set", pathName);
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
    }
}
