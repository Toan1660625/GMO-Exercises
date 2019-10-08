package com.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pks.DTO.StudentInfo;

public class StudentInfoManage {

	private List<StudentInfo> ListHS = new ArrayList<StudentInfo>();
	
	public List<StudentInfo> getListHS() {
		return ListHS;
	}


	public void setListHS(List<StudentInfo> listHS) {
		ListHS = listHS;
	}


	Scanner in = new Scanner(System.in);
	   public void Input(){
		   System.out.println("Nhập số lượng học sinh");
	         int SLGV = in.nextInt();
	         for(int i = 0;i<SLGV;i++){
	        	 StudentInfo hocsinh = new StudentInfo();
	        	 hocsinh.Input();
	             this.ListHS.add(hocsinh);     
	          }
	         System.out.println("Thêm học sinh hoàng tất");
	    }
	
	
	   public void Output(){
	       for(StudentInfo HS : ListHS)
	       {
	           HS.Output();
	       }
	    }
	   
	   public void Delete(){
		   System.out.print("Nhập Mã học sinh cần xóa:	");
		   int id_student = in.nextInt();
		   int check = 0;
		   for(int i = 0; i <  ListHS.size(); i++ )
	       {
			   if(ListHS.get(i).getStudent_id() == id_student)
			   {
				   ListHS.remove(i);
				   check = 1;
				   System.out.println("Xóa học sinh hoàng tất");
				   
			   }
	       }
		   if(check == 0) {
			   System.out.println("Không tìm thấy mã học sinh trong danh sách");
		   }
		   
	    }
	   
	   
	   public void Edit(){
		   System.out.print("Nhập ID Student cần sửa:	");
		   int id_student = in.nextInt();
		   int check = 0;
		   for(int i = 0; i <  ListHS.size(); i++ )
	       {
			   if(ListHS.get(i).getStudent_id() == id_student)
			   {
				   System.out.println("Thông tin Student cần sửa:");
				   ListHS.get(i).Output();
				   System.out.println("----------------------------");
				   System.out.println("Sửa lại Thông tin Student :");
//				   StudentInfo tempHS = new StudentInfo();			   
				   ListHS.get(i).Input();
				   System.out.println("Sửa học sinh hoàn tất");
			   }
	       }
		   if(check == 0) {
			   System.out.println("Không tìm thấy mã học sinh trong danh sách");
		   }
	    }
	   
	   
	   public void SortGPA(){

		   for(int i = 0; i <  ListHS.size()-1; i++ )
	       {
			   for(int j = i; j <  ListHS.size(); j++ )
		       {
				   if (ListHS.get(j).getAverage_score() > ListHS.get(i).getAverage_score()) {
					   StudentInfo tempHS = ListHS.get(j);
				   	   ListHS.set(j, ListHS.get(i));
				   	   ListHS.set(i, tempHS);
				   }
				       
				   
			   }
	       }
		   System.out.println("Sắp xếp theo điểm trung bình hoàn tất");
	    }
	   
	   public void SortID(){
		   for(int i = 0; i <  ListHS.size()-1; i++ )
	       {
			   for(int j = i; j <  ListHS.size(); j++ )
		       {
				   if (ListHS.get(j).getStudent_id() < ListHS.get(i).getStudent_id()) {
				   	   StudentInfo tempHS = ListHS.get(j);
				   	   ListHS.set(j, ListHS.get(i));
				   	   ListHS.set(i, tempHS);
				   }
				   
			   }
	       }
		   System.out.println("Sắp xếp theo mã học sinh hoàn tất");
	    }

}
