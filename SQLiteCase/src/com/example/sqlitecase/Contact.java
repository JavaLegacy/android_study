package com.example.sqlitecase;

public class Contact {

	private String _name;
	private String _phone;
	private int _id;

	
	public Contact() {
		// TODO Auto-generated constructor stub
	}
	
	public Contact(int _id, String _name, String _phone) {
		super();
		this._name = _name;
		this._phone = _phone;
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_phone() {
		return _phone;
	}

	public void set_phone(String _phone) {
		this._phone = _phone;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

}
