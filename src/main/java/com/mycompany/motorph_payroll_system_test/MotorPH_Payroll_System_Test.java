/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.motorph_payroll_system_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Cha
 */
public class MotorPH_Payroll_System_Test {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Data data = new Data();
        Scanner inputscan = new Scanner(System.in); 
        ArrayList<Integer> test1 = new ArrayList<>();
        
        ArrayList<String> firstname = new ArrayList<>();
        ArrayList<String> lastname = new ArrayList<>();
        ArrayList<String> grosswage = new ArrayList<>();
        
//----------------------------------------- This part is for  reading firstname-----------------------------------        
        File file1 =new File("C:\\Users\\charm\\Documents\\NetBeansProjects\\MotorPH_Payroll_System_Test\\firstname.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        
        String fn;
        
        while((fn=br1.readLine())!=null){// save the content into variable fn
            firstname.add(fn);    // save every content to array                   
        }
//------------------------------------ This part is for reading lastname----------------------------------------           
       File file2 =new File("C:\\Users\\charm\\Documents\\NetBeansProjects\\MotorPH_Payroll_System_Test\\lastname.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        
        String ln ;
        
        while((ln=br2.readLine())!=null){
            lastname.add(ln);                       
        }
//------------------------------------ This part is for reading gross wage--------------------------------------        
        File file3 =new File("C:\\Users\\charm\\Documents\\NetBeansProjects\\MotorPH_Payroll_System_Test\\grosswage.txt");
        BufferedReader br3 = new BufferedReader(new FileReader(file3));
        
        String gw ;
        
        while((gw=br3.readLine())!=null){
            grosswage.add(gw);                       
        }   
//---------------------------------------------------------------------------------------------------------------             
        
             
        System.out.println("Enter Employee Number: ");
        boolean success = false;
        
        while(!success){
            
            try{
                int input = inputscan.nextInt();// save user output to variable enterNum
                int n = input-10001;
                int arrayTest = data.empNum[n];// to test if given employee number is within array
                test1.add(n);
                                
                success=true;               
            }
            catch(Exception e){
                System.out.println("Employee number is invalid. Enter new Employee Number: ");
                inputscan.nextLine();
            }
        }
        int eNum = test1.get(0);
                
//-------------------------------- Show Employee Details----------------------------------------------------------

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Employee Details");
        System.out.println();
        System.out.println(data.header[0]+data.empNum[eNum]);//index header and Employee Number
        
//-------------------------- Application of File Handling-----------------------------------------------------        
        System.out.println(data.header[1]+lastname.get(eNum));//index header and use lastname from arraylist
        System.out.println(data.header[2]+firstname.get(eNum));//index header and first name from arraylist
//---------------------------------------------------------------------------------------------------------------        
        
        System.out.println(data.header[3]+data.birthday[eNum]);//index header and birthday
        System.out.println(data.header[4]+data.address[eNum]);//index header and address
        System.out.println(data.header[5]+data.phoneNum[eNum]);//index header and phone number
        System.out.println(data.header[6]+data.sssNum[eNum]);//index header and SSS number
        System.out.println(data.header[7]+data.phNum[eNum]);//index header and Philhealth number
        System.out.println(data.header[8]+data.tinNum[eNum]);//index header and Tin number
        System.out.println(data.header[9]+data.pgbNum[eNum]);//index header and pagibig number
        System.out.println(data.header[10]+data.status[eNum]);//index header and status
        System.out.println(data.header[11]+data.position[eNum]);//index header and position
        System.out.println(data.header[12]+data.sup[eNum]);//index header and supervisor
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Salary and Other Benefits");
        System.out.println();
        
//-------------------------- Application of File Handling-----------------------------------------------------
        System.out.println(data.header[13]+grosswage.get(eNum));//index header and salary
//---------------------------------------------------------------------------------------------------------------           
        System.out.println(data.header[14]+data.rice[eNum]);//index header and rice subsidy
        System.out.println(data.header[15]+data.phone[eNum]);//index header and phone allowance
        System.out.println(data.header[16]+data.cloth[eNum]);//index header and salary
        System.out.println(data.header[17]+data.sal[eNum]/2);//index header and compute gross semi month rate
        System.out.println(data.header[18]+data.sal[eNum]/(21*8));//index header and compute hourly rate*/        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        
        
//-------------------------------- Verify Attendance ----------------------------------------------------------        
        
    
        
        Attendance attend = new Attendance();//create object for class Attendance to use Time in and out Array
        Scanner enterdate = new Scanner(System.in);
        Scanner enterloop = new Scanner(System.in);
        
        
        
        String[] sdateArray = attend.timein[eNum];//index the time in array of the employee and save to variable 
        String[] edateArray = attend.timeout[eNum];//index the time out array of the employee and save to variable       
       
        
        
        ArrayList<String> test2 = new ArrayList<>();
        
        SimpleDateFormat format1 = new SimpleDateFormat("M/d/yyyy HH:mm:ss");  
        SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
        
    int l =0;
    do{
        
        System.out.println("Enter the date of attendance you want to verify between Sept-Dec 2022 excluding holidays [MM/DD/yyyy]:");
               
        boolean success2 = false; // try catch statement to check if the input date has the right format       
        while(!success2){
            
            try{
                                                                                    
                String testDate = enterdate.next();// save user output to variable enterNum  
              
                Date inputDate = format2.parse(testDate);                    
                test2.add(0,testDate);                                                                                 
                 
                success2=true;                                  
            }
            catch(ParseException e){
                System.out.println("Date is invalid. Enter new Date: ");
                
            }            
        }
        String userdate = test2.get(0);// save the enterdate to the arraylist userdate
                            
        for(int j=0;j<sdateArray.length;j++){ // this loop is to go through all the items of the time in and time out                                  
            Date arr1date = format2.parse(sdateArray[j]);// saves the time in array of employee to variable arr1date
            Date arr2date = format2.parse(edateArray[j]);//saves the time out array of employee to variable
            Date usedate  = format2.parse(userdate);// saves input date of user to variable use date

            if(usedate.compareTo(arr1date)==0){// compares the userdate to the current array
                arr1date = format1.parse(sdateArray[j]);// time in array of employee
                arr2date = format1.parse(edateArray[j]);// time out array of employee
                float newd = arr2date.getTime()-arr1date.getTime();// subtract time in to time out
                float tnewd =newd/(1000*60*60); // converts the time microseconds to hours and saves to variable tnewd
                if (tnewd >= 53/6){// this tests if total time is 8 hours and 50 minutes and more, it assigns 9 to time                    
                    tnewd = 9;                   
                }
                
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Hours Worked on "+userdate+" including lunch time is:\t"+tnewd);
                System.out.println();
                if (tnewd> 0 & tnewd < 9){// if-elseif-else condition is to comment whether the employee completed the time
                    System.out.println("Employee is undertime this day."); 
                }
                else if (tnewd > 9){
                    System.out.println("Employee is overtime this day.");
                }                           
                else if (tnewd == 0 ){
                    System.out.println("Employee is absent this day.");
                }                                   
                else{
                    System.out.println("Employee completed this day's working hours.");  
                }              
                
                       
            }
        }
        System.out.println();
        System.out.println("Do you want to verify another date? Type 1 if Yes and 0 if No :" );
        int loop = enterloop.nextInt();
        System.out.println();
        if(loop==0){
            break;
        }
               
    l++;
    }while(l>0);// this loop is to continue asking for test date
//-------------------------------- Compute Hours Worked ----------------------------------------------------------         
    
    
        Scanner inputScanner3 = new Scanner(System.in);
        Scanner inputScanner4 = new Scanner(System.in);
       
        ArrayList<Date> test3 = new ArrayList<>();// array lists are used to grab the value inside the try catch
        ArrayList<Date> test4 = new ArrayList<>();
        ArrayList<Integer> test5 = new ArrayList<>();
        ArrayList<Integer> test6 = new ArrayList<>();
        ArrayList<String> test7 = new ArrayList<>();
        
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Compute Hours Worked");
        System.out.println();
        
        boolean success3 = false;        
        while(!success3){
            
            try{// try catch loop to see if the user inputs the right date
                               
                System.out.println("Enter Start Date: ");
                String in = inputScanner3.next();// save user output to variable enterNum                               
                                
                Date dateIn = format2.parse(in);
                
                test7.add(in);          
                test3.add(dateIn);                
                                                                                            
                success3=true;                                  
            }
            catch(ParseException e){
                System.out.println("Date is invalid.");               
            } 
       
        }
        Date compDateStart = test3.get(0);
        
        
        success3 = false;        
        while(!success3){// reiterates the user input
            
            try{// try catch loop to see if the user inputs the right date
                                                
                
                System.out.println("Enter End Date: ");
                String out = inputScanner4.next();
                               
                Date dateOut = format2.parse(out);
                                          
                test4.add(dateOut);   
                test7.add(out);                                                            
                 
                success3=true;                 
                 
            }
            catch(ParseException e){
                System.out.println("Date is invalid.");
                
            } 
       
        }
      
        Date compDateEnd = test4.get(0);
        
        
        for (int i =0; i< sdateArray.length;i++){     //limit of loop is the length on the elements in Array
           Date dStart = format2.parse(sdateArray[i]);   //Parse the String time in/out and save to Date datatype and variable d1
            
           if (dStart.compareTo(compDateStart)==0){               
                test5.add(i);     // saves the index within the array of input date                          
                
            }                                           
           
        }   
        
        for (int i =0; i< sdateArray.length;i++){     //limit of loop is the length on the elements in Array
              
           Date dEnd = format2.parse(sdateArray[i]); 
           if (dEnd.compareTo(compDateEnd)==0){               
                test6.add(i); // saves the index within the array of end date
                
           }
        }   
       
          
            int indexStart = test5.get(0);// saves the index to variable indexStart 
           
            int indexEnd = test6.get(0);// saves the index to variable indexEnd
            
            
            float tsum1= 0;                       
            for (int k =indexStart; k<=indexEnd;k++){ // this loop gets the total time from start date to end date input
                Date t1 = format1.parse(sdateArray[k]);                               
                Date t2 = format1.parse(edateArray[k]);               
                                                                  
                float t = t2.getTime() - t1.getTime()-(60 * 60 * 1000);                
                float ttest =  t/(60 * 60 * 1000);
                                
                if (ttest >= 47/6){ // this test is to assign a complete 8 hours if the employee is late within 10 minutes                   
                    ttest = 8;                    
                }
                tsum1 = tsum1 + ttest;                                                                                                 
            }
            
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");    
            System.out.println("Total Hours Worked excluding lunch time:\t\t"+tsum1);
             
            
//------------------------------------- Show Payslip----------------------------------------------------------------------------        
            
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------"); 
            System.out.println("PAYSLIP");            
            System.out.println();
            System.out.println("Name:\t\t"+lastname.get(eNum)+","+firstname.get(eNum));//get names using the file handling
            System.out.println("Position:\t"+data.position[eNum]);  
            System.out.println("Salary Period: "+test7.get(0)+" to "+test7.get(1)); 
            System.out.println();
            System.out.println();
            System.out.println("EARNINGS");
            System.out.println("(Note: Salary Earned is temporarily based on hourly rate)");
            System.out.println();
            float sal =  data.sal[eNum]/(21*8)*(tsum1);// compute salary using hours worked
            System.out.println("Salary Earned for the Period: "+sal);
            System.out.println();    
            System.out.println();
               
            
            System.out.println("Benefits");// gets value from all the Data class using array indexing
            System.out.println("Rice Subsidy:\t\t"+data.rice[eNum]);
            System.out.println("Phone Allowance:\t"+data.phone[eNum]); 
            System.out.println("Clothing Allowance:\t"+data.cloth[eNum]);
            float benefits = data.rice[eNum]+ data.phone[eNum]+data.cloth[eNum];
            
            System.out.println();
            
            float gs = benefits+sal;
            System.out.println("Gross Salary:\t\t"+ gs);
            
            System.out.println();
            System.out.println("DEDUCTIONS");
            //System.out.println("Late:\t");
            //System.out.println("Absences:\t");
            System.out.println();
            
            
            System.out.println("Government Deductions");
            
//----------------------------- Compute SSS deduction----------------------------------------------------            
            double sss;// if-elseif-else statement is to check the category of the salary  
            if(data.sal[eNum]<=3250){
                sss = 135;
            }
            else if(data.sal[eNum]>3250 & data.sal[eNum]<=24750) {
               if(data.sal[eNum]%1000==250 |data.sal[eNum]%1000==750 ){// this check whether the salary is in the lower/upper bound of range. 
                   float mod = (data.sal[eNum]-3250)%500; // after deducting 3250, in every 500 increment, the sss increases by 22.5
                    float multiplier = ((data.sal[eNum]-3250-mod)/500);              
                    sss = (22.5*(multiplier))+135;                        
               }
                else{// this applies the normal formule is salary falls within the range
                    float mod = (data.sal[eNum]-3250)%500; 
                    float multiplier = ((data.sal[eNum]-3250-mod)/500);              
                    sss = (22.5*(multiplier+1))+135;           
               }
            }
            else{
                sss = 1125;
            }    
            System.out.println("SSS:\t\t"+sss);
//---------------------------------- Compute Philhealth deduction------------------------------------------  
           double ph;
          
           if(data.sal[eNum]<=10000){//if-elseif-else statement checks the range of salary and applies formula in each range
               ph = 300/2;
               
           }
           else if (data.sal[eNum]>10000 & data.sal[eNum]<60000){
               ph = data.sal[eNum]*(0.03)/2;
           }
           else{
               ph = 1800/2;
           }

            System.out.println("Philhealth:\t"+ph);
//---------------------------------- Compute PAG-IBIG deduction------------------------------------------  
        double pagibig;
        
        if(data.sal[eNum]>1000 & data.sal[eNum]<=1500){//if-else statement checks the range of salary and applies formula in each rang
            pagibig = data.sal[eNum]*0.01;
        } 
        else{
            if(data.sal[eNum]*0.02 <100){// this nested if-else statement provides the pagibig to be 100 if the values exceeds 100
              pagibig= data.sal[eNum]*0.02;
            }
            else{
                pagibig = 100;
            }
        }


            System.out.println("Pag-IBIG:\t"+pagibig);
            
            
            double taxable = data.sal[eNum]-sss-pagibig-ph;// saves all the deduction to get taxable income and save to variable taxable
            System.out.println();
            System.out.println("Taxable Income:   "+taxable);
            
//---------------------------------- Compute for Withholding Tax ------------------------------------------  
            double tax;
            
            if(data.sal[eNum] <=20832){//if-elseif-else statement checks the range of taxable income and applies formula in each range 
                tax = 0;
            }
            else if(data.sal[eNum]>20832 & data.sal[eNum]<33333){
                tax = (taxable-20833)*0.2;               
            }
            else if(data.sal[eNum]>=33333 & data.sal[eNum]< 66667){
                tax = (taxable-33333)*0.25+2500;
            }
            else if(data.sal[eNum]>=66667 & data.sal[eNum]< 166667){
                tax = (taxable-66667)*0.3+10833;
            }
            else if(data.sal[eNum]>=166667 & data.sal[eNum]< 666667){
                tax = (taxable-166667)*0.32+40833.33;
            }
            else{
                tax = (data.sal[eNum]-666667)*0.35+200833.33;
            }
            
            System.out.println("Withholding Tax:  "+(float)tax);
            System.out.println();
            
            float td = (float) (sss+pagibig+ph+tax);// casts double to float
            System.out.println("Total Deductions: "+td);
            System.out.println();
            System.out.println();
            
            float net = gs-td;// applies deduction and saves to variable net
            System.out.println("Net Salary:       "+net);    
        
            
    inputscan.close();// close all scanner
    enterdate.close();
    inputScanner3.close();
    inputScanner4.close();                       
        
        
       
    }
}
