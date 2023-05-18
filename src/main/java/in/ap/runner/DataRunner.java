package in.ap.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ap.entity.CitizenPlan;
import in.ap.repo.CitizenPlanRepo;

@Component
public class DataRunner implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepo citizenPlanRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		citizenPlanRepo.deleteAll();

		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("smith");
		c1.setGender("male");
		c1.setPlanName("cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmount(5000.00);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("rani");
		c2.setGender("fe-male");
		c2.setPlanName("cash");
		c2.setPlanStatus("Denied");
		c2.setDenielReason("income is more");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("gyle");
		c3.setGender("male");
		c3.setPlanName("cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setTerminateDate(LocalDate.now());
		c3.setTerminateReason("gov job");
		
		
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Dolly");
		c4.setGender("fe-male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmount(7000.00);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Raj");
		c5.setGender("male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenielReason("age is not valid");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("roman");
		c6.setGender("male");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setTerminateDate(LocalDate.now());
		c6.setTerminateReason("salary is more");
		
		
		
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Shital");
		c7.setGender("fe-male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmount(8000.00);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("vijay");
		c8.setGender("male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenielReason("age is not valid");

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("omkar");
		c9.setGender("male");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setTerminateDate(LocalDate.now());
		c9.setTerminateReason("property is more");
		
		List<CitizenPlan> l = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9);
		
		citizenPlanRepo.saveAll(l);

	}

}
