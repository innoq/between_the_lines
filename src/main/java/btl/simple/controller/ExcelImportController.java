package btl.simple.controller;

import btl.simple.candidate.Candidate;
import btl.simple.candidate.CandidateService;
import btl.simple.candidate.CandidateValidationService;
import org.apache.poi.ss.usermodel.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

@Controller
@RequestMapping(value = "/excel")
public class ExcelImportController {

    private static final String NL = ("<br/>");
    private static final DataFormatter DATA_FORMATTER = new DataFormatter();

    @Autowired
    CandidateValidationService candidateValidationService;

    @Autowired
    CandidateService candidateService;

    @PostMapping
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {
        System.out.println("Receiving excel file");
        String store = saveFile(file);
        System.out.println("stored");
        String msg = parseExcelFile(store).toString();
        System.out.println("parsed");
        System.out.println(msg);
        redirectAttributes.addFlashAttribute("message",
            msg);
        return "redirect:/";
    }

    private String saveFile(MultipartFile file) throws IOException {
        File store = File.createTempFile("ExcelUpload", ".xlsx");
        System.out.println("Writing to " + store.getAbsolutePath());
        java.nio.file.Files.copy(
            file.getInputStream(),
            store.toPath(),
            StandardCopyOption.REPLACE_EXISTING);
        IOUtils.closeQuietly(file.getInputStream());
        return store.getAbsolutePath();
    }

    @GetMapping
    public @ResponseBody String getExcel() throws IOException {
        final String SAMPLE_XLSX_FILE_PATH = "/home/jerry/temp/5833-Datensaetze-between-the-lines.xlsx";
        System.out.println("Parsing sample file");
        StringBuilder ret = parseExcelFile(SAMPLE_XLSX_FILE_PATH);
        return ret.toString();
    }

    private StringBuilder parseExcelFile(String path) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File(path));
        StringBuilder ret = new StringBuilder("Workbook has " + workbook.getNumberOfSheets() + " Sheets" + NL);
        workbook.forEach(sheet -> {
                        ret.append(NL).append("=> " + sheet.getSheetName());
            LinkedList<Candidate> candidates = new LinkedList<>();
            sheet.forEach(row -> {
                            Candidate candidate = parseRow(row);
                            candidates.add(candidate);
                        });
            ret.append(NL).append("Read " + candidates.size() + " entries");
            candidateValidationService.validateCandidates(candidates);
        });
        return ret;
    }

    private Candidate parseRow(Row row) {
        Cell next = row.getCell(0);
        String name = DATA_FORMATTER.formatCellValue(next);
        next = row.getCell(1);
        String address = DATA_FORMATTER.formatCellValue(next);
        next = row.getCell(2);
        String postalCode = DATA_FORMATTER.formatCellValue(next);
        next = row.getCell(3);
        String location = DATA_FORMATTER.formatCellValue(next);
        next = row.getCell(4);
        String state = DATA_FORMATTER.formatCellValue(next);
        next = row.getCell(5);
        String phoneNumbers = DATA_FORMATTER.formatCellValue(next);
        next = row.getCell(6);
        String mail = DATA_FORMATTER.formatCellValue(next);
        next = row.getCell(7);
        String website = DATA_FORMATTER.formatCellValue(next);
        Candidate candidate = candidateService.getCandidate(name, address, postalCode, location, state, phoneNumbers, mail, website);
        return candidate;
    }

}
