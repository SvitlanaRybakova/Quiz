package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class that is responsible for reading files (questions and answers) from a file
 */

public class FileUtils {

    /**
     * The function is responsible for reading information from a file
     *
     * @param fileName (file name to read)
     * @return allLines (returns an array of questions and answers with the String type)
     */
    public static String[] readAllLines( String fileName ) {

        String[] allLines = null;
        try {
            Path filePath = Paths.get(fileName);
            allLines = Files.readAllLines(filePath).toArray(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allLines;
    }
}
