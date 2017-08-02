package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Robin on 6/22/2017.
 */
public class Util
{
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    private static Random RANDOM = new Random();

    public static String getSplash()
    {
        String splash = "";
        String fileName = "./Resources/Text/Splashes.txt";
        try {
            int rand = RANDOM.nextInt(howManyLines(fileName)) + 1;
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            for (int i = 0 ; i < rand ; i++) splash = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: Unable to open Splashes.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return splash;
    }

    private static int howManyLines(String fileName) throws IOException
    {
        fileReader = new FileReader(fileName);
        bufferedReader = new BufferedReader(fileReader);
        int howMany = 0;
        while(bufferedReader.readLine() != null) howMany++;
        bufferedReader.close();
        fileReader.close();
        return howMany;
    }
}
