import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class InputDemo1 {

    public static void main(String[] args) {

        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            
            double number = Double.parseDouble(input);
            
            System.out.println("Square root of input number " + input + " is: " + Math.sqrt(number));
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Input by user was not a number.");
            e.printStackTrace();
        }
    }
}

