package com.aor.g608.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
     private List<String> fileLine = new ArrayList<>();

    public void Reader(String file) {
        try {
            URL resource = getClass().getClassLoader().getResource(file);
            File object = new File(resource.toURI());
            Scanner reader = new Scanner(object);

            while (reader.hasNextLine()){
                String data = reader.nextLine();
                fileLine.add(data);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

