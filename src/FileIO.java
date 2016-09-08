import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Created by joe on 9/8/16.
 */
public class FileIO {
    public static Cat cat=new Cat();
    public static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args)throws Exception{
        System.out.println("Thank you for visiting the Cat Cafe!" +
                "\nPlease answer a short survey about your experience.");

     try{
         cat=loadFile();
         System.out.println("...\nYou have already completed a survey!");
     }
     catch (Exception e){
         System.out.println("Starting new survey!");
         cat.update();
         saveFile();
     }

     FileIO.Choice();
        System.out.println("Thank you for visiting! Please come again.");
    }//end main

     public static String Choice() throws Exception {

         String selection="";
         while (!(selection.equals("4"))) {
             System.out.println("-----");
             System.out.println("Please enter your selection:");
             System.out.println("[1] View survey");
             System.out.println("[2] Update survey");
             System.out.println("[3] Save survey");
             System.out.println("[4] Return survey");

             selection = scanner.nextLine();
             switch (selection) {
                 case "1":
                     loadFile();
                     break;
                 case "2":
                     cat.update();
                     break;
                 case "3":
                     saveFile();
                     System.out.println("Your survey was saved!");
                     break;
                 case "4":
                     break;
                 default:
                     System.out.println("Please choose an option.");
                     break;
             }
         }
         return selection;
     }

    public static void saveFile()throws Exception{
        JsonSerializer s = new JsonSerializer();
        String json = s.serialize(cat);

        File f = new File("file.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static Cat loadFile()throws Exception{
        File f = new File("file.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();

        JsonParser p = new JsonParser();
        System.out.println(p.parse(contents, Cat.class));
        return p.parse(contents, Cat.class);
    }
}//EOF
