package btl.simple.controller;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/excel")
public class ExcelImportController {

    private static final String NL = ("<br/>");

    @GetMapping
    public @ResponseBody String getExcel() throws IOException {
        final String SAMPLE_XLSX_FILE_PATH = "/home/jerry/temp/5833-Datensaetze-between-the-lines.xlsx";
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        DataFormatter dataFormatter = new DataFormatter();
        StringBuilder ret = new StringBuilder("Workbook has " + workbook.getNumberOfSheets() + " Sheets" + NL);
        workbook.forEach(sheet -> {
                        ret.append(NL).append("=> " + sheet.getSheetName());
                        int count = 0;
                        sheet.forEach(row -> {
                            Cell cell = row.getCell(0);
                            ret.append(NL).append(dataFormatter.formatCellValue(cell));
                        });
        });
        return ret.toString();
    }

}
