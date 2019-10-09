package pks.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HumanInfo {
	
	protected int infoId;
	protected String address;
	protected Date dateOfBirth;
	protected SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Scanner in = new Scanner(System.in);

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return formatter.format(dateOfBirth);
	}

	public void setDateOfBirth(String date) {
		try {
			this.dateOfBirth = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inPut() {

		System.out.println("Mã thông tin :	");
		this.infoId = in.nextInt();
		in.nextLine();
		System.out.println("Địa chỉ : ");
		this.address = in.nextLine();
		System.out.println("Ngày sinh(dd/mm/yyyy) : ");
		String tempdate = in.nextLine();
		try {
			dateOfBirth = formatter.parse(tempdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void printInfo() {
		System.out.println("Mã thông tin :	" + this.infoId);
		System.out.println("Địa chỉ : " + this.address);
		System.out.println("Ngày sinh: " + formatter.format(dateOfBirth));
	}
}
