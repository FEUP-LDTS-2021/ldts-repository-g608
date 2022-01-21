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

    public FileReader(String file) throws FileNotFoundException {
        List<String> fileLine = new ArrayList<>();
        File file1 = new File(file);
        Scanner reader = new Scanner(file1);

        while(reader.hasNext()){
            fileLine.add(reader.nextLine());
        }

        reader.close();

        this.fileLine = fileLine;

    }

    public List<String> getMap() {
        return fileLine;
    }
}

