package pkg.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import pks.DTO.StudentInfo;

public class StudentInfoDAO {

	public static void load(StudentInfoManage ListStudent) {
		try {			
			File filePath = new File("D:\\GMO SYSTEM\\Exercise\\JavaCode\\QLHS2\\student.txt");
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String onrLine;
			
			// Thêm từng học sinh vào danh sách
			while ((onrLine = br.readLine()) != null) {
				String[] dongHS = onrLine.split("&");
				StudentInfo addStudent = new StudentInfo();
				addStudent.setInfoId(Integer.parseInt(dongHS[0]));
				addStudent.setStudentId(Integer.parseInt(dongHS[1]));
				addStudent.setAddress(dongHS[2]);
				addStudent.setAverageScore(Double.parseDouble(dongHS[3]));
				addStudent.setDateOfBirth(dongHS[4]);
				ListStudent.getListStudent().add(addStudent);
			}
			fr.close();
			br.close();
		} catch (Exception ex) {
			System.out.println("Lỗi doc file: " + ex);
		}
	}

	public static void saveData(StudentInfoManage ListStudent) {
		try {
			FileWriter txtFile = new FileWriter("D:\\GMO SYSTEM\\Exercise\\JavaCode\\QLHS2\\student.txt");
			
			//Ghi danh sách đang run lên file text
			for (int i = 0; i < ListStudent.getListStudent().size(); i++) {
				txtFile.write(String.valueOf(ListStudent.getListStudent().get(i).getInfoId()));
				txtFile.write("&");
				txtFile.write(String.valueOf(ListStudent.getListStudent().get(i).getStudentId()));
				txtFile.write("&");
				txtFile.write(ListStudent.getListStudent().get(i).getAddress());
				txtFile.write("&");
				txtFile.write(String.valueOf(ListStudent.getListStudent().get(i).getAverageScore()));
				txtFile.write("&");
				txtFile.write(ListStudent.getListStudent().get(i).getDateOfBirth());
				txtFile.write("\r\n");
			}
			txtFile.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
