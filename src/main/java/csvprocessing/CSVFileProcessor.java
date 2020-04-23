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
//    static TreeMap<Country, TreeSet<String>> countryCompanies = new TreeMap<>(new Comparator<Country>() {
//        @Override
//        public int compare(Country country, Country t1) {
//            if (country.equals(Country.NONE)) {
//                //What to return here???
//                return country.compareTo(t1);
//            } else return country.compareTo(t1);
//        }
//    });
//        @Override
//        public boolean equals(Object o) {
//            return false;
//        }


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
        return tempConvertedString.trim().toUpperCase();
    }


    private void putToCountryCompanies(String country, String company) {
        String countryToAdd = convertToUpperCaseNoSpaces(country);
        Country countryToAddEnum = Country.NONE;

//        if ((countryToAdd.equals("")) || (countryToAdd.isEmpty())) {
//            countryToAdd = "NONE";
//        }
        try {
            countryToAddEnum = Country.valueOf(countryToAdd);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Country" + countryToAdd + "could not be found, defaulting to NONE ");
            System.out.println("Countries in CSV are not in the allowed enum, Illegal Argument caught");
        }
        try {
            TreeSet<String> companiesForCurrentCountry;
            if (countryCompanies.containsKey(countryToAddEnum)) {
                companiesForCurrentCountry = countryCompanies.get(countryToAddEnum);
            } else {
                companiesForCurrentCountry = new TreeSet<String>();
            }
            //  System.out.println("country" + countryToAdd + "string country " + countryToAddString);
            System.out.println("company" + company);
            companiesForCurrentCountry.add(company);
            System.out.println("set" + companiesForCurrentCountry);
            countryCompanies.put(countryToAddEnum, companiesForCurrentCountry);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Countries in CSV are not in the allowed enum");
        }
//????Doesn't work
//        catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            System.out.println("Countries in CSV are not in the allowed enum");
//        }
//
//        catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Countries in CSV are not in the allowed enum");
//        }

    }
}



