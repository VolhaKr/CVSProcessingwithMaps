package csvprocessing;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVFileProcessor {
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 8;

    public CSVFileProcessor() {
    }

    public List<List<String>> readDataLineByLine(String directoryPath, String INPUT_FILE) {
        String inputFilePath = String.valueOf(Paths.get(directoryPath + INPUT_FILE));
        List<List<String>> listofCompanyCountry = new ArrayList<>();
        try {
            //FileReader filereader = new FileReader(inputFilePath);
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();
            String[] nextRecord = new String[0];

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.print(nextRecord[COUNTRY_COLUMN] + "\t");
                System.out.print(nextRecord[COMPANY_COLUMN] + "\t");
                System.out.println();
                listofCompanyCountry.add(Arrays.asList(nextRecord[COUNTRY_COLUMN], nextRecord[COMPANY_COLUMN]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listofCompanyCountry;
    }
}


