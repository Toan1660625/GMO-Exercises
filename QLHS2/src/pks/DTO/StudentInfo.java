/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create Authentication class StudentInfo
 *
 * @version 1.0
 *
 * @author Toan
 *
 */
package pks.DTO;

import java.util.Comparator;

public class StudentInfo extends HumanInfo implements Comparable<StudentInfo> {
	
	private int studentId;
	private Double averageScore;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Double getAverageScore() {
		return this.averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	/*
	 *Override lại hàm inPut của class HumanInfo
	 *Nhập thông tin học sinh.
	 */
	public void inPut() {
		int check = 1;
		do {
			check = 1;
			try {
//				Scanner in = new Scanner(System.in);
				System.out.println("Nhập thông tin học sinh	");
				System.out.println("Mã học sinh :	");
				this.studentId = in.nextInt();
				in.nextLine();
				super.inPut();
				System.out.println("Điểm trung bình : ");
				this.averageScore = in.nextDouble();
			} catch (Exception e) {
				check = 0;
				System.out.println("Erro : 1 trường nhập sai, nhập lại điiii");
			}
		} while (check == 0);
	}

	@Override
	/*
	 *Override lại hàm printInfo của class HumanInfo
	 *Xuất ra thông tin học sinh.
	 */
	public void printInfo() {
		System.out.println("");
		System.out.println("Mã học sinh :	" + this.studentId);
		super.printInfo();
		System.out.println("Điểm trung bình : " + this.averageScore);
		System.out.println("----------------------------------------");
	}
	
    @Override
    public int compareTo(StudentInfo obj) {
        return this.getAverageScore().compareTo(obj.getAverageScore());
    }

}
