package co.com.nifi.tasks;

import java.io.File;

import static co.com.nifi.utils.Constants.FILE_PATH;

public class GenerateFileCSV {

    public static boolean fileCreated() {
        File file = new File(FILE_PATH);
        System.out.println("Ruta del archivo en: " + FILE_PATH);
        return file.exists();
    }
}
