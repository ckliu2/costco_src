package com.base.util;

import static org.apache.commons.io.FileUtils.copyURLToFile;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.*;
import java.text.*;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.commons.lang3.StringUtils;

import com.base.value.*;
import com.common.value.*;

public class Tools {

	private static HashMap hm = new HashMap();
	static DecimalFormat df = new DecimalFormat("##.000");
	static DecimalFormat df2 = new DecimalFormat("##.00");
	static DecimalFormat df3 = new DecimalFormat("#,##0.00");
	static DecimalFormat df4 = new DecimalFormat("#,##0.0");

	public Tools() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean isEmptyString(String s) {
		if (s == null || s.trim().length() == 0)
			return true;
		return false;
	}

	public static java.util.Date convertToDate1(String date) {
		if (date != null && date.length() > 0) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyyMMdd");

			try {
				return dmj.parse(date);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public static java.util.Date convertToDate3(String date) {
		if (date != null && date.length() > 0) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy-MM-dd");
			try {
				return dmj.parse(date);
			} catch (java.text.ParseException e) {
				// e.printStackTrace();
				// System.out.println("convertToDate3 error="+e.toString());
			}
		}
		return null;
	}

	public static java.util.Date convertToDate2(String date) {
		if (date != null && date.length() > 0) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				return dmj.parse(date);
			} catch (java.text.ParseException e) {
				// System.out.println("convertToDate2 error="+e.toString());
			}
		}
		return null;
	}

	public static java.util.Date convertToDate(String date) {
		if (date != null && date.length() > 0) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy/MM/dd");

			try {
				return dmj.parse(date);
			} catch (java.text.ParseException e) {
				return null;
			}
		}

		return null;
	}

	public static String todayString() {
		Date date = new Date();
		java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyyMMdd");
		String s = dmj.format(date);
		return s;
	}

	public static String dateToString(java.util.Date date) {
		if (date != null) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy/MM/dd");
			String s = dmj.format(date);
			return s;
		}
		return null;
	}

	public static String dateToString1(java.util.Date date) {
		if (date != null) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
			String s = dmj.format(date);
			return s;
		}
		return null;
	}

	public static String dateToString2(java.util.Date date) {
		if (date != null) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy-MM-dd");
			String s = dmj.format(date);
			return s;
		}
		return null;
	}

	public static String dateToString3(java.util.Date date) {
		if (date != null) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s = dmj.format(date);
			return s;
		}
		return null;
	}

	public static String dateToString4(java.util.Date date) {
		if (date != null) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("HH:mm:ss");
			String s = dmj.format(date);
			return s;
		}
		return null;
	}

	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String formatSimpleDate(java.util.Date d) {
		String s = "";
		if (d != null) {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");

			return sdf.format(d);
		}
		return null;
	}

	public static Calendar[] getDateOffset(java.util.Date d,int offset) {
		Calendar[] ls = new Calendar[offset];		
		for(int i=0;i<offset;i++){
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, -i);
			ls[i]=cal;
		}		
		return ls;
	}

	public static String week(java.util.Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String week = "";
		switch (dayOfWeek) {
		case Calendar.SUNDAY:
			week = "日";
			break;
		case Calendar.MONDAY:
			week = "一";
			break;
		case Calendar.TUESDAY:
			week = "二";
			break;
		case Calendar.WEDNESDAY:
			week = "三";
			break;
		case Calendar.THURSDAY:
			week = "四";
			break;
		case Calendar.FRIDAY:
			week = "五";
			break;
		case Calendar.SATURDAY:
			week = "六";
			break;
		}
		return week;
	}

	public static String formatDouble1(Double d) {
		return df4.format(d);
		// return addSpaceForString(df4.format(d), 6);

		// return String.format("%9s", d);
	}

	public static String formatDouble(Double d) {
		return df3.format(d);
	}

	public static String firstCharToLowerCase(String pString_) {
		String sRetVal = new String();
		if (pString_ == null || pString_.length() == 0) {
			return (sRetVal);
		}
		sRetVal = pString_.substring(0, 1).toLowerCase() + pString_.substring(1, pString_.length());

		return (sRetVal);
	}

	public static String firstCharToUpperCase(String pString_) {
		String sRetVal = new String();
		if (pString_ == null || pString_.length() == 0) {
			return (sRetVal);
		}
		sRetVal = pString_.substring(0, 1).toUpperCase() + pString_.substring(1, pString_.length());

		return (sRetVal);
	}

	public static String getUniqueId() {
		Date ts = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS.");
		String txt = fmt.format(ts);

		if (hm.get(txt) != null) {
			int a = ((Integer) hm.get(txt)).intValue() + 1;
			hm.put(txt, new Integer(a));
			return txt + a;
		} else {
			hm.clear();
			hm.put(txt, new Integer(0));
			return txt + "0";
		}
	}

	public static String getURLDecoder(String value) {
		String zhongguo = "";
		try {
			zhongguo = java.net.URLDecoder.decode(value, "utf-8");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return zhongguo;
	}

	public static String getURLEnecoder(String value) {
		String zhongguo = "";
		try {
			zhongguo = java.net.URLEncoder.encode(value, "utf-8");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return zhongguo;
	}

	public static Long convertEncryptStringToId(String str) {
		String a = campus.tool.util.security.Util.decrypt(str);
		long aid;
		try {
			aid = Long.parseLong(a);
		} catch (NumberFormatException ex) {
			throw null;
		}
		return new Long(aid);
	}

	public static String md5(String m) {
		String pass = "";
		try {
			byte[] LaborBytes = m.getBytes();
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(LaborBytes);
			byte messageDigest[] = algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			pass = hexString + "";
		} catch (Exception e) {
			System.out.println("MDF FAIL()");
		}
		return pass;
	}

	public static Date getToday() {
		Date t = new Date();
		return t;
	}

	public static java.util.Date convertToDateTime(String date) {
		if (date != null && date.length() > 0) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return dmj.parse(date);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static java.util.Date convertToDateTime1(String date) {
		if (date != null && date.length() > 0) {
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				return dmj.parse(date);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static int getIntervalDays(Date begindate, Date enddate) {
		int day = 0;
		try {
			long millisecond = enddate.getTime() - begindate.getTime();
			day = (int) (millisecond / 24L / 60L / 60L / 1000L);
		} catch (Exception e) {
			System.out.println("getIntervalDays=" + e.toString());
		}
		return day;
	}

	private static void createDestDirectoryIfNecessary(String destParam) {
		File destDir = null;
		if (destParam.endsWith(File.separator)) {
			destDir = new File(destParam);
		} else {
			destDir = new File(destParam.substring(0, destParam.lastIndexOf(File.separator)));
		}
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
	}

	public static Calendar dateAddDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal;
	}

	public static Calendar dateAddMins(Date date, int mins) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, mins);
		return cal;
	}

	private static String buildDestinationZipFilePath(File srcFile, String destParam) {
		if (StringUtils.isEmpty(destParam)) {
			if (srcFile.isDirectory()) {
				destParam = srcFile.getParent() + File.separator + srcFile.getName() + ".zip";
			} else {
				String fileName = srcFile.getName().substring(0, srcFile.getName().lastIndexOf("."));
				destParam = srcFile.getParent() + File.separator + fileName + ".zip";
			}
		} else {
			createDestDirectoryIfNecessary(destParam);
			if (destParam.endsWith(File.separator)) {
				String fileName = "";
				if (srcFile.isDirectory()) {
					fileName = srcFile.getName();
				} else {
					fileName = srcFile.getName().substring(0, srcFile.getName().lastIndexOf("."));
				}
				destParam += fileName + ".zip";
			}
		}
		return destParam;
	}

	public static String fullCalendarString(java.util.Date date) {
		if (date != null) {
			// 2015-09-28T16:00:00
			java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat("yyyy-MM-dd年HH:mm:ss");
			String s = dmj.format(date);
			return s.replace("年", "T");
		}

		return null;
	}

	public static String zip(String src, String dest, boolean isCreateDir, String passwd) {
		File srcFile = new File(src);
		dest = buildDestinationZipFilePath(srcFile, dest);
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		if (!StringUtils.isEmpty(passwd)) {
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword(passwd.toCharArray());
		}
		try {
			ZipFile zipFile = new ZipFile(dest);
			if (srcFile.isDirectory()) {
				if (!isCreateDir) {
					File[] subFiles = srcFile.listFiles();
					ArrayList<File> temp = new ArrayList<File>();
					Collections.addAll(temp, subFiles);
					zipFile.addFiles(temp, parameters);
					return dest;
				}
				zipFile.addFolder(srcFile, parameters);
			} else {
				zipFile.addFile(srcFile, parameters);
			}
			return dest;
		} catch (ZipException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String guid() {
		String guid = java.util.UUID.randomUUID().toString();
		return guid;
	}

	public static String methodURL(String u) {
		String page = "";
		int len = u.length();
		int times = u.lastIndexOf("/");
		page = u.substring(times + 1, len - 4);
		return page;
	}

	public static String addSpaceForString(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append(" ").append(str); // 左補0
				// sb.append("<font color='white'>0</font>").append(str);
				str = sb.toString();
				strLen = str.length();
			}
		}
		return str;
	}

	public static double rounding(double value, int num) {
		double b = new BigDecimal(value).setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
		return b;
	}

	public static void main(String[] arg) {
		try {
			System.out.println("英吋平方=" + getUnitArea("英吋平方", 444, 444));
			System.out.println("米平方=" + getUnitArea("米平方", 444, 444));
			System.out.println("才=" + getUnitArea("才", 444, 444));

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static int getPriceByUnitArea(String unit, double width, double height, double price) {
		int sum = 0;
		if (unit.equals("才")) {
			int chi = (int) Math.ceil(width * height / 900.0);
			sum = (int) (chi * price);
		}

		if (unit.equals("米平方")) {
			double d = new BigDecimal(width * height / 10000.0).setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
			sum = (int) Math.ceil(price * d);
		}

		if (unit.equals("英吋平方")) {
			double w = (int) Math.ceil(width / 2.54);
			double h = (int) Math.ceil(height / 2.54);
			// System.out.println("w=" + w+"--h="+h);
			sum = (int) (w * h * price);
		}

		if (unit.equals("個")) {
			sum = (int) price;
		}

		if (unit.equals("件")) {
			sum = (int) price;
		}

		return sum;
	}

	public static double getUnitArea(String unit, double width, double height) {
		double sum = 0;
		if (unit.equals("才")) {
			int chi = (int) Math.ceil(width * height / 900.0);
			sum = chi;
		}

		if (unit.equals("米平方")) {
			sum = new BigDecimal(width * height / 10000.0).setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
		}

		if (unit.equals("英吋平方")) {
			double w = (int) Math.ceil(width / 2.54);
			double h = (int) Math.ceil(height / 2.54);
			// System.out.println("w=" + w+"--h="+h);
			sum = (int) (w * h);
		}

		if (unit.equals("個")) {
			sum = 1;
		}

		if (unit.equals("件")) {
			sum = 1;
		}

		return sum;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static void downloadFile(String url, String filepath, String fileName) {
		try {
			File fl = new File(filepath + fileName);
			URL dl = new URL(url);
			copyURLToFile(dl, fl);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static String randomPsd() {
		int i;
		int[] A = new int[8];
		for (i = 0; i < 8; i++) {
			if (i < 3) { // 前 3 放數字
				A[i] = (int) ((Math.random() * 10) + 48);
			} else if (i < 6) { // 中間 3 位放大寫英文
				A[i] = (int) (((Math.random() * 26) + 65));
			} else { // 後 2 位放小寫英文
				A[i] = ((int) ((Math.random() * 26) + 97));
			}
		}
		System.out.print("password = ");
		String psd = "";
		for (i = 0; i < 8; i++) {
			System.out.print((char) A[i]);
			psd += (char) A[i];
		}

		return psd;
	}

	public static boolean checkGroup(Member member, String groupKey) {
		if (member == null) {
			return false;
		}
		Set groups = member.getGroups();
		if (groups != null) {
			Iterator i = groups.iterator();
			while (i.hasNext()) {
				Group g = (Group) i.next();
				if (groupKey.equals(g.getGroupKey())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void copyFileUsingStream(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } catch(Exception e){
	    	System.out.println("copyFileUsingStream err="+e.toString());
	    }finally {
	        is.close();
	        os.close();
	    }
	}

}
