package pks.DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentInfo {
	private int info_id	;
	private int 	student_id	;
	private	String address	;
	private double 	average_score	;
	private	Date date_of_birth	;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

//	public StudentInfo(int info_id, int student_id, String address, double average_score, String date_of_birth) {
//		super();
//		this.info_id = info_id;
//		this.student_id = student_id;
//		this.address = address;
//		this.average_score = average_score;
//		this.date_of_birth2 = date_of_birth;
//	}
	
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAverage_score() {
		return average_score;
	}
	public void setAverage_score(double average_score) {
		this.average_score = average_score;
	}
	public String getDate_of_birth() {
		return formatter.format(date_of_birth);
	}
	public void setDate_of_birth(String date_of_birth) {
		
		try {
			this.date_of_birth = formatter.parse(date_of_birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Input() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập thông tin học sinh	");
		System.out.println("Mã thông tin :	");
		this.info_id = in.nextInt();
		System.out.println("Mã học sinh :	");
		this.student_id = in.nextInt();
		in.nextLine() ;
		System.out.println("Địa chỉ : ");
		this.address = in.nextLine();
		System.out.println("Điểm trung bình : ");
		this.average_score = in.nextDouble();
		in.nextLine() ;
		System.out.println("Ngày sinh(dd-mm-yyyy) : ");
		String tempdate = in.nextLine();	
		try {
			date_of_birth = formatter.parse(tempdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Output() {
		System.out.println("");
		System.out.println("Mã thông tin :	" + this.info_id);
		System.out.println("Mã học sinh :	" + this.student_id);
		System.out.println("Địa chỉ : "+ this.address);
		System.out.println("Điểm trung bình : " + this.average_score);
		System.out.println("Ngày sinh: " + formatter.format(date_of_birth));
		System.out.println("----------------------------------------");
	}
	

}
