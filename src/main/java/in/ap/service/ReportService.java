package in.ap.service;

import java.util.List;

import in.ap.entity.CitizenPlan;
import in.ap.request.SearchRequest;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel();
	
	public boolean exportPdf();

}
