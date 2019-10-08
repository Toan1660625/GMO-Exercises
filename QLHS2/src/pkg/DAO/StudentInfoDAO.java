package pkg.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import com.student.StudentInfoManage;

import pks.DTO.StudentInfo;

public class StudentInfoDAO {

	public static void Load(StudentInfoManage ListStudent) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		     File f = new File("D:\\JavaWeb\\QLHS\\student.txt");
		     FileReader fr = new FileReader(f);
		     BufferedReader br = new BufferedReader(fr);
		     String line;
		     while ((line = br.readLine()) != null){
		    	 String[] dongHS = line.split("&");
		    	 StudentInfo addHS = new StudentInfo();
		    	 addHS.setInfo_id(Integer.parseInt(dongHS[0]));
		    	 addHS.setStudent_id(Integer.parseInt(dongHS[1]));
		    	 addHS.setAddress(dongHS[2]);
		    	 addHS.setAverage_score(Double.parseDouble(dongHS[3]));
		    	 addHS.setDate_of_birth(dongHS[4]);
		    	 ListStudent.getListHS().add(addHS);

		     }
		     fr.close();
		     br.close();
		    } catch (Exception ex) {
		      System.out.println("Loi doc file: "+ex);
		  }
	}
	
	public static void SaveData(StudentInfoManage ListStudent) {
		try {
            FileWriter fw = new FileWriter("D:\\JavaWeb\\QLHS\\student.txt");
            for(int i = 0; i <  ListStudent.getListHS().size(); i++ )
 	       {
            	 
            	 fw.write(String.valueOf(ListStudent.getListHS().get(i).getInfo_id()));
            	 fw.write("&");
            	 fw.write(String.valueOf(ListStudent.getListHS().get(i).getStudent_id()) );
            	 fw.write("&");
            	 fw.write(ListStudent.getListHS().get(i).getAddress());
            	 fw.write("&");
            	 fw.write(String.valueOf(ListStudent.getListHS().get(i).getAverage_score()));
            	 fw.write("&");
            	 fw.write(ListStudent.getListHS().get(i).getDate_of_birth());
            	 fw.write("\r\n");
 	       }
            
            
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		
	}
	
	
}
