package turner_p2;
import java.util.*;

public class Application {

    public static void main(String[] args){

        DuplicateCounter duplicateCounter = new DuplicateCounter();

        if(duplicateCounter.count("problem2.txt")){

            duplicateCounter.write("unique_word_counts.txt");
        }

        }
}
