package coreservlets.missing;

import coreservlets.streams.Employee;
import coreservlets.streams.EmployeeSamples;

public class EmployeeUtils {

	public static Employee findById(Integer id) {
		return EmployeeSamples.getSampleEmployees().stream()
				.filter(e -> e.getEmployeeId() == id)
				.findFirst().orElse(null);
	}
}
