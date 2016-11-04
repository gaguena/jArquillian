/**
 * 
 */
package com.gaguena.utils;

/**
 * @author gaguena@gmail.com
 *
 */
public final class StringUtils {

	/**
	 * Concatena a String passada com %, utilizada nas clausuras like 
	 * @param param
	 * @return
	 */
	public static String createParamLike(String param){
		return param + "%";
	}
}
