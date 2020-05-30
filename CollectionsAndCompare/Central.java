import java.io.*;
import java.util.*;

public class Central {
    public static void read(String path) {
        try {
            File myObj = new File("contacts.txt");
            Scanner myReader = new Scanner(myObj);

            ArrayList<Contact> data = new ArrayList<>();
            TreeSet<Contact> treeSet = new TreeSet<>();
            TreeSet<Contact> treeSetLNC = new TreeSet<>(new LastNameComparator());
            HashSet<Contact> hashSet = new HashSet<>();
            ArrayList<Contact> dataForLastName = new ArrayList<>();
            HashMap<String, Contact> hashMap = new HashMap<>();

            // READING FILE LINE BY LINE AND GIVING DATA TO COLLECTIONS THEM
            while (myReader.hasNextLine()) {
                ArrayList<String> subData = new ArrayList<>(Arrays.asList(myReader.nextLine().split(" ")));
                Contact contact = new Contact(subData.get(0), subData.get(1), subData.get(2), subData.get(3));
                data.add(contact);
                treeSet.add(contact);
                treeSetLNC.add(contact);
                hashSet.add(contact);
                dataForLastName.add(contact);
                hashMap.put(subData.get(0), contact);
            }
            myReader.close();

            Collections.sort(dataForLastName,new LastNameComparator());
            write("contactsArrayList.txt",data);
            write("contactsArrayListOrderByLastName.txt",dataForLastName);
            write("contactsHashSet.txt",hashSet);
            write("contactsTreeSet.txt",treeSet);
            write("contactsTreeSetOrderByLastName.txt",treeSetLNC);
            write("contactsHashMap.txt",hashMap);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // WRITING METHOD FOR ARRAYLIST
    public static void write(String dosya, ArrayList<Contact> a) throws IOException {
        File arrayListFile = new File(dosya);
        FileOutputStream fo = new FileOutputStream(arrayListFile);
        PrintWriter pw = new PrintWriter(fo);
        for (Object c : a){
            pw.println(c);
        }
        pw.close();
        fo.close();
    }

    // WRITING METHOD FOR TREESET
    public static void write(String dosya, TreeSet<Contact> ts) throws IOException {
        File arrayListFile = new File(dosya);
        FileOutputStream fo = new FileOutputStream(arrayListFile);
        PrintWriter pw = new PrintWriter(fo);
        for (Object c : ts){
            pw.println(c);
        }
        pw.close();
        fo.close();
    }

    // WRITING METHOD FOR HASHSET
    public static void write(String dosya, HashSet<Contact> hs) throws IOException {
        File arrayListFile = new File(dosya);
        FileOutputStream fo = new FileOutputStream(arrayListFile);
        PrintWriter pw = new PrintWriter(fo);
        for (Object c : hs){
            pw.println(c);
        }
        pw.close();
        fo.close();
    }

    // WRITING METHOD FOR HASHMAP
    public static void write(String dosya, HashMap<String,Contact> hm) throws IOException {
        File arrayListFile = new File(dosya);
        FileOutputStream fo = new FileOutputStream(arrayListFile);
        PrintWriter pw = new PrintWriter(fo);
        for (Object c : hm.values()){
            pw.println(c);
        }
        pw.close();
        fo.close();
    }
}
