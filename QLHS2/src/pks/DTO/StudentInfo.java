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

public class StudentInfo extends HumanInfo {

	private int studentId;
	private double averageScore;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	@Override
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
	public void printInfo() {
		System.out.println("");
		System.out.println("Mã học sinh :	" + this.studentId);
		super.printInfo();
		System.out.println("Điểm trung bình : " + this.averageScore);
		System.out.println("----------------------------------------");
	}

}
