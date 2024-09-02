package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.*;

class Employee {
    String name;
    int salary;

    // Constructor, getters, and setters

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

// *********** Direct use

// Arrays.sort(arr, new Comparator<int[]>() {
//     public int compare(int[] a, int[] b) {
//         return a[0] - b[0];
//     }
// });

// *********** LAMBDA EXP

// Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);



class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getSalary() - e2.getSalary();
    }
}

public class custom_comparator {
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        // Add employees to the list

        // Sort by salary using the custom comparator
        Collections.sort(employees, new SalaryComparator());

        // Print the sorted employees
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.getSalary());
        }
    }
}
