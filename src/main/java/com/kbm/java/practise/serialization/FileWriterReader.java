package com.kbm.java.practise.serialization;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Implementation class for FleWriter and FileReader
 * <p>
 * FileWrier is used to write string to text file directly, instead of chaining
 * of stream. Because it is handled internally.
 * <p>
 * <p>
 * Similarly FileReader can be used to read the file.
 * <p>
 * 
 * @author Keyur.Mahajan
 *
 */
public class FileWriterReader {

	public static void main(String[] args) {

		File file = new File("Testing.txt");

		if (!file.exists()) {
			FileWriter writer;
			try {
				System.out.println("Creating File...");
				writer = new FileWriter(file);
				writer.write("Hi...\n");
				writer.write("This is Testing of File Writer..");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				System.out.println("Reading File...");
				FileReader reader = new FileReader(file);
				int content = -1;
				StringBuilder builder = new StringBuilder();
				while ((content = reader.read()) != -1) {
					builder.append((char) content);
				}
				System.out.println(builder.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
