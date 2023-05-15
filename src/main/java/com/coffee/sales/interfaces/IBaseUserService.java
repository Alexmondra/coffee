package com.coffee.sales.interfaces;

import com.coffee.sales.entities.BaseUser;

public interface IBaseUserService {
	
	BaseUser findUserByEmail(String userEmail);

}
