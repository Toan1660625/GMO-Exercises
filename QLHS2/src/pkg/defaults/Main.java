/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create Authentication class Main
 *
 * @version 1.0
 *
 * @author Toan
 *
 */
package pkg.defaults;


import java.util.Scanner;

import pkg.DAO.StudentInfoDAO;
import pkg.DAO.StudentInfoManage;
import pks.DTO.HumanInfo;
import pks.DTO.StudentInfo;

public class Main {

	public static void main(String[] args) {

		HumanInfo Student = new StudentInfo();
		// Ở hàm main sử dụng tính đa hình khi tạo ra đối tượng StudentInfo

		Scanner in = new Scanner(System.in);
		StudentInfoManage listStudent = new StudentInfoManage();
		StudentInfoDAO.load(listStudent);
		String select;

		do {
			System.out.println("----------Quản lý học sinh-------------------------------");
			System.out.println("|	(1). Thêm học sinh.				 |");
			System.out.println("|	(2). Chỉnh sửa mã học sinh.	 		 |");
			System.out.println("|	(3). Xóa học sinh.	        		 |");
			System.out.println("|  	(4). Sắp xếp theo điểm trung bình. 		 |");
			System.out.println("|   	(5). Sắp xếp theo mã học sinh .			 |");
			System.out.println("|	(6). Hiển thị danh sách học sinh.	  	 |");
			System.out.println("|	(0). Thoát   				   	 |");
			System.out.println("---------------------------------------------------------");
			System.out.print("Mời bạn chọn chức năng (1) -> (6):");
			
			XepLoai loai;
			select = in.nextLine();
			switch (select) {
			case "1":							
				listStudent.inPutList();							//Thêm học sinh vào danh sách
				StudentInfoDAO.saveData(listStudent);				//Lưu dữ liệu vào file .txt
				break;
			case "2":
				listStudent.edit();									//Sửa học sinh trong danh sách
				StudentInfoDAO.saveData(listStudent);
				break;
			case "3":
				listStudent.delete();								//Xóa học sinh trong danh sách
				StudentInfoDAO.saveData(listStudent);
				break;
			case "4":
				loai = XepLoai.GPA;				
				listStudent.sort(loai);								//Xếp danh sách theo điểm trung bình
				StudentInfoDAO.saveData(listStudent);
				break;
			case "5":
				loai = XepLoai.MA_HOC_SINH;
				listStudent.sort(loai);								//Xếp danh sách theo mã học sinh
				StudentInfoDAO.saveData(listStudent);
				break;
			case "6":
				listStudent.outPutList();							// Hiển thị danh sách học sinh
				break;
			case "0":
				StudentInfoDAO.saveData(listStudent);
				System.out.print("Chương trình kết thúc.");
				break;
			default:
				System.out.println("Chọn sai, vui lòng chọn đúng!!");
			}

		} while ((select.equals("0")) == false);
	}

}
