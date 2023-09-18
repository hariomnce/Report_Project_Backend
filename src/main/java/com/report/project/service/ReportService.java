package com.report.project.service;

import com.report.project.entity.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {

    List<Report> getAllReport();

    Report getReportById(Long id);

    Report CreateReport(Report report) throws Exception;

    Report updateReport(Long id, Report report);

    void deleteReport(Long id);

}
