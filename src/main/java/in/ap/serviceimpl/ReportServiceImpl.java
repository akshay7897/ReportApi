package in.ap.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ap.entity.CitizenPlan;
import in.ap.repo.CitizenPlanRepo;
import in.ap.request.SearchRequest;
import in.ap.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlanRepo repo;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
