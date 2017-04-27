package com.kbm.java.practise.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to be serialized
 * 
 * @author keyur.mahajan
 *
 */
public class MySerializer implements Serializable {

	private int id;
	private String name;

	/**
	 * Creates new object with id and name
	 * 
	 * @param id
	 * @param name
	 */
	public MySerializer(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		MySerializer object = new MySerializer(1001, "KBM1");
		MySerializer object2 = new MySerializer(1002, "KBM2");
		MySerializer object3 = new MySerializer(1003, "KBM3");
		List<MySerializer> list = new ArrayList<MySerializer>();
		list.add(object);
		list.add(object2);
		list.add(object3);

		File file = new File("test");
		if (file.exists()) {
			try {
				// Retrieving Object from File
				FileInputStream inputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				MySerializer objectRead = null;
				while ((objectRead = (MySerializer) objectInputStream.readObject()) != null) {
					System.out.println("Object Found in File...");
					System.out.println("id:" + objectRead.getId() + " Name:" + objectRead.getName());

				}
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			try {
				// Saving object in to File
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
				System.out.println("Saving Object in File...");
				for (MySerializer mySerializer : list) {
					outputStream.writeObject(mySerializer);
				}
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
