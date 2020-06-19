package DatenhaltungsSchicht;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializierung implements IDAO{

    @Override
    public List<Medium> laden(){

        ArrayList<Medium> list = new ArrayList<>();
        final File f = new File("/home/mrmeep/IdeaProjects/Medien.ser");
        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            //noinspection unchecked
            list = (ArrayList<Medium>) ois.readObject();
            Medium.cntr = list.size();
        } catch (IOException | ClassNotFoundException e) {

            e.getStackTrace();
            System.out.println(e.toString());
            System.out.println("Error deserializing");
        }

        return list;
    }

    @Override
    public void speichern(List<Medium> list) {

        final File f = new File("/home/mrmeep/IdeaProjects/Medien.ser");
        try (FileOutputStream fos = new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(list);
            System.out.println(f.isFile());
        } catch (IOException e) {

            System.out.println("Error serializing");
        }
    }
}
