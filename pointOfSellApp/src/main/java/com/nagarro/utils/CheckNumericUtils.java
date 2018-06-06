/**
 * For checking if a string is number of not.
 */
package com.nagarro.utils;

public class CheckNumericUtils {

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    long d = Long.parseLong(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
}
