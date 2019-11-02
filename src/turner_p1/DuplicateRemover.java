package turner_p1;

import java.io.*;
import java.util.*;

public class DuplicateRemover {

    HashSet<String> uniqueWords;

    public DuplicateRemover(){

        //Use a set of strings to eliminate duplicate words from dataFile
        uniqueWords = new HashSet<String>();


    }

    public boolean remove(String dataFile){

        try {

            //Make dataFile the input stream instead of the user
            Scanner inFS = new Scanner(new File(dataFile));


            //Read in from inFS
            while(inFS.hasNext()) {

                uniqueWords.add(inFS.next());
            }


            inFS.close();
            return true;

        }
        catch(IOException exc){

            uniqueWords.clear();
            System.out.println(exc.toString());
            return false;
        }

    }

    public void write(String outputFile){

        try {
            //truncate file (if it already exists) before writing
            FileWriter fw = new FileWriter(outputFile, false);

            //for each loop to iterate through set and write to output file
            /*for(String word: uniqueWords){

                fw.write(word + "\n");
            }*/

            //Use iterator instead to avoid extra new line

            Iterator itr = uniqueWords.iterator();
            while(itr.hasNext()){

                fw.write((String)itr.next());
                if(itr.hasNext()){

                    fw.write("\n");
                }
            }

            fw.close();
        }
        catch (IOException exc){

            uniqueWords.clear();
            System.out.println(exc.toString());
        }

    }
}
