package csvprocessing;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static csvprocessing.CSVFileApplication.INPUT_FILE;
import static csvprocessing.CSVFileApplication.RESULT_FILE;
import static csvprocessing.CSVFileProcessor.countryCompanies;

public class CSVFileWriter {

    public static void writeFile(String directoryPath) {
        String fileToCreate = String.valueOf(Paths.get(directoryPath + RESULT_FILE));
        File file = new File(fileToCreate);
        FileWriter outputfile = null;
        try {
            //create FileWriter object with file as parameter
            outputfile = new FileWriter(file);
            // create CSVWriter object filewriter object as parameter

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (Map.Entry<Country, TreeSet<String>>
                entry : countryCompanies.entrySet()) {
            Country country = entry.getKey();
            System.out.println(country + "" + entry.getValue());
        }

        CSVWriter writer = new CSVWriter(outputfile);
        for (Map.Entry<Country, TreeSet<String>>
                entry : countryCompanies.entrySet()) {
            Country country = entry.getKey();
            for (String company : entry.getValue()) {
                String[] data = new String[2];
                data[0] = String.valueOf(country);
                data[1] = company;
                writer.writeNext(data);
                System.out.println(data[0] + data[1]);
//
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
