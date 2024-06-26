package com.coffee.sales.service;

public interface IBaseUserServiceErrorCode extends IAbstractServiceErrorCode {
	
	String USER_EXIST = SERVICE_BASE_USER_ERROR_CODE +"001";								//1002002001
	String INVALID_USER = SERVICE_BASE_USER_ERROR_CODE +"002";								//1002002002
	String EXIST_EMAIL =SERVICE_BASE_USER_ERROR_CODE +"003";								//1002002003
	String EMAIL_NOT_FOUND =SERVICE_BASE_USER_ERROR_CODE +"004";							//1002002004
	String EMPTY_VALUES =SERVICE_BASE_USER_ERROR_CODE +"005";								//1002002005
	String USER_NOT_FOUND = SERVICE_BASE_USER_ERROR_CODE + "006" ;							//1002002006
	String ZIP_CODE_NOT_NUMERIC =  SERVICE_BASE_USER_ERROR_CODE + "007";                 	//1002002007
	String WRONG_LEN_ZIP_CODE =  SERVICE_BASE_USER_ERROR_CODE + "008";            	    	//1002002008
	String MISSING_ZIP_CODE =  SERVICE_BASE_USER_ERROR_CODE + "009";              	    	//1002002009
	String MISSING_NAME =  SERVICE_BASE_USER_ERROR_CODE + "010";                 	    	//1002002010
	String MISSING_ADRESS =  SERVICE_BASE_USER_ERROR_CODE + "011";                 	    	//1002002011
	String MISSING_PHONE =  SERVICE_BASE_USER_ERROR_CODE + "012";                 	    	//1002002012
	String MISSING_NIF =  SERVICE_BASE_USER_ERROR_CODE + "013";                 	        //1002002013
	String WRONG_LEN_PHONE_CODE =  SERVICE_BASE_USER_ERROR_CODE + "014";            	    //1002002014
	String PHONE_NOT_NUMBERS_CODE =  SERVICE_BASE_USER_ERROR_CODE + "015";               	//1002002015
	String ROLE_EXIST = SERVICE_BASE_USER_ERROR_CODE +"016";								//1002002016
	String ROLE_NOT_FOUND = SERVICE_BASE_USER_ERROR_CODE +"017";						    //1002002017
	String USER_ROLE_NO_PRESENT = SERVICE_BASE_USER_ERROR_CODE +"018";						//1002002018
	String WRONG_PASWORD = SERVICE_BASE_USER_ERROR_CODE +"019";								//1002002019
	

}

