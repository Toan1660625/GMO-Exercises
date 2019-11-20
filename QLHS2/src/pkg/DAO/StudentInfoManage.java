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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import pkg.defaults.XepLoai;
import pks.DTO.StudentInfo;

public class StudentInfoManage {
	private Map<Integer,StudentInfo> listStudentManager = new LinkedHashMap<Integer,StudentInfo>();
	Scanner in = new Scanner(System.in);

	public Map<Integer,StudentInfo> getListStudent() {
		return listStudentManager;
	}

	public void setListStudent(HashMap<Integer,StudentInfo> listStudent) {
		listStudentManager = listStudent;
	}
	
	//Hàm nhập 1 danh sách học sinh
	public void inPutList() {
		System.out.println("Nhập số lượng học sinh");
		int numberOfStudent = in.nextInt();
		for (int i = 0; i < numberOfStudent; i++) {
			StudentInfo hocsinh = new StudentInfo();
			hocsinh.inPut();
			this.listStudentManager.put(hocsinh.getStudentId(),hocsinh);
		}
		System.out.println("Thêm học sinh hoàng tất");
	}

	//Hàm xuất 1 danh sách học sinh
	public void outPutList() {		
		for (StudentInfo Student : listStudentManager.values()) {
			Student.printInfo();
		}
	}

	//Hàm xóa 1 học sinh
	public void delete() {
		System.out.print("Nhập Mã học sinh cần xóa:	");
		int idStudent = in.nextInt();
		if(listStudentManager.containsKey(idStudent) == true)
		{
				listStudentManager.remove(idStudent);
		}
		else{
			System.out.println("Không tìm thấy mã học sinh trong danh sách");
		}

	}

	//Hàm sửa 1 học sinh
	public void edit() {
		System.out.print("Nhập mã học sinh cần sửa:	");
		int idStudent = in.nextInt();
		if(listStudentManager.containsKey(idStudent) == true)
		{
			System.out.println("Thông tin học sinh cần sửa:");
			listStudentManager.get(idStudent).printInfo();
			System.out.println("----------------------------");
			System.out.println("Sửa lại Thông tin học sinh :");
			listStudentManager.get(idStudent).inPut();
			System.out.println("Sửa học sinh hoàn tất");
		}
		else{
			System.out.println("Không tìm thấy mã học sinh trong danh sách");
		}
		
	}
	
	public Map<Integer, StudentInfo> sortByValue(Map<Integer, StudentInfo> unsortMap,boolean order)   
	{  
	//convert HashMap into List   
	List<Entry<Integer, StudentInfo>> list = new LinkedList<Entry<Integer, StudentInfo>>(unsortMap.entrySet());  
	//sorting the list elements  
	Collections.sort(list, new Comparator<Entry<Integer, StudentInfo>>()   
	{  
			public int compare(Entry<Integer, StudentInfo> o1, Entry<Integer, StudentInfo> o2)   
			{  
			if (order)   
			{   
				return o1.getValue().compareTo(o2.getValue());}   
			else   
			{  
				return o2.getValue().compareTo(o1.getValue());  
			}  
			}  
	});  
	Map<Integer, StudentInfo> sortedMap = new LinkedHashMap<Integer, StudentInfo>();  
	for (Entry<Integer, StudentInfo> entry : list)   
	{  
		sortedMap.put(entry.getKey(), entry.getValue());  
	}  
	return sortedMap;  
	}  
	
	// Hàm sắp xếp danh sắp học sinh 
	// Nhận vào 1 param để kiêm tra sắp xếp theo điểm trung bình hay Mã học sinh
	public void sort(String loai) {
		if (XepLoai.GPA.getCode().equals(loai)) {			
			Map<Integer,StudentInfo> map =  sortByValue(listStudentManager, true);
			listStudentManager = map;
			System.out.println("Sắp xếp theo điểm trung bình hoàn tất");

		} else if (XepLoai.MA_HOC_SINH.getCode().equals(loai)) {
			Map<Integer,StudentInfo> map = new TreeMap<Integer,StudentInfo>(listStudentManager);
			listStudentManager = map;
			System.out.println("Sắp xếp theo mã học sinh hoàn tất");
		} else
			System.out.println("Lỗi Sắp Xếp");
	}
	


}
