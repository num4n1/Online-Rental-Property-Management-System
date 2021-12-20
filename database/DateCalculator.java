
/*
    DateCalculator.java
    Author Chace Nielson
    Date Thursday, December 2, 2021

  

*/

package database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * helper class to preform Date calculations 
 */
public class DateCalculator{
    /**
     * 
     * @param x numb of days
     * @return todays date + x days as a Date object
     */
    public Date addDaysToToday(int x){
      Date currentDate = new Date();
      Calendar c = Calendar.getInstance();
      c.setTime(currentDate);
      c.add(Calendar.DATE, x); //same with c.add(Calendar.DAY_OF_MONTH, 1);
      Date currentDatePlusOne = c.getTime();
      return currentDatePlusOne;
    }//end fucntion 

    
    /**
     * 
     * @param a Date
     * @param x days to add
     * @return the date + x days as  date object
     */
    public Date addDaysToDate(Date a, int x){
      Calendar c = Calendar.getInstance();
      c.setTime(a);
      c.add(Calendar.DATE, x); 
      Date datePlusOne = c.getTime();
      return datePlusOne;
    } // end function 


    /**
     * 
     * @return returns todays date as a date object
     */
    public Date getTodaysDate(){
      Date currentDate = new Date();
      return currentDate;
    } //end
    
    /**
     * retuns true is arg date has already passed
     * @param d a date object
     * @return true is today is after date passed in else reutn false 
     */
    public boolean dateHasPassed(Date d){
      // if it is null it is also expired
      if(d==null){
        return true;
      }

      if( getTodaysDate().after(d) ) { // today is after the expiration date
        return true; // the posting is expired
      }else {
        return false; // th date hasn't passed yet
      }
    } //end fucntion



    /**
     * 
     * @param a a date object
     * @return string formate of date with SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
     */
    public String datetoString(Date a){
     if(a ==null){
       return "null";
     }
     
      final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // set a date format
      return  dateFormat.format(a);
    }//end fuicntion 
    
    
    /**
     * 
     * @param a a date object
     * @return string formate of date with SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
     */
    public String datetoStringwSlash(Date a){
     if(a ==null){
       return "null";
     }
      final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // set a date forma
      String b = "\""+ dateFormat.format(a)  +"\"";
      return  b;
    }//end fuicntion 
    
    
    
    
    public Date stringToDate(String date)throws Exception{
      // String a="31/12/1998";  
      // String sDate1="2021/12/01 23:32:28";  
      Date newDate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date);  
      // System.out.println(date+"\t"+newDate);  
      return newDate;
    }//end fuicntion 


}//end class



