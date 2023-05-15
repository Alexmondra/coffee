package com.coffee.sales.error;

import org.springframework.http.HttpStatus;

import com.coffee.sales.config.SpringContext;
import com.coffee.sales.utils.I18n;



public class RegisterException extends RGTRxception {

	public RegisterException(HttpStatus status) {
		super(status);

	}

	public RegisterException(String code, HttpStatus status) {
		super(SpringContext.getApplicationContext().getBean(I18n.class).getMessage(code), code, status);

	}

	public RegisterException(String code, Object[] args, HttpStatus status) {
		super(SpringContext.getApplicationContext().getBean(I18n.class).getMessage(code,
				args == null ? new Object[0] : args), code, status);
	}

}
