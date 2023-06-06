package in.ap.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import in.ap.entity.CitizenPlan;

@Component
public class ExcelGenrator {

	public void excelGenrate(HttpServletResponse response, List<CitizenPlan> records, File f) throws Exception {
		
		XSSFWorkbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("plans-data");

		Row headerrow = sheet.createRow(0);
		headerrow.createCell(0).setCellValue("Id");
		headerrow.createCell(1).setCellValue("Citizen Name");
		headerrow.createCell(2).setCellValue("Plan Name");
		headerrow.createCell(3).setCellValue("Plan Status");
		headerrow.createCell(4).setCellValue("Start Date");
		headerrow.createCell(5).setCellValue("End Date");
		headerrow.createCell(6).setCellValue("Amount");

		int i = 1;

		for (CitizenPlan plan : records) {
			Row row = sheet.createRow(i);

			row.createCell(0).setCellValue(plan.getCitizenId());
			row.createCell(1).setCellValue(plan.getCitizenName());
			row.createCell(2).setCellValue(plan.getPlanName());
			row.createCell(3).setCellValue(plan.getPlanStatus());

			if (plan.getPlanStartDate() != null) {
				row.createCell(4).setCellValue(plan.getPlanStartDate().toString());
			} else {
				row.createCell(4).setCellValue("N/A");

			}

			if (plan.getPlanEndDate() != null) {
				row.createCell(5).setCellValue(plan.getPlanEndDate().toString());
			} else {
				row.createCell(5).setCellValue("N/A");

			}

			if (plan.getBenifitAmount() != null) {
				row.createCell(6).setCellValue(plan.getBenifitAmount());
			} else {
				row.createCell(6).setCellValue("N/A");

			}

			i++;
		}
		
		FileOutputStream fileOutputStream=new FileOutputStream(f);
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}

}
