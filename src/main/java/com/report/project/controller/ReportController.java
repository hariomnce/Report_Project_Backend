package com.report.project.controller;

import com.report.project.entity.Report;
import com.report.project.repository.ReportRepository;
import com.report.project.serviceImpl.ReportServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportServiceImpl reportServiceImpl;

    @GetMapping("/fetchAll")
    public List<Report> getAllReport() {
        return reportServiceImpl.getAllReport();
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        Report report = reportServiceImpl.getReportById(id);
        if (report != null) {
            return ResponseEntity.ok(report);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filtered")
    public List<Report> getFilteredReports(@RequestParam("startDate") LocalDate startDate,
                                           @RequestParam("endDate") LocalDate endDate) {
        return reportServiceImpl.getFilteredReports(startDate, endDate);
    }

    @PostMapping("/save")
    public ResponseEntity<Report> createReport(@Valid @RequestBody Report report) throws Exception {
        Report createdReport = reportServiceImpl.CreateReport(report);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReport);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Long id, @RequestBody Report report) {
        Report updateReport = reportServiceImpl.updateReport(id, report);
        return ResponseEntity.ok(updateReport);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        Optional<Report> report = reportRepository.findById(id);
        if (report.isPresent()) {
            reportServiceImpl.deleteReport(id);
            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
