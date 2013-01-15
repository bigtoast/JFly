package com.github.bigtoast.jfly.api;

import java.io.Serializable;

public class Empty implements Serializable {

	private static final long serialVersionUID = -6684185506289333614L;
	
	public Empty(){}
	public static Empty getInstance(){ return new Empty(); }
}
