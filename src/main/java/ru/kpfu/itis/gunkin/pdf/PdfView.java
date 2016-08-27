package ru.kpfu.itis.gunkin.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PdfView extends AbstractPdfView {
    private static Font catFont = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
    private static Font cellFont = new Font(Font.TIMES_ROMAN, 16, Font.NORMAL);
    private static Font cellFontBold = new Font(Font.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallNormal = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {

        Integer activeUsers = (Integer) model.get("active_users");
        Integer users = (Integer) model.get("all_users");
        Integer schoolsSale = (Integer) model.get("schools_sale");
        Integer income = (Integer) model.get("income");
        HashMap<String, Integer> schoolMap = (HashMap<String, Integer>) model.get("schools");

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("MUSIC CRM REVENUE REPORT", catFont));
        preface.add(new Paragraph("Generation date of the report: " + new Date(), smallNormal));

        addEmptyLine(preface, 2);
        Table table = new Table(3);
        table.setPadding(10);
        table.setAlignment(Element.ALIGN_LEFT);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);

        table.addCell(tableCell("Active/All users", cellFont));
        table.addCell(tableCell("Revenue", cellFont));
        table.addCell(tableCell("Schools sale", cellFont));

        table.addCell(tableCell(activeUsers + "/" + users, cellFontBold));
        table.addCell(tableCell("$" + income, cellFontBold));
        table.addCell(tableCell(String.valueOf(schoolsSale), cellFontBold));

        Paragraph schoolsData = new Paragraph();
        addEmptyLine(schoolsData, 1);
            schoolsData.add(new Paragraph("Schools information:", cellFontBold));

        int i = 1;
        for (Map.Entry<String, Integer> entry : schoolMap.entrySet()) {
            schoolsData.add(new Paragraph(i + ". " + entry.getKey() + " - " + entry.getValue(), smallNormal));
            i++;
        }

        document.add(preface);
        document.add(table);
        document.add(schoolsData);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++)
            paragraph.add(new Paragraph(" "));
    }

    private Phrase tableCell(String value, Font font) {
        return new Phrase(new Chunk(value, font));
    }
}
