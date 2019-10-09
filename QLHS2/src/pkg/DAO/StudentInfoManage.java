/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create Authentication class StudentInfoManage
 *
 * @version 1.0
 *
 * @author Toan
 *
 */
package pkg.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pkg.defaults.XepLoai;
import pks.DTO.StudentInfo;

public class StudentInfoManage {

	private List<StudentInfo> listStudentManager = new ArrayList<StudentInfo>();
	Scanner in = new Scanner(System.in);

	public List<StudentInfo> getListStudent() {
		return listStudentManager;
	}

	public void setListStudent(List<StudentInfo> listStudent) {
		listStudentManager = listStudent;
	}

	public void inPutList() {
		System.out.println("Nhập số lượng học sinh");
		int SLGV = in.nextInt();
		for (int i = 0; i < SLGV; i++) {
			StudentInfo hocsinh = new StudentInfo();
			hocsinh.inPut();
			this.listStudentManager.add(hocsinh);
		}
		System.out.println("Thêm học sinh hoàng tất");
	}

	public void outPutList() {
		for (StudentInfo HS : listStudentManager) {
			HS.printInfo();
		}
	}

	public void delete() {
		System.out.print("Nhập Mã học sinh cần xóa:	");
		int idStudent = in.nextInt();
		int check = 0;
		for (int i = 0; i < listStudentManager.size(); i++) {
			if (listStudentManager.get(i).getStudentId() == idStudent) {
				listStudentManager.remove(i);
				check = 1;
				System.out.println("Xóa học sinh hoàng tất");
			}
		}
		if (check == 0) {
			System.out.println("Không tìm thấy mã học sinh trong danh sách");
		}

	}

	public void edit() {
		System.out.print("Nhập mã học sinh cần sửa:	");
		int idStudent = in.nextInt();
		int checkError = 0;
		
		for (int i = 0; i < listStudentManager.size(); i++) {
			if (listStudentManager.get(i).getStudentId() == idStudent) {
				System.out.println("Thông tin học sinh cần sửa:");
				listStudentManager.get(i).printInfo();
				System.out.println("----------------------------");
				System.out.println("Sửa lại Thông tin học sinh :");
				listStudentManager.get(i).inPut();
				System.out.println("Sửa học sinh hoàn tất");
			}
		}
		if (checkError == 0) {
			System.out.println("Không tìm thấy mã học sinh trong danh sách");
		}
	}

	public void sort(XepLoai loai) {
		if (loai == XepLoai.GPA) {
			for (int i = 0; i < listStudentManager.size() - 1; i++) {
				
				for (int j = i; j < listStudentManager.size(); j++) {
					
					if (listStudentManager.get(j).getAverageScore() > listStudentManager.get(i).getAverageScore()) {
						StudentInfo tempHS = listStudentManager.get(j);
						listStudentManager.set(j, listStudentManager.get(i));
						listStudentManager.set(i, tempHS);
					}
				}
			}
			System.out.println("Sắp xếp theo điểm trung bình hoàn tất");

		} else if (loai == XepLoai.MA_HOC_SINH) {
			for (int i = 0; i < listStudentManager.size() - 1; i++) {
				
				for (int j = i; j < listStudentManager.size(); j++) {
					
					if (listStudentManager.get(j).getStudentId() < listStudentManager.get(i).getStudentId()) {
						StudentInfo tempHS = listStudentManager.get(j);
						listStudentManager.set(j, listStudentManager.get(i));
						listStudentManager.set(i, tempHS);
					}
				}
			}
			System.out.println("Sắp xếp theo mã học sinh hoàn tất");
		} else
			System.out.println("Lỗi Sắp Xếp");
	}

}
