package csvprocessing;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVFileProcessor {

    public CSVFileProcessor() {
    }

    public List<List<String>> readDataLineByLine(String directoryPath, String INPUT_FILE) {
        String inputFilePath = directoryPath + "\\" + INPUT_FILE;
        List<List<String>> listofCompanyCountry = new ArrayList<List<String>>();
        try {
            //FileReader filereader = new FileReader(inputFilePath);
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();
            String[] nextRecord = new String[0];

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.print(nextRecord[8] + "\t");
                System.out.print(nextRecord[0] + "\t");
                System.out.println();
                listofCompanyCountry.add(new ArrayList<String>(Arrays.asList(nextRecord[8], nextRecord[0])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listofCompanyCountry;
    }
}


