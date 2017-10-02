package com.company;

public class Main {

    public static void main(String[] args) {

        //TOTAL RANDOM KRYPTERING.

//	    TotalRandomKey totalRandomKey = new TotalRandomKey();
//	    totalRandomKey.fillCharacterList();
//        totalRandomKey.generateMaps();
//
//        String s = "What up? How's it hanging? Look what I can write []{!?'topsecretmessage^";
//        System.out.println("Message to be crypted:\n" + s + "\n");
//        String enc = totalRandomKey.cryptMessage(s);
//        System.out.println("Crypted:\n" + enc + "\n");
//        System.out.println("Decrypted:\n" + totalRandomKey.deCryptMessage(enc) + "\n");

        ShiftedKey shiftedKey = new ShiftedKey();
        FileHandler fileHandler = new FileHandler();

        //Laver en liste med de char jeg vil krypterer
        shiftedKey.fillCharacterList();

        //Laver en anden liste som er forskudt en tilfældig længde
        shiftedKey.splitList(shiftedKey.generateShiftByKey());

        //Laver 2 maps som er hinandens spejlinger. En bruges til at kryptere. En anden til at dekryptere.
        shiftedKey.generateMaps();

        //Laver et chararray med hele aliceinwonderland
        char[] cryptedAliceArray = fileHandler.getStringFromFile();

        String cryptedAliceString = shiftedKey.cryptMessage(cryptedAliceArray);

        String deCryptedAliceString = shiftedKey.deCryptMessage(cryptedAliceString);

        System.out.println(shiftedKey.findRandomizedKey());
    }
}
