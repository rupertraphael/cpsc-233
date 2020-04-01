import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class FileExercises {

    public int parseNonNegativeInt(String number) throws IOException {
        int integer;

        try {
            integer = Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IOException();
        }

        if (integer < 0) {
            throw new IOException();
        }

        return integer;
    }

    public boolean is3ByteRGB(String filename) {
        DataInputStream input;

        try {
            input = new DataInputStream(new FileInputStream(filename));

            int rows = input.readInt();
            int columns = input.readInt();

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    for (int position = 0; position < 3; position++) {
                        int colorValue = input.readInt();

                        if (colorValue > 255 || colorValue < 0) {
                            input.close();
                            return false;
                        }
                    }
                }
            }

            input.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public void append(int[] numbers, String filename) {
        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream(filename, true));

            for(int number : numbers) {
                output.writeInt(number);
            }

            output.close();
        } catch(Exception e) {

        }
    }

    public void encrypt(int shift, String inputFilename, String outputFilename) throws FileNotFoundException {
        BufferedReader reader;

        ArrayList<String> data = new ArrayList<String>();
        
        reader = new BufferedReader(new FileReader(inputFilename));
        
        try {
            String line = reader.readLine();

            while(line != null) {
                data.add(line);

                line = reader.readLine();
            }

            reader.close();
        } catch (Exception e) {

        }

        ArrayList<String> encrypted = new ArrayList<String>();

        for(String datum : data) {
            String encryptedLine = "";

            for(char character : datum.toCharArray()) {
                int newInt = ((int) character) + shift;

                char newChar = character;

                if(
                    !(newInt >= 'a' && newInt <= 'z') &&
                    !(newInt >= 'A' && newInt <= 'Z')
                ) {
                    if(newInt < 'A') {
                        int offset = 'A' - newInt;
    
                        newInt = 'Z' - offset;
                    }else if(newInt > 'Z') {
                        int offset = newInt - 'Z';
    
                        newInt = 'A' + offset - 1;
                    }else if(newInt < 'a') {
                        int offset = 'a' - newInt;
    
                        newInt = 'z' - offset;
                    }else if(newInt > 'z') {
                        int offset = newInt - 'z';
    
                        newInt = 'a' + offset;
                    }
                }
                
                if(
                    (character >= 'a' && character <= 'z') ||
                    (character >= 'A' && character <= 'Z')
                ) {
                    newChar = (char) newInt;
                }

                encryptedLine += Character.toString(newChar);
            }
            encrypted.add(encryptedLine);
        }

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(outputFilename));

            for(String output : encrypted) {
                writer.write(output);
                writer.write("\n");
            }

            writer.close();
        } catch(Exception e) {

        }
    }

}