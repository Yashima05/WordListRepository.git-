package ReadList;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadList {
    public static void main(String[] args) {
        System.setProperty("console.encoding","utf-8");
        ReadList.startup();

        }
    public static void reader() {
        try {
            File listWord = new File("WordList.txt");
            FileInputStream fis=new FileInputStream(listWord);
            ObjectInputStream ois=new ObjectInputStream(fis);
            HashMap<Integer, String> keyAndWord = (HashMap<Integer, String>)ois.readObject();
            for(Map.Entry entry: keyAndWord.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
            ReadList.startup();
        } catch(Exception e) {
            System.out.println();
        }
    }

    public static void writer () {
        HashMap<Integer, String> keyAndWord = new HashMap<>();
        File listWord = new File("WordList.txt");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слово");
        String word = in.nextLine();
        System.out.println("Введите ключ");
        int key = in.nextInt();
        keyAndWord.put(key,word );
        try{
            FileOutputStream outMap = new FileOutputStream(listWord, true);
            ObjectOutputStream outObj = new ObjectOutputStream(outMap);
            outObj.writeObject(keyAndWord);
            outObj.close();
            outMap.close();
            System.out.println("Теперь содержимое словаря");
            for(Map.Entry<Integer,String> m :keyAndWord.entrySet()) {
                System.out.println(m.getKey() + " : " + m.getValue());
            }
            ReadList.startup();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void startup(){
        System.out.println("Доступные действия:'1' - дополнить словать,'2' - показать содержимое словаря, ");
        System.out.println("'4' - удалить запись");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите действие: ");
        int choice = in.nextInt();
        if (choice == 2){
            System.out.println("Содержимое словаря: ");
            ReadList.reader();
        }
        if (choice == 1){
            ReadList.writer();

        }
        if (choice == 4){
            System.out.println("Введите ключ строки, которую хотите удалить");

        }
    }
}
