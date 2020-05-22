package Data;


import java.io.*;
import java.util.*;

public class DataBase {
    private static File file;
    public static HashSet<Person> base = new HashSet<Person>();
    public static ArrayList<String> scriptsNames = new ArrayList<>();
    public static ArrayList<Integer> id = new ArrayList<Integer>();
    public static Queue<String> history = new LinkedList<String>();
    private static File idFile;
    public static File getFile(){
        return file;
    }
    public static File getIdFile(){return idFile;}
    public static void addToHistory(String command){
        if(history.size() == 10){
            history.poll();
            history.add(command);
        }
        else{
            history.add(command);
        }
    }
    public static void changeFileName(String s){
        file = new File(s);
        idFile = new File(file.getParent() + "/id.csv");
        try {
            FileReader fr = new FileReader(idFile);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] str = line.split(";");
            for(String string: str){
                id.add(Integer.valueOf(string));
            }
        }
        catch (IOException e){
            System.out.println("За что ты так меня?");
        }

    }

}