package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {
    @DataProvider(name = "correctUsers")
    public Object[][] readCorrectUsers(){
        try{
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
        catch (IOException e){
            System.out.println("CSV file not found");
            return null;
        }catch (CsvException e){
            System.out.println("File not readable");
            return null;
        }
    }
    @DataProvider(name = "wrongUsers")
    public Object[][] readWrongUsers(){
        try{
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
        catch (IOException e){
            System.out.println("CSV file not found");
            return null;
        }catch (CsvException e){
            System.out.println("File not readable");
            return null;
        }
    }
}
