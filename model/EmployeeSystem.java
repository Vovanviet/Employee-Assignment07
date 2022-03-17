package com.example.model;


import com.example.entity.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CustomException extends Exception {
    private static final long serialVersionUID=1L;
    public CustomException(String str){
        super();
        System.out.println(str);
    }
}
public class EmployeeSystem {
     public static Map<Integer, Employee>map=new HashMap();
     public static void addEmployee(String name,int age,int id){
         Employee emp=new Employee(name,age,id);
         map.put(id,emp);
     }
     public static void deleteEmployee(int EmpID) throws CustomException{
        if (map.containsKey( EmpID)) {
            map.remove(EmpID);
            System.out.println("Successfully deleted!");
         }
        else {
            throw new CustomException("Not Found Exception");
        }
     }
     public static void searchEmployee(int EmpID) throws CustomException{
         if (map.containsKey( EmpID)) {
             map.get(EmpID);
             System.out.println("Employee Details: "+map.get(EmpID));
         }
         else {
             throw new CustomException("Not Found Exception");

         }
         operations();
     }
     public static void employeeList(){
         System.out.println(map.toString());
     }

     public static void operations(){
         System.out.println("\n ********Employee Management System************");
         System.out.println("1.Add Employee");
         System.out.println("2.Delete Employee");
         System.out.println("3.Search Employee");
         System.out.println("4.Employee List ");
         Scanner input=new Scanner(System.in);
         int userInput=input.nextInt();
         if (userInput==1){
             System.out.println("Enter Employee Details(Name,Age,ID):");
             Scanner input1=new Scanner(System.in);
             String name=input1.next();
             int age=input1.nextInt();
             int id=input1.nextInt();
             if (!name.equals("") && age!=0 &&id!=0){
                 addEmployee(name,age,id);
             }operations();
         }else if (userInput==2){
             System.out.println("Enter Employee ID");
             Scanner input2=new Scanner(System.in);
             int EmpID=input2.nextInt();
             try{
                deleteEmployee(EmpID);
             }catch (CustomException e){
                 e.printStackTrace();
             }
             operations();
         }else if ( userInput==3){
             System.out.println("Enter Employee ID");
             Scanner input3=new Scanner(System.in);
             int EmpId=input3.nextInt();
             try{
                 searchEmployee(EmpId);
             }catch (CustomException e){
                 e.printStackTrace();
             }
             operations();
         }else if (userInput==4){
             employeeList();
             operations();
         }
     }

    public static void main(String[] args) {
        operations();
    }
}
