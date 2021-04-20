import com.github.javafaker.Faker;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileWriter {
    public void writeToFile(ArrayList<Person> arrayList) {

        File file = new File("peopleDataEditor.csv");

        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(String.valueOf(file)));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Last Name", "Date", "Race", "Phone Number", "Email"))
        ) {

            arrayList.forEach(each -> {
                try {
                    csvPrinter.printRecord(each.getID(), each.getName(), each.getSurname(), each.getDate(), each.getRace(), each.getPhoneNumber(), each.getEmail());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            csvPrinter.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}