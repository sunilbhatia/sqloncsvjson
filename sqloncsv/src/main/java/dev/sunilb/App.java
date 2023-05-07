package dev.sunilb;

import com.opencsv.exceptions.CsvValidationException;
import dev.sunilb.entities.CSVSchema;
import dev.sunilb.entities.Data;
import dev.sunilb.entities.Raw;

import java.io.*;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Data data=new Data();
    public static void main( String[] args ) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Enter Your command");
            String[] commands = input.readLine().split(" ");
            if(commands.length==0){
                System.out.println("Please enter correct command");
                continue;
            }
            String command = commands[0];
            try {
                if(command.equals("EXIT")){
                    break;
                } else if (command.equals("LOAD_FILE")) {
                    String filePath = commands[1];
                    String schemaName = commands[2];
                    File file = new File(filePath);
                    CSVSchema csvSchema=new CSVSchema(schemaName,file);
                    data.setData(schemaName,csvSchema);
                } else if (command.equals("SHOW_DATA")) {
                    String schemaName=commands[1];
                    showData(schemaName);
                }
            }catch (Exception e){
                System.out.println("Please enter correct command");
            }
        }
    }

    private static void showData(String schemaName) throws CsvValidationException, IOException {
        CSVSchema csvSchema=data.getData(schemaName);
        List<Raw> raws=csvSchema.getRaws();
        System.out.println(schemaName+" data");
        List<String> columns = csvSchema.getFieldList();
        System.out.print(columns.get(0));
        for(int i=1;i<columns.size();i++){
            System.out.print(" , "+ columns.get(i));
        }
        System.out.println();
        for (Raw raw:raws) {
            String[] values= raw.getValues();
            System.out.print(values[0]);
            for(int i=1;i<values.length;i++){
                System.out.print(" , "+values[i]);
            }
            System.out.println();
        }
    }
}
