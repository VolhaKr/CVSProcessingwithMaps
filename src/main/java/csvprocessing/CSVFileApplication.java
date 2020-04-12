package csvprocessing;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CSVFileApplication {
    public static void main(String[] args) {
        final String INPUT_FILE = "data.csv";
        final String RESULT_FILE = "result.csv";
        final String directoryPath = "D:\\Java\\JavaTraining";
        List<List<String>> listofCompanyCountry;

        CSVFileProcessor csvFileProcessor = new CSVFileProcessor();
        listofCompanyCountry = csvFileProcessor.readDataLineByLine(directoryPath, INPUT_FILE);
        // System.out.println("And now array");
        // System.out.println(listofCompanyCountry);

        Collections.sort(listofCompanyCountry, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return (o1.get(0)).compareTo(o2.get(0));
            }
        });
        //System.out.println("And now sorted array");
        //System.out.println(listofCompanyCountry);

        FileDeletion outputFileDeletion = new FileDeletion();
        outputFileDeletion.deleteFile(directoryPath, RESULT_FILE);

        CSVFileWriter csvFileWriter = new CSVFileWriter();
        csvFileWriter.writeFile(listofCompanyCountry, directoryPath);
    }
}
