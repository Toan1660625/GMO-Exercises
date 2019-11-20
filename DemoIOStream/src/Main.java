import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

//-----------------Tao file, folder, get path --------------------
		boolean isCreat = false;
		try { 
			  
            // Create a foder object
			File dir = new File("D:\\GMO SYSTEM\\Exercise\\JavaCode\\DemoIOStream\\IO");
            if (dir.mkdir()) {
            	System.out.println("Create directory " + dir.getAbsolutePath() + " success.");
            }
            File file = new File("IO\\IOStream.txt");
            isCreat = file.createNewFile();
            // Get the path of the given file f 
            String path = dir.getAbsolutePath(); 
            String path1 = file.getAbsolutePath(); 
            String path2 = file.getCanonicalPath();      // Như nhau
            // Display the file path of the file object
            System.out.println("File path : " + dir); 
            System.out.println("File path : " + path1); 
            System.out.println("File path : " + path2);
            
            dir.delete();
            //file.delete();
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 

		
//---------------   FileOutputStream     FileInputStream------------------  
		// Lưu data xuống file .txt
		FileOutputStream fout = null;     
        try {
            fout = new FileOutputStream("D:\\testout.txt");
            String s = "Welcome to java.";
            byte b[] = s.getBytes();// converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            fout.close();
        }
        
        //Lấy data tại file .txt và xuất ra
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("D:\\testout.txt");
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            fin.close();
        }
//---------------   BufferedOutputStream    BufferedInputStream------------------  
		FileOutputStream fout2 = null;
        BufferedOutputStream bout = null;
        try {
            fout2 = new FileOutputStream("D:\\testout2.txt");
            bout = new BufferedOutputStream(fout2);
            String s = "Welcome to java.";
            byte b[] = s.getBytes();
            bout.write(b);
            bout.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            bout.close();
            fout2.close();
        }
        
        FileInputStream fin2 = null;
        BufferedInputStream bin = null;
 
        try {
            fin2 = new FileInputStream("D:\\testout2.txt");
            bin = new BufferedInputStream(fin2);
            int i;
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            bin.close();
            fin2.close();
        }
	}

}
