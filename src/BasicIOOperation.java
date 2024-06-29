import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BasicIOOperation {
    public static void main(String[] args) {
        File inputFile;
        PrintWriter outputFile;
        double total = 0.0;
        try(Scanner scanner = new Scanner(new File("res\\input.txt"))) {
            outputFile = new PrintWriter("output.txt");

            while(scanner.hasNextDouble()){
                double value = scanner.nextDouble();
                System.out.printf("%15.2f%n", value);
                outputFile.printf("%15.2f%n", value);
                total = total + value;
            }
            System.out.printf("Total: %8.2f%n", total);
            outputFile.printf("Total: %8.2f%n", total);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
//            scanner.close();
//            outputFile.close();
        }

    }
}
