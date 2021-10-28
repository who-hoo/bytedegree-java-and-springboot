package ioPractice;

import java.io.*;
import java.util.Arrays;

class ByteArrayEx3 {

	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		System.out.println(Arrays.toString(inSrc));
		
		try {
			while (input.available() > 0) {
				int len = input.read(temp);
				output.write(temp, 0, len);
				outSrc = output.toByteArray();
				System.out.println(Arrays.toString(temp));
				System.out.println(Arrays.toString(outSrc));	
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

}
