package com.kbm.java.practise.serialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Implementation class for BufferReader and BufferedWriter
 * <p>
 * WE will have to wrap FileWriter to BufferWriter to use it. BufferedWriter is
 * useful when we have multiple small write calls, as it will buffer all the
 * chunks and write in one go.
 * <p>
 * <p>
 * Although we will have to be careful about the buffer size. Same can be
 * managed from constructor argument.
 * <p>
 * 
 * @author Keyur.Mahajan
 *
 */
public class BufferedWriterReader {

	public static void main(String[] args) {

		File file = new File("Test_BufferedReader.txt");
		if (!file.exists()) {
			try {
				System.out.println("Writing to File...");
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
				bufferedWriter.write("Hi..");
				bufferedWriter.write("Testing Buffered Writer and Reader...");
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedReader bufferedReader;
			try {
				System.out.println("Reading File...");
				bufferedReader = new BufferedReader(new FileReader(file));
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
