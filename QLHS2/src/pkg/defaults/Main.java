package pkg.defaults;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import com.student.StudentInfoManage;

import pkg.DAO.StudentInfoDAO;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StudentInfoManage ListStudent = new StudentInfoManage();
		StudentInfoDAO.Load(ListStudent);
		String n;
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
			System.out.print("Mời bạn chọn chức năng:	");
			
			n = in.nextLine();
			switch (n){	
			case "1":
				ListStudent.Input();
				StudentInfoDAO.SaveData(ListStudent);
			    break;
			case "2":
				ListStudent.Edit();
				StudentInfoDAO.SaveData(ListStudent);
			    break; 
			case "3":
				ListStudent.Delete();
				StudentInfoDAO.SaveData(ListStudent);
			    break;
			case "4":
				ListStudent.SortGPA();
				StudentInfoDAO.SaveData(ListStudent);
			    break;
			case "5":
				ListStudent.SortID();
				StudentInfoDAO.SaveData(ListStudent);
			    break;
			case "6":
				ListStudent.Output();
			    break;
 
			case "0":
				StudentInfoDAO.SaveData(ListStudent);
				System.out.print("Chương trình kết thúc.");
			    break;
			default:
			    System.out.println("Chọn sai, vui lòng chọn đúng!!");
		
			}
		
		}while(n.equals("0") == false);
	}

}
