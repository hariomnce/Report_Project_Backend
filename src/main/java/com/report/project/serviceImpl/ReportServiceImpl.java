package com.report.project.serviceImpl;

import com.report.project.entity.Report;
import com.report.project.repository.ReportRepository;
import com.report.project.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<Report> getAllReport() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> getFilteredReports(LocalDate startDate, LocalDate endDate) {
        return reportRepository.findByDateBetween(startDate, endDate);
    }

    @Override
    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public Report CreateReport(Report report) throws Exception {
//        report.setDate(LocalDateTime.now());
        return reportRepository.saveAndFlush(report);
    }

    @Override
    public Report updateReport(Long id, Report report) {
        report.setId(id);
        return reportRepository.saveAndFlush(report);
    }

    @Override
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
