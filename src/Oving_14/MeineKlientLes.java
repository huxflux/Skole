package Oving_14;

import java.io.*;
import java.util.*;

public class MeineKlientLes{

    public static void main(String[] args) throws IOException{

        FileInputStream fil = new FileInputStream("c:\\coding\\tribune.ser");
        ObjectInputStream input = new ObjectInputStream(fil);
        Tribune[] tribune = new Tribune[4];

        try {
            for(int i = 0; i < tribune.length; i++) {
                tribune[i] = (Tribune) input.readObject();
            }

            } catch(ClassNotFoundException e){
                System.out.println("EHMMMMmmmmmmm \n" + e);
            }
            finally {
                input.close();
                fil.close();
            }

            for (int i = 0; i < tribune.length; i++) {
                System.out.println(tribune[i]);
            }
        }
    }