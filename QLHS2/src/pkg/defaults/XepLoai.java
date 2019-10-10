/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create Authentication class XepLoai
 *
 * @version 1.0
 *
 * @author Toan
 *
 */
package pkg.defaults;

public enum XepLoai {
	GPA("GPA"), MA_HOC_SINH("ID_STUDENT");
	
	private String code;

	private XepLoai(String code) {
	       this.code = code;
	   }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
