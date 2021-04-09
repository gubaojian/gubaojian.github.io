package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeTest {

    public static void main(String[] args){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, "Gu Baojian"));
        employeeList.add(new Employee(8, "谷宝剑"));
        employeeList.add(new Employee(3, "运配"));
        employeeList.add(new Employee(2, "分拨"));
        employeeList.add(new Employee(4, "分拨"));

       Map<String, List<Employee>> employeeMap =  employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        Iterator<Map.Entry<String,List<Employee>>> it =  employeeMap.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String,List<Employee>> entry = it.next();
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }


    }
}
