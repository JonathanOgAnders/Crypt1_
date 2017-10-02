package com.company;

import java.util.*;

/**
 * Created by Anders on 01-Sep-17.
 */
public class ShiftedKey
{
    private Map<Character, Character> cryptedAlphabetMap = new HashMap<>();
    private Map<Character, Character> decryptedAlphabetMap = new HashMap<>();
    private ArrayList<Character> characters = new ArrayList<>();
    private ArrayList<Character> charactersShifted = new ArrayList<>();

    //Lav et array af chars (fra ' ' til '~')
    public void fillCharacterList()
    {
        for (char c = ' '; c <= '~'; c++)
        {
            characters.add(c);
        }
    }

    //Få et random tal mellem 1-array.length(inkl)
    public int generateShiftByKey()
    {
        Random r = new Random();
        int i = r.nextInt(characters.size()-1);
        return i;
    }

    //split char array på index svarende til random tal (sublist)
    //concatenate de to nye arrays i omvendt rækkefølge
    public void splitList(int i)
    {
        ArrayList<Character> firstPart = new ArrayList<>(characters.subList(characters.size()-i, characters.size()));
        ArrayList<Character> lastPart = new ArrayList<>(characters.subList(0, characters.size()-i));

        firstPart.addAll(lastPart);
        charactersShifted = firstPart;
    }

    //generer hashmap (både crypt og decrypt)
    public void generateMaps()
    {
        for (int i = 0; i < characters.size(); i++)
        {
            cryptedAlphabetMap.put(characters.get(i), charactersShifted.get(i));
            decryptedAlphabetMap.put(charactersShifted.get(i), characters.get(i));
        }
    }

    //Krypterer string fra txt fil
    public String cryptMessage(char[] s)
    {
        String krypt = "";
        for(char c: s)
        {
            krypt += cryptedAlphabetMap.get(c);
        }
        return krypt;
    }

    public String deCryptMessage(String messageToBeCrypted)
    {
        String tempString = "";
        char[] cryptedCharArray = messageToBeCrypted.toCharArray();
        for(char c: cryptedCharArray)
        {
            tempString += c;
        }
        return tempString;
    }

    public int findRandomizedKey()
    {
        char a = characters.get(0);
        int b = charactersShifted.indexOf(a);

        return b;
    }
}
