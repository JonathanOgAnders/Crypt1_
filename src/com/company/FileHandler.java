package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Anders on 01-Sep-17.
 */
public class FileHandler
{
    public void writeToFile(char[] s)
    {
        try
        {
            PrintStream output = new PrintStream(new File("wunderbar alice.txt"));
            for(char c: s)
            {
                output.print(c);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //henter text (filhåndtering)
    public char[] getTxtFile()
    {
        char[] chars = new char[0];
        String stringToCrypt = "";
        try
        {
            Scanner input = new Scanner(new File("AliceInWonderland.txt"));

            while(input.hasNext())
            {
                stringToCrypt += input.next();
            }
            chars = stringToCrypt.toCharArray();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return chars;
    }

    public char[] getStringFromFile()
    {
        String text = "";
        char[] charArray = text.toCharArray();

        try
        {
            Scanner input = new Scanner(new File("AliceInWonderland.txt"));

            while(input.hasNextLine())
            {
                text += input.nextLine();
            }

            charArray = text.toCharArray();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return charArray;
    }
}
