package dev.jee6demo.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Files {
	public static void main(String[] args) {
		entireFileExample();
		splitFileExample();
	}
	public static void entireFileExample(){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("");
			fos=new FileOutputStream("");
			byte[] buffer=new byte[102400];//100kb
			int n_bytes; 
			while((n_bytes=fis.read(buffer))>0){
				fos.write(buffer,0,n_bytes);
			}
			fos.flush();
		} catch (Exception e) {//IOException e,FileNotFoundException e
			System.err.print("Error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try{if(fis!=null)fis.close();}catch(Exception ex){};
			try{if(fos!=null)fos.close();}catch(Exception ex){};
		}
	}
	
	public static void splitFileExample(){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("");
			fos=new FileOutputStream("");
			copyAndCloseStream(fis,fos);
		} catch (Exception e) {//IOException e,FileNotFoundException e
			System.err.print("Error:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void copyAndCloseStream(InputStream is,OutputStream os) throws IOException{
		try {
			byte[] buffer=new byte[102400];//100kb
			int n_bytes; 
			while((n_bytes=is.read(buffer))>0){
				os.write(buffer,0,n_bytes);
			}
			os.flush();
		} catch (IOException e) {
			System.err.print("Error:"+e.getMessage());
			//e.printStackTrace();
			throw e;
		}finally{
			try{if(is!=null)is.close();}catch(Exception ex){};
			try{if(is!=null)os.close();}catch(Exception ex){};
		}
	}
}