package oracleAcademy;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
 

public class Main {

    public static void main(String[] args) {
   /*     System.out.println("zadej 2 jména");

Employee e = new Employee();
Employee d = new Employee();


System.out.println(e);
System.out.println(d);*/
    	try {
			Path path = Paths.get("employee.ser");
			System.out.println("Zadejte jméno:");
			Employee e = new Employee();
			serialize(e, path);
			System.out.println(deserialize(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void serialize(Employee e, Path path) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toString()));
        oos.writeObject(e);
        oos.close();
    }

    public static Object deserialize(Path path) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toString()));
        Object a = ois.readObject();
        ois.close();
        return a;
    }

}