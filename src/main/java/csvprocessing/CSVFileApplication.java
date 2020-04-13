package csvprocessing;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CSVFileApplication {
    static final String INPUT_FILE = "data.csv";
    static final String RESULT_FILE = "result.csv";

    //private static final String directoryPath = "D:\\Java\\JavaTraining\\";
    public static void main(String[] args) {
        //Path to the directory with input and output files is specified in app arguments.
        final String directoryPath = args[0];

        List<List<String>> listOfCompanyCountry;
        CSVFileProcessor csvFileProcessor = new CSVFileProcessor();
        //   System.out.println(String.valueOf(inputFilePath));
        listOfCompanyCountry = csvFileProcessor.readDataLineByLine(directoryPath, INPUT_FILE);
        // System.out.println("And now array");
        // System.out.println(listOfCompanyCountry);
        Collections.sort(listOfCompanyCountry, ((o1, o2) -> (o1.get(0)).compareTo(o2.get(0))));
        //        Collections.sort(listOfCompanyCountry, new Comparator<List<String>>() {
//            @Override
//            public int compare(List<String> o1, List<String> o2) {
//                return (o1.get(0)).compareTo(o2.get(0));
//            }
//        });
        //System.out.println("And now sorted array");
        //System.out.println(listOfCompanyCountry);

        FileDeleter.deleteFile(directoryPath, RESULT_FILE);

        CSVFileWriter.writeFile(listOfCompanyCountry, directoryPath);
    }
}
