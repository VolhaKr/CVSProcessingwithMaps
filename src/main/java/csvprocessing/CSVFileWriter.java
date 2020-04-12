package csvprocessing;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter {

    public void writeFile(List<List<String>> listofCompanyCountry, String directory) {
        String fileToCreate = directory + "\\result.csv";
        //System.out.println(fileToCreate);

        // first create file object for file placed at location
        // specified by filepath
        File file = new File(fileToCreate);
        try {
            //create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);
            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);
            // adding header to csv
            String[] header = {"Country", "Company"};
            writer.writeNext(header);
            for (int i = 0; i < listofCompanyCountry.size(); i++) {
                // add data to csv
                String[] data = new String[2];
                data[0] = listofCompanyCountry.get(i).get(0);
                data[1] = listofCompanyCountry.get(i).get(1);
                writer.writeNext(data);
                System.out.println(data[0] + data[1]);
            }
            //closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}