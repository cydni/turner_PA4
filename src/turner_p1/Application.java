package turner_p1;

import java.util.*;

public class Application {

    public static void main(String[] args){

        DuplicateRemover duplicateRemover = new DuplicateRemover();

        if(duplicateRemover.remove("problem1.txt")){

            duplicateRemover.write("unique_words.txt");

        }
    }
}
