package com.company;

import java.util.*;

/**
 * Created by Anders on 01-Sep-17.
 */
public class TotalRandomKey
{
    private Map<Character, Character> cryptedAlphabetMap = new HashMap<>();
    private Map<Character, Character> decryptedAlphabetMap = new HashMap<>();
    private ArrayList<Character> characters = new ArrayList<>();
    private ArrayList<Character> charactersShuffled = new ArrayList<>();

    public TotalRandomKey(){}

    //Alle characters på nær æøå tilføjes.
    public void fillCharacterList()
    {
        for (char c = ' '; c <= '~'; c++)
        {
            characters.add(c);
            charactersShuffled.add(c);
        }
        Collections.shuffle(charactersShuffled);
    }

    //map for at dekryptere og map for at kryptere generes på baggrund af shuffled arraylist.
    public void generateMaps()
    {
        for (int i = 0; i < characters.size(); i++)
        {
            cryptedAlphabetMap.put(characters.get(i), charactersShuffled.get(i));
            decryptedAlphabetMap.put(charactersShuffled.get(i), characters.get(i));
        }
    }

    //besked krypteres
    public String cryptMessage(String s)
    {
        String krypt = "";
        for(char c: s.toCharArray())
        {
            krypt += cryptedAlphabetMap.get(c);
        }
        return krypt;
    }

    //besked dekrypteres
    public String deCryptMessage(String s)
    {
        String dekrypt = "";
        for(char c: s.toCharArray())
        {
            dekrypt += decryptedAlphabetMap.get(c);
        }
        return dekrypt;
    }

}
