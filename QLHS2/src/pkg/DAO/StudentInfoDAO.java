/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create Authentication class StudentInfoDAO
 *
 * @version 1.0
 *
 * @author Toan
 *
 */
package pkg.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import pks.DTO.StudentInfo;

public class StudentInfoDAO {

	// Hàm load danh sách học sinh từ file txt
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
				ListStudent.getListStudent().put(Integer.parseInt(dongHS[1]),addStudent);
			}
			fr.close();
			br.close();
		} catch (Exception ex) {
			System.out.println("Lỗi doc file: " + ex);
		}
	}

	//Hàm save danh sách học sinh vào file txt
	public static void saveData(StudentInfoManage ListStudent) {
		try {
			FileWriter txtFile = new FileWriter("D:\\GMO SYSTEM\\Exercise\\JavaCode\\QLHS2\\student.txt");
			
			//Ghi danh sách đang run lên file text
			
			for (StudentInfo student : ListStudent.getListStudent().values()) {
				txtFile.write(String.valueOf(student.getInfoId()));
				txtFile.write("&");
				txtFile.write(String.valueOf(student.getStudentId()));
				txtFile.write("&");
				txtFile.write(student.getAddress());
				txtFile.write("&");
				txtFile.write(String.valueOf(student.getAverageScore()));
				txtFile.write("&");
				txtFile.write(student.getDateOfBirth());
				txtFile.write("\r\n");
			}
			txtFile.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
