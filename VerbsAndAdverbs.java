import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file
import java.io.FileWriter;//used to save file

public class VerbsAndAdverbs {
  public static ArrayList<String> verbs;
  public static ArrayList<String> adverbs;

  public static ArrayList<String> readFile(String file) {
    ArrayList<String> info = new ArrayList<String>();

    try {
      Scanner fileReader = new Scanner(new File(file));
      while (fileReader.hasNext())
        info.add(fileReader.next());
      fileReader.close();
    } catch (IOException e) {
      System.out.println("Something's wrong with the file.");
    } // ends catch file errors

    return info;
  }

  private static void setUpLists() {
    verbs = readFile("Word Bank/verbs.txt");
  }// ends setUpLists method

  public static String conjugateVerb(String v, int tense) {
    v = v.toLowerCase();
    String result = v.substring(0, v.length() - 1);
    if (v.substring(v.length() - 1).equals("y") && (!v.equals("convey")))
      result += "ies";
    else {
      result += v.substring(v.length() - 1);
      if (v.substring(v.length() - 1).equals("s")) {
        result += "es";
      } else if (v.substring(v.length() - 1).equals("h")) {
        result += "es";
      } else
        result += "s";
    } // ends else
      // ADVERBS and any other words that need to follow the verb (ex. "at" for the
      // verb "looked at") WILL GO HERE
    if (v.equals("frown"))
      result += " at";
    if (v.equals("speak") || v.equals("respond"))
      result += " to";
    // add "account for", but also fix the thing in the sentence generator that
    // checks for a two letter word.
    return result;
  }// returns complete, conjugated verb

  public static void main(String[] args) {
    setUpLists();
  }

}