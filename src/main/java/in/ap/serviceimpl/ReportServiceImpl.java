package in.ap.serviceimpl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ap.entity.CitizenPlan;
import in.ap.repo.CitizenPlanRepo;
import in.ap.request.SearchRequest;
import in.ap.service.ReportService;
import in.ap.utils.EmailUtils;
import in.ap.utils.ExcelGenrator;
import in.ap.utils.PdfGenrator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepo repo;
	
	@Autowired
	private ExcelGenrator excelGenrator;
	
	@Autowired
	private PdfGenrator pdfGenrator;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanNames() {
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
			String date = request.getPlanStartDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// convert String to LocalDate
			LocalDate localDate = LocalDate.parse(date, formatter);

			entity.setPlanStartDate(localDate);

		}
		if (null != request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {
			String date = request.getPlanEndDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// convert String to LocalDate
			LocalDate localDate = LocalDate.parse(date, formatter);

			entity.setPlanEndDate(localDate);

		}

		Example<CitizenPlan> search = Example.of(entity);

		return repo.findAll(search);
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {

		File f=new File("plans.xls");
		
		List<CitizenPlan> records = repo.findAll();
		
		excelGenrator.excelGenrate(response, records,f);
		
		String subject="Excel report of Citizen plans";
		String body="<h1>Kindly find below attached documents </h1>";
		String to="akshaypatil781997@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,f);
		
		f.delete();

		return true;
	}


	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		File f=new File("plans.pdf");
		
		List<CitizenPlan> records = repo.findAll();
		
		pdfGenrator.genratePdf(response, records,f);
		
		String subject="Pdf report of Citizen plans";
		String body="<h1>Kindly find below attached documents </h1>";
		String to="akshaypatil781997@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,f);
		
		f.delete();
		
		return true;
	}

	

}
