/**
 * 
 */
package com.gaguena.util;

import java.util.Calendar;

/**
 * @author gaguena@gmail.com
 *
 */
public class DateUtil {

	/**
	 * Operacao de dias na data corrente
	 * @param days
	 * @return
	 */
	public static Calendar getCalendar(int days){
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, days);
		return date;
	}
}
