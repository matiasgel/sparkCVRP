package edu.uoc.pec2.biasedCWS;

import java.io.*;

public class ObjectCloner<T>
{
    public ObjectCloner(){}
     public T deepCopy(Object oldObj)  {
         try {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
            ByteArrayOutputStream bos =
                    new ByteArrayOutputStream(); // A
            oos = new ObjectOutputStream(bos); // B
            oos.writeObject(oldObj);   // C
            oos.flush();               // D
            ByteArrayInputStream bin =
                    new ByteArrayInputStream(bos.toByteArray()); // E
             ois = new ObjectInputStream(bin);                  // F
             return (T) ois.readObject(); // G
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
        return null;
     }

}