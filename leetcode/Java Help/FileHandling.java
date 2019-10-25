import java.io.*;
import java.util.*;

class FileHandling{


    
    public static void main(String[] args) throws Exception{

        char A = 65;

        System.out.println(""+(A+2));

        File file = new File("file_read.txt");
        /*
        // Using Scanner
        Scanner sc = new Scanner(file);
        String line;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            System.out.println(line);
        }
        sc.close();
        */
        //using buffered reader
        // BufferedReader bf = new BufferedReader(new FileReader(file));
        // String l;
        
        // while((l = bf.readLine()) != null){
        //     System.out.println(l);
        // }
        // bf.close();

        // try-with-resources : auto close() files
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }



        // reading csv
        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = csvReader.readLine()) != null) {
            String[] data = line.split(",");
            for(String d : data){
                System.out.println(d);
            }
        }
        csvReader.close();



        //writing a csv file
        List<List<String>> rows = Arrays.asList(
            Arrays.asList("Jean", "author", "Java"),
            Arrays.asList("David", "editor", "Python"),
            Arrays.asList("Scott", "editor", "Node.js")
            );
            //write data
            FileWriter csvWriter = new FileWriter("new.csv");
            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();


    }
}