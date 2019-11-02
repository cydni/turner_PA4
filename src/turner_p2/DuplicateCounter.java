package turner_p2;


import java.io.*;
import java.util.*;

public class DuplicateCounter {

    //instance variable called wordCounter
    HashMap<String, Integer> wordCounter;

    public DuplicateCounter(){

        wordCounter = new HashMap<String, Integer>();
    }

    public boolean count(String dataFile){

        try{

            //Make dataFile the input stream instead of the user
            Scanner inFS = new Scanner(new File(dataFile));
            String word;

            while(inFS.hasNext()) {

            word = inFS.next();

            if (!wordCounter.containsKey(word)) //use putIfAbsent()?
                wordCounter.put(word, 1);
            else
                wordCounter.put(word, wordCounter.get(word) + 1);

            }

            //inFS.close();
            return true;

        }
        catch(IOException exc){

            wordCounter.clear();
            System.out.println(exc.toString());
            return false;
        }
    }

    public void write(String outputFile){

        //FIX ME: DELETE IF NOT NEEDED -- PrintStream ps = new PrintStream( outputFile );

        try{

            //truncate file (if it already exists) before writing
            FileWriter fw = new FileWriter(outputFile, false);

            //how to iterate through a hash map
            wordCounter.forEach((k,v)->{

                try {
                            fw.write(k + " = " + v + "\n");
                } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
            );

            fw.close();

        }
        catch(IOException exc){

            wordCounter.clear();
            System.out.println(exc.toString());

        }

        }

    }

