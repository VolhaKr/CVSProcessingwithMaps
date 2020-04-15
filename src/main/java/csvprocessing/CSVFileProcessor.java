package csvprocessing;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.*;


public class CSVFileProcessor {
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 8;
    static TreeMap<Country, TreeSet<String>> countryCompanies = new TreeMap<>();

    public CSVFileProcessor() {
    }

    public void readDataLineByLine(String directoryPath, String INPUT_FILE) {
        String inputFilePath = String.valueOf(Paths.get(directoryPath + INPUT_FILE));

        try {
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();
            String[] nextRecord = new String[0];

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.print(nextRecord[COUNTRY_COLUMN] + "\t");
                System.out.print(nextRecord[COMPANY_COLUMN] + "\t");
                System.out.println();
                putToCountryCompanies(nextRecord[COUNTRY_COLUMN], nextRecord[COMPANY_COLUMN]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertToUpperCaseNoSpaces(String country) {
        String tempConvertedString = country.replaceAll("\\s+", "_");
        String convertedString = tempConvertedString.trim().toUpperCase();
        return convertedString;
    }

    private void putToCountryCompanies(String country, String company) {
        String countryToAdd = convertToUpperCaseNoSpaces(country);
        try {
            if ((countryToAdd.equals("")) || (countryToAdd.isEmpty())) {
                countryToAdd = "NONE";
            }
            Country countryToAddEnum = Country.valueOf(countryToAdd);
            TreeSet<String> tempCompanies;
            if (countryCompanies.containsKey(countryToAddEnum)) {
                tempCompanies = countryCompanies.get(countryToAddEnum);
            } else {
                tempCompanies = new TreeSet<String>();
            }
              //  System.out.println("country" + countryToAdd + "string country " + countryToAddString);
               // System.out.println("company" + company);
                tempCompanies.add(company);
               // System.out.println("set" + tempCompanies);
                countryCompanies.put(countryToAddEnum, tempCompanies);
        }
//????Doesn't work
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Countries in CSV are not in the allowed enum");
        }
    }
}


