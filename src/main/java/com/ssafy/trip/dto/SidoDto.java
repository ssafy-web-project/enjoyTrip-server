package com.ssafy.trip.dto;

public class SidoDto {
	private int code;
	private String name;
	
	public SidoDto() {}
	public SidoDto(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SidoDto [code=" + code + ", name=" + name + "]";
	}
}
