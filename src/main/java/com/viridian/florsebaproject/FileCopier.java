package com.viridian.florsebaproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Timestamp;
import java.util.logging.Logger;

public class FileCopier {

	private static final int BLOCK_SIZE = 4096;
	
	private static final Logger log = Logger.getLogger(FileCopier.class.getName());
	
	public void doCopy() throws IOException{
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		log.info("Started (" + BLOCK_SIZE + "): " + startTime.toString());
		
		//Input
		FileInputStream fileInputStream = new FileInputStream("D:\\Oracle.rar");
		FileChannel inputChannel = fileInputStream.getChannel();

		//Output		
		FileOutputStream fileOutputStream = new FileOutputStream("D:\\Oracle copy.rar");
		FileChannel outputChannel = fileOutputStream.getChannel();
		
		ByteBuffer inputBuffer = ByteBuffer.allocate(BLOCK_SIZE);
		
		while (true) {
			
			inputBuffer.clear();
			int r = inputChannel.read(inputBuffer);
			if (r==-1) {
				break;
			}
			inputBuffer.flip();
			outputChannel.write(inputBuffer);
		}
		
		fileInputStream.close();
		fileOutputStream.close();
		
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		log.info("Finished (" + BLOCK_SIZE + "): " +endTime.toString());
	}
	
}
