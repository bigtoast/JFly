package com.github.bigtoast.jfly.api;

import java.io.Serializable;


public interface JFlyResponse<T> extends Serializable {

	public String getStatus();
	
	public T getEntity();
	
}
