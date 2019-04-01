/*
 * 系统名称: cyp
 * 模块名称:
 * 类 名 称   : DateUtil.java
 * 软件版权: ceyingfintech
 * 相关文档:
 * 修改记录:
 * 修改日期		修改人员		修改说明<BR>
 * ==========================================================
 * ==========================================================
 * 评审记录：
 *
 * 评审人员：
 * 评审日期：
 * 发现问题：
 */
package com.zhang.util;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能说明: 对日期进行date与string转换<br>
 * 系统版本: V0.1 <br>
 * 开发人员: zhengbin@chx <br>
 * 开发时间: 2010-7-15<br>
 * <br>
 */
public class DateUtil {
  	private static final String          TIME_PATTERN             = "HH:mm";
    public static final String           DATE_PATTERN_YYYY_MM_DD  = "yyyy-MM-dd";
    public static final String           DATE_PATTERN_YYYYMMDD    = "yyyyMMdd";
    public static final String           YYYY_MM_DD_HH_MM_SS      = "yyyy-MM-dd HH:mm:ss";
    public static final String           YYYY_MM_DD_HH            = "yyyy-MM-dd HH";
    public static final String           CHINESE_YYYY_MM_DD_HH_MM = "yyyy年MM月dd日  HH点mm分";
    public static final String           YYYY_MM_DD_HH_00         = "yyyy-MM-dd HH:00";
    public static final String           YYYYMMDDHH               = "yyyyMMddHH";
    public static final String           YYYYMMDDHHMMSS           = "yyyyMMddHHmmss";
    public static final String           YYYYMMDDHHMM             = "yyMdHHmmss";
    public static final String           MMDDHHMMSS               = "MMddHHmmss";

	private static final String[] dayFormatter = {
			"yyyy年MM月dd日",// 0
			"yyyy-MM-dd",// 1
			"yyyy/MM/dd",// 2
			"yyyy年MM月dd日HH时mm分ss秒",// 3
			"yyyy/MM/dd-HH:mm:ss",// 4
			"yyyy-MM-dd HH:mm:ss",// 5
			"HHmmss", // 6
			"yyyyMMddHHmmss",// 7
			"yyyy-MM-dd HH:mm",// 8
			"HH:mm",// 9
			"dd/MM/yyyy",// 10
			"MM-dd",// 11
			"yyyy",// 12
			"yyyy-MM-dd HH",// 13
			"yyyyMMdd",// 14
			"yyyy-MM",// 15
			"ss mm HH dd MM E yyyy", // 16
			"yyyyMMddHHmm", // 17
			"yyyy/MM/dd HH:mm:ss", // 18
			"MMM dd yyyy HH:mm:ss",// 19
			"MMM dd yyyy", // 20
			"yyyyMMdd" // 21
	};

    private static Locale[] localArray = new Locale[]{
        Locale.getDefault(),//0
        Locale.getDefault(),//1
        Locale.getDefault(),//2
        Locale.getDefault(),//3
        Locale.getDefault(),//4
        Locale.getDefault(),//5
        Locale.getDefault(),//6
        Locale.getDefault(),//7
        Locale.getDefault(),//8
        Locale.getDefault(),//9
        Locale.getDefault(),//10
        Locale.getDefault(),//11
        Locale.getDefault(),//12
        Locale.getDefault(),//13
        Locale.getDefault(),//14
        Locale.getDefault(),//15
        Locale.US,//16
        Locale.getDefault(),//17
        Locale.getDefault(),//18
        Locale.US,//19
        Locale.US,//20
        Locale.getDefault()//21
    };

    /**
     * 按照<code>kind</code>来生成日期string格式
     * @param date
     * @param kind
     * @return
     */
    public static String dateString(Date date, int kind) {
        if (kind < 0 || kind >= dayFormatter.length) {
            kind = 0;
        }
        if (date == null)
            return "";
        return (new SimpleDateFormat(dayFormatter[kind],localArray[kind]).format(date));
    }

    /**
     * 按照<code>kind</code>来生成date类型日期
     * @param inputDate
     * @param kind
     * @return
     */
    public static Date stringDate(String inputDate, int kind) {
        Date tmp = null;
        try {
           tmp= new SimpleDateFormat(dayFormatter[kind],localArray[kind]).parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    /**
     * 获得年月日的数字值
     * e.g. 20100715 [yyyyMMdd]
     * @param date
     * @return
     */
    public static int getYearMonthDay(Date date) {
        return Integer.parseInt(dateString(date, 21));
    }

    /**
     * 获得小时分秒数字值
     * e.g. 135630 [HHmmss]
     * @param date
     * @return
     */
    public static int getHourMinuteSecond(Date date){
    	return Integer.parseInt(dateString(date, 6));
    }

    /**
     * 获得年月日时分秒的数字值
     * @param date
     * @return
     */
    public static String getYearMonDayHourMinSec(Date date) {
        return dateString(date, 17);
    }

    /**
     * 将整形数字“20100720”转成毫秒数
     * @param date
     * @return 时间
     */
    public static long getTime(Integer date){
    	 String timeStr = String.valueOf(date);
    	 if(timeStr.length()==8){
    		 try {
				return (new SimpleDateFormat(dayFormatter[14],localArray[14]).parse(timeStr).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	 }
    	 return -1;
    }


    /**
     * 转换字符串为时间类型
     */
    public static Date convertStringTODate(String dateStr, String pattern) throws ParseException {
//        if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(pattern)) {
//            return null;
//        }
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.parse(dateStr);
    }

    /**
     * 装换时间类型为字符窜类型
     */
    public static String convertDateToString(Date date, String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        sf.setLenient(false);
        return sf.format(date);
    }

    /**
     * 把时间字符串转换为另一种格式
     * 如yyyy-MM-dd HH:mm:ss ——> yyyyMMddHHmmss
     * @param dateStr:时间字符串
     * @param srcPattern:字符串本来的时间样式，如yyyy-MM-dd HH:mm:ss
     * @param targetPattern:要生成的时间样式，如yyyyMMddHHmmss
     */
    public static String convertToSpecialDateStr(String dateStr, String srcPattern, String targetPattern) throws ParseException {
        Date date = convertStringTODate(dateStr, srcPattern);
        return convertDateToString(date, targetPattern);
    }

    /**
     * 得到当前的日期时间，默认格式为 yyyy-MM-dd HH:mm:ss
     */
    public static Date getCurrentDateTime() {
        Calendar calNow = Calendar.getInstance();
        Date dtNow = calNow.getTime();
        return dtNow;
    }

    /**
     * 得到当前的日期时间
     */
    public static Date getCurrentDateTime(String pattern) throws ParseException {
        return convertStringTODate(getCurrentDateString(pattern), pattern);
    }

    /**
     * 得到当前的日期 默认格式为 yyyy-MM-dd
     */
    public static String getCurrentDateString() throws ParseException {
        return getCurrentDateString(DATE_PATTERN_YYYY_MM_DD);
    }

    /**
     * 得到当前的日期 默认格式为 yyyy-MM-dd
     */
    public static String getCurrentDateString(String pattern) throws ParseException {
        return convertDateToString(getCurrentDateTime(), pattern);
    }

    /**
     * 得到后一天
     */
    public static Date getAfterDate(String date) throws ParseException {
        return getAfterDate(convertStringTODate(date, DateUtil.DATE_PATTERN_YYYY_MM_DD));
    }

    /**
     * 得到前一天
     */
    public static Date getBeforeDate(String date) throws ParseException {
        return getBeforeDate(convertStringTODate(date, DateUtil.DATE_PATTERN_YYYY_MM_DD));
    }

    public static Date getBeforeDate(Date date) {
        return new Date(date.getTime() - 1000 * 3600 * 24);
    }

    public static Date getAfterDate(Date date) {
        return new Date(date.getTime() + 1000 * 3600 * 24);
    }

    public static Date addDate(Date date, int interval) {
        return new Date(date.getTime() + ((1000 * 3600 * 24) * interval));
    }

    /**
     * 加减分钟
     */
    public static Date addMinutes(Date startTime, int interval) {
        if (startTime == null) {
            return null;
        }
        long ms = startTime.getTime() + interval * 60 * 1000;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        return calendar.getTime();
    }

    /**
     * 得到下个时间整点
     */
    public static Date getNextHour(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.HOUR_OF_DAY, +1);
        return calendar.getTime();
    }

    /**
     * 得到下个时间整点
     *
     * @param time
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date getPreviousHour(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(calendar.HOUR_OF_DAY, -1);
        return calendar.getTime();
    }

    /**
     * 得到下个时间半点
     *
     * @param time
     * @return
     */
    public static Date getNextHalfHour(Date time) {
        Date result = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int minute = calendar.get(Calendar.MINUTE);
        if (minute >= 30) {
            result = getNextHour(time);
        } else {
            calendar.set(Calendar.MINUTE, 30);
            calendar.set(Calendar.SECOND, 0);
            result = calendar.getTime();
        }
        return result;
    }

    public static String getCurrentTimeChineseStr() {
    	SimpleDateFormat CHINESE_DATE_FORMAT      = new SimpleDateFormat(CHINESE_YYYY_MM_DD_HH_MM);
        return CHINESE_DATE_FORMAT.format(getCurrentDateTime());
    }

    /**
     * 校验日期格式
     *
     * @param strDate
     * @return
     */
    public static boolean isDateFormat(String strDate) {
        String eL = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(strDate);
        boolean b = m.matches();

        return b;
    }

    /**
     * 获得两个日期之前相差的月份<br>
     *
     * @param start
     * @param end
     * @return
     */
    public static int getMonth(Date start, Date end) {
        if (start.after(end)) {
            Date t = start;
            start = end;
            end = t;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar temp = Calendar.getInstance();
        temp.setTime(end);
        temp.add(Calendar.DATE, 1);

        int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

        if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month + 1;
        } else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month;
        } else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {

            return year * 12 + month;
        } else {
            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }
    }

    /**
     * 获得两个日期之前相差的天数<br>
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static long differ(Date fromDate, Date toDate) {
        //return date1.getTime() / (24*60*60*1000) - date2.getTime() / (24*60*60*1000);
        return toDate.getTime() / 86400000 - fromDate.getTime() / 86400000; //用立即数，减少乘法计算的开销
    }

    /**
     * 获取小时
     *
     * @param date Date
     * @return int
     */
    public static int getHourNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分钟
     *
     * @param date Date
     * @return int
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    public
    DateUtil() {
    }

    //Timestamp和String之间转换的函数：
    public static String getTimestampToString(Timestamp obj) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义格式，不显示毫秒
        String str = df.format(obj);
        return str;
    }

    /*
     * 自定义 转换模式将Timestamp 输出
     */
    public static String getTimestampToString(String formatPattern, Timestamp obj) {
        SimpleDateFormat df = new SimpleDateFormat(formatPattern);
        String str = df.format(obj);
        return str;
    }

    //String转化为Timestamp:
    public static Timestamp getStringToTimestamp(String str) {
        Timestamp ts = Timestamp.valueOf(str);
        return ts;
    }

    public static Date strToDate(String str, String pattern) {
        Date dateTemp = null;
        SimpleDateFormat formater2 = new SimpleDateFormat(pattern);
        try {
            dateTemp = formater2.parse(str);
        } catch (Exception e) {

        }
        return dateTemp;
    }



    /**
     * This method generates a string representation of a date/time in the
     * format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see SimpleDateFormat
     * @throws ParseException when String doesn't match the expected format
     */
    public static Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(aMask);


        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method returns the current date time in the format: MM/dd/yyyy HH:MM
     * a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(TIME_PATTERN, theTime);
    }


    public static Calendar getCurrentDay() {
        Calendar cal = Calendar.getInstance();
        return cal;

    }

    /**
     * This method generates a string representation of a date's date/time in
     * the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * @see SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {

        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }



    /**
     * @param aDate
     * @return
     */
    public static String convertDateToString(String pattern, Date aDate) {
        return getDateTime(pattern, aDate);
    }

    /**
     * 取得从startDate开始的前(正)/后(负)day天
     *
     * @param startDate
     * @param day
     * @return
     */
    public static Date getRelativeDate(Date startDate, int day) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH, day);
            return calendar.getTime();
        } catch (Exception e) {
            return startDate;
        }
    }

    /**
     * 请注意这个方法,它增加或者减少的日期是相对new Date()来说的，而不是相对startDate;为了避免风险，这里不做修改
     *
     * @param startdate
     * @param days
     * @return
     */
    @Deprecated
    public static Date getDate(Date startdate, int days) {
        Date dateresult = startdate;
        try {
            GregorianCalendar cal = new GregorianCalendar();

            cal.setTime(new Date());
            cal.add(GregorianCalendar.DAY_OF_MONTH, days);
            dateresult = cal.getTime();
        } catch (Exception e) {
        }
        return dateresult;
    }

    /**
     * 根据日期获取星期几
     *
     * @param date java.util.Date对象,不能为null
     * @return
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 统计两个时间差，返回的是天数(即24小时算一天，少于24小时就为0，用这个的时候最好把小时、分钟等去掉)
     *
     * @param beginStr 开始时间
     * @param endStr
     * @param Foramt
     * @return
     */
    public static int countDays(String beginStr, String endStr, String Foramt) {
        Date end = strToDate(endStr, Foramt);
        Date begin = strToDate(beginStr, Foramt);
        long times = end.getTime() - begin.getTime();
        return (int) (times / 60 / 60 / 1000 / 24);
    }

    /**
     * 统计两个时间差，返回的是天数(即24小时算一天，少于24小时就为0，用这个的时候最好把小时、分钟等去掉)
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static int countDaysOfTwo(Date fDate, Date oDate) {
        long intervalMilli = oDate.getTime() - fDate.getTime();
        return (int) (intervalMilli / (24 * 60 * 60 * 1000));
    }

    /**
     * 获取年份
     *
     * @param date Date
     * @return int
     */
    public static final int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取年份
     *
     * @param millis long
     * @return int
     */
    public static final int getYear(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     *
     * @param date Date
     * @return int
     */
    public static final int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取月份
     *
     * @param millis long
     * @return int
     */
    public static final int getMonth(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期
     *
     * @param millis long
     * @return int
     */
    public static final int getDate(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取小时
     *
     * @param date Date
     * @return int
     */
    public static final int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取小时
     *
     * @param millis long
     * @return int
     */
    public static final int getHour(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获得某年的某月有多少天
     *
     * @return
     */
    public static final int getMonthNumberByYear() {
        Calendar time = Calendar.getInstance();
        time.clear();
        time.set(Calendar.YEAR, getYear(new Date()));
        time.set(Calendar.MONTH, getMonth(new Date()) - 1);//Calendar对象默认一月为0
        int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
        return day;
    }

    /**
     * 当月的最后一天
     *
     * @param sDate
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date getLastDayOfMonth(Date sDate) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(sDate);
        final int lastDay = cDay.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date lastDate = cDay.getTime();
        lastDate.setDate(lastDay);
        //System.out.print(StringUtil.equals(String.valueOf(DateUtil.getDate(lastDate)), String.valueOf(DateUtil.getDate(new Date()))));
        return lastDate;
    }

    public static void main(String args[]) {
    	  System.out.println(stringDate("2013/12/10",2));

    }

    public static String[] splitStringBySix(String str) {
        if (null == str || "".equals(str)) {
            return null;
        }
        // 计算存放数据的数组的长度
        int arrLength = (str.length() % 6 == 0) ? str.length() / 6 : str.length() / 6 + 1;
        String[] arr = new String[arrLength];

        for (int i = 0; i < arr.length; i++) {
            // 主要是处理，最后的几位不够6位的情况
            if (i == arr.length - 1) {
                arr[i] = str.substring(i * 6);
            }
            arr[i] = str.substring(i * 6, (i + 1) * 6);
        }
        return arr;
    }

    /**
     * 组装日期字符串
     */
	public static String  dateStr(Integer date){
		if(date==null||date==0) return "";
		String dateString = date.toString();
		String year = dateString.substring(0,4);
		String month = dateString.substring(4,6);
		String day = dateString.substring(6,8);
		return year+"-"+month+"-"+day;
	}

	/**
	 * 组装时间字符串
	 * @param time
	 * @return
	 */
	public static String timeStr(Integer time){
		if(time==null||time==0) return "";
		String timeString = time.toString();
		//小时小于10的，前面补0
		if(timeString.length()==5)timeString ="0"+timeString;
		//TASK #9042=>zhouzx [开发][第三产品事业部-蔡振兴][TS:201312130314]-0点左右创建的用户，会报下标越界异常
		String h = "00";
		String s = "00";
		String m = "00";
		if(timeString.length()<=2){
			m = timeString;
		}
		if(timeString.length()>=2&&timeString.length()<6){
			 s = timeString.substring(0,2);
			 if(timeString.length()==2){
				 if(time>60){
						s = "0"+timeString.substring(0,1);
						m = "0"+timeString.substring(1,2);
				}else{
					s = timeString;
				}
			 }else if(timeString.length()==3){
				 s = timeString.substring(0,2);
				 m = "0"+timeString.substring(2,3);
			 }else if(timeString.length()==4){
				 s = timeString.substring(0,2);
				 m = timeString.substring(2,4);
			 }
		}
		if(timeString.length()>=6){
			 h = timeString.substring(0,2);
			 s = timeString.substring(2,4);
			 m = timeString.substring(4,6);
		}

		return h+":"+s+":"+m;
	}

	/**
     * 将字符串转换为日期时间类型
     *
     * @param str 日期字符串 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date convertToDateTimeByDateTimeString(String str) {
        return convertToDate(str, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将字符串转换为日期时间类型
     *
     * @param str 日期字符串 yyyy-MM-dd
     * @return
     */
    public static Date convertToDateByDateTimeString(String str) {
        return convertToDate(str, "yyyy-MM-dd");
    }

    /**
     * 将字符串转成日期时间类型
     *
     * @param str    字符串
     * @param format 格式化字符串
     * @return 转换后的日期对象
     */
    public static Date convertToDate(String str, String format) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            return date;
        }
        return date;
    }

    /**
     * 增加天
     *
     * @param date   日期，不能为空
     * @param amount 天数
     * @return
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 日期的操作
     *
     * @param date          日期，不能为空
     * @param calendarField 增加的类型，为Calendar的常量字段
     * @param amount        数量
     * @return
     */
    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }


    /**
     * 获取给定日期所在月份的第n个礼拜几的日期
     *
     * @param date         日期
     * @param weekNum      周数
     * @param dayofweekNum 星期几
     * @return
     */
    public static Date getDateInAnyWeekOfMonth(Date date, int weekNum, int dayofweekNum) {
        Date firstDateOfMonth = getFirstDateOfMonth(date);
        int dayOfWeek = getDayOfWeek(firstDateOfMonth);//这个月的第一天是星期几
        int in = dayofweekNum - dayOfWeek;//这个月第一天是在指定日期前还是后面
        int a = (weekNum - 1) * 7 + dayofweekNum - dayOfWeek;//算出指定日期是一个月的第几天
        if (in < 0) {
            a = 7 + in + (weekNum - 1) * 7;
        } else {
            a = (weekNum - 1) * 7 + dayofweekNum - dayOfWeek;
        }
        firstDateOfMonth = addDays(firstDateOfMonth, a);
        return firstDateOfMonth;
    }

    /**
     * 给定一个日期，得出这个日期对应月份的第一天的日期
     *
     * @param date
     * @return
     */
    public static Date getFirstDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }


    /**
     * 获取给定日期是星期几; 注意：星期日(1).....星期六(7)
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        return get(date, Calendar.DAY_OF_WEEK);
    }

    /**
     * 日期获取
     *
     * @param date
     * @param calendarField
     * @return
     */
    private static int get(Date date, int calendarField) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(calendarField);
    }

    /**
     * 获取给定日期所在月份的最后一个礼拜几的日期
     *
     * @param date      日期
     * @param dayofweek 礼拜几
     * @return
     */
    public static Date getDateInLastWeekOfMonth(Date date, int dayofweek) {
        Date lastDateOfMonth = getLastDateOfMonth(date);
        int wd = getDayOfWeek(lastDateOfMonth);
        int a = 0;
        if (dayofweek != wd) {
            a = dayofweek - wd - 7;
            if (Math.abs(a) > 7) {
                a = a + 7;
            }
        }
        lastDateOfMonth = addDays(lastDateOfMonth, a);
        return lastDateOfMonth;
    }

    /**
     * 给定一个日期，得出这个日期对应月份的最后一天的日期
     *
     * @param date 日期
     * @return
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.roll(Calendar.DAY_OF_MONTH, -1);
        // 每月拥有天数
        return c.getTime();
    }

    /**
     * 转换成oracle所需要的日期时间格式("yyyy-MM-dd HH24:mi:ss")
     *
     * @param date 日期
     * @return 返回oracle识别的to_date函数的日期时间字符串
     */
    public static String toOracleDateTime(Date date) {
        StringBuffer bf = new StringBuffer();
        bf.append("to_date('");
        bf.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        bf.append("','");
        bf.append("yyyy-MM-dd HH24:mi:ss");
        bf.append("')");
        return bf.toString();
    }

    /**
     * 获取当前日期所在星期的第一天(周一)和最后一天(周日)的日期
     * @return weekday:weekday[0]周一，weekday[1]周日
     */
    public static Date[] getThisWeekBeginEndDay(){
        Calendar calendar = Calendar.getInstance();
        int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK)+1; //获取一周的开始是周几,国外一周的开始是周日，+1是为了把周一当做开始
        int current = calendar.get(Calendar.DAY_OF_WEEK); //获取当天是周几
        calendar.add(Calendar.DAY_OF_WEEK, min-current); //当天-基准，获取周开始日期
        Date start = calendar.getTime();
        calendar.add(Calendar.DAY_OF_WEEK, 6); //开始+6，获取周结束日期
        Date end = calendar.getTime();
        Date[] weekday = new Date[]{start, end};
        return weekday;
    }

    /**
     *  将时间格式转成数字字符串
     *  --> 20170714165700
     * @return
     */
    public static String getTimeByCalendar() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month = cal.get(Calendar.MONTH);//获取月份
        int day = cal.get(Calendar.DATE);//获取日
        int hour = cal.get(Calendar.HOUR);//小时
        int minute = cal.get(Calendar.MINUTE);//分
        int second = cal.get(Calendar.SECOND);//秒
//        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
//        System.out.println("现在的时间是：公元" + year + "年" + month + "月" + day + "日      " + hour + "时" + minute + "分" + second + "秒       星期" + WeekOfYear);
        return String.format("%04d", year) + String.format("%02d", month) + String.format("%02d", day) + String.format("%02d", hour) + String.format("%02d", minute) + String.format("%02d", second);
    }

    /**
     * 比较二者的时间，前者比后者早，则返回true，否则返回false。
     *  @param lastDate 最后的时间
     * @param newDate 当前时间
     * @return
     */
    public static  Boolean compareDate(Date lastDate,Date newDate){
        if(lastDate.before(newDate)){
            return true;
        }
        else if(lastDate.equals(newDate)){
            return true;
        }else if(lastDate.after(newDate)){
            return false;
        }else {
            return false;
        }
    }

    /**
     * 功能说明: 获取系统当前时间的前后几秒时间
     * 系统版本: 1.0 <br>
     * 开发人员: lidf
     * 开发时间: 2017/08/20
     * <br>
     */
    public static Date getAgoDate(int seconds){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,seconds);
        Date date = calendar.getTime();
        return date;
    }

}
