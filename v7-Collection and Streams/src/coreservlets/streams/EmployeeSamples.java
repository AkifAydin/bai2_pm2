package coreservlets.streams;

import java.util.*;

public class EmployeeSamples {
  private static final List<Employee> SAMPLE_EMPLOYEES = 
    Arrays.asList(
      new Employee("Harry", "Hacker", 1, 234567),
      new Employee("Polly", "Programmer", 2, 333333),
      new Employee("Cody", "Coder", 8, 199999), 
      new Employee("Devon", "Developer", 11, 175000),
      new Employee("Desiree", "Developer", 14, 212000),
      new Employee("Archie", "Architect", 16, 144444),
      new Employee("Tammy", "Tester", 19, 166777),
      new Employee("Sammy", "Sales", 21, 45000),
      new Employee("Larry", "Lawyer", 22, 33000),
      new Employee("Amy", "Architect", 25, 85000) );
  
  public static List<Employee> getSampleEmployees() {
    return(SAMPLE_EMPLOYEES);
  }
  
  private EmployeeSamples() {} // Uninstantiatable class
}
