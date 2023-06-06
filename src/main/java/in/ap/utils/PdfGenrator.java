package in.ap.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ap.entity.CitizenPlan;

@Component
public class PdfGenrator {
	
	
	
	public void genratePdf(HttpServletResponse response,List<CitizenPlan> records, File f) throws Exception {
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);
		
		Paragraph paragraph = new Paragraph("Citizen Records", fontTiltle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(paragraph);

		PdfPTable table = new PdfPTable(8);
		
		table.setWidthPercentage(100f);
		table.setWidths(new int[] {3,3,3,3,3,3,3,3});
		table.setSpacingBefore(5);
		
		// Create Table Cells for table header
				PdfPCell cell = new PdfPCell();

				// Setting the background color and padding
				cell.setBackgroundColor(CMYKColor.MAGENTA);
				cell.setPadding(5);

				// Creating font
				// Setting font style and size
				Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				font.setColor(CMYKColor.WHITE);

				// Adding headings in the created table cell/ header
				// Adding Cell to table
				cell.setPhrase(new Phrase("ID", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("Citizen Name", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("Gender", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("Plan Name", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("Plan Status", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("Start Date", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("End Date", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("Amount", font));
				table.addCell(cell);
				

				
				// Iterating over the list of students
				for (CitizenPlan plan : records) {
					// Adding student id
					table.addCell(String.valueOf(plan.getCitizenId()));
					table.addCell(plan.getCitizenName());
					table.addCell(plan.getGender());
					table.addCell(plan.getPlanName());
					table.addCell(plan.getPlanStatus());
					if(plan.getPlanStartDate()!=null) {
					table.addCell(plan.getPlanStartDate().toString());
					}else {
						table.addCell("N/A");

					}
					if(plan.getPlanEndDate()!=null) {
					table.addCell(plan.getPlanEndDate().toString());
					}else {
						table.addCell("N/A");

					}
					if(plan.getBenifitAmount()!=null) {
					table.addCell(plan.getBenifitAmount().toString());
					}else {
						table.addCell("N/A");

					}
					
				}
				
				// Adding the created table to document
				document.add(table);

				// Closing the document
				document.close();
				


		
	}

}
