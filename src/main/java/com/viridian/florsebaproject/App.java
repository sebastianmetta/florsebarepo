package com.viridian.florsebaproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class App {
	
	public static void main(String args[]) throws IOException {
		readWriteTest();
	}

	private static void readWriteTest() throws IOException {
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			//read and write file
			ByteBuffer buffer;
			fin = new FileInputStream( "music.rar" );
			//reading channel
			FileChannel fc = fin.getChannel();
			
			fout = new FileOutputStream( "musicCopy.rar" );
			// writing channel
			FileChannel fcOut = fout.getChannel();
			
			buffer = ByteBuffer.allocate(2048);
			while(true) {
				buffer.clear();
				if(fc.read( buffer ) == -1) {
					break;
				}
				//reset the index (position, limit and capacity)
				buffer.flip();
				fcOut.write(buffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fin != null) {
				fin.close();
			}
			if(fout != null) {
				fout.close();
			}
		}
	}

}
