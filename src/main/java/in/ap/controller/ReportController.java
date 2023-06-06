package in.ap.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ap.entity.CitizenPlan;
import in.ap.request.SearchRequest;
import in.ap.service.ReportService;

@Controller
public class ReportController {

	private ReportService service;

	@Autowired
	public ReportController(ReportService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
	}

	@PostMapping("/search")
	public String handleSearch(SearchRequest request, Model model) {
		
		init(model);
		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		model.addAttribute("search", request);

		return "index";
	}
	
	@GetMapping("/excel")
	public void exelExport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		
		response.addHeader("content-Disposition", "attachment;filename=plans.xlsx");
		
		service.exportExcel(response);
		
	}
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		
		response.addHeader("content-Disposition", "attachment;filename=plans.pdf");
		
		service.exportPdf(response);
		
	}

}
