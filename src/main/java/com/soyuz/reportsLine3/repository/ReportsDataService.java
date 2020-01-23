package com.soyuz.reportsLine3.repository;

import com.soyuz.reportsLine3.DataClass.DataFromForm;
import com.soyuz.reportsLine3.Entity.ReportsProduct;
import com.soyuz.reportsLine3.Utils.CsvExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReportsDataService {

    public ReportsDataService(ReportsRepository reportsRepository) {
        this.reportsRepository = reportsRepository;
    }
    @Autowired
    private final ReportsRepository reportsRepository;

    public List<ReportsProduct> getReport(DataFromForm dataFromForm) {
        return reportsRepository.findAllByDateGreaterThanEqualAndDateLessThanEqualAndLineEquals(
                dataFromForm.getStartDate(),
                dataFromForm.getFinishDate(),
                dataFromForm.getLine());
    }

    public float getTotalWeight(List<ReportsProduct> dataReport) {
        float totalWeight = 0;
        for (ReportsProduct r : dataReport) {
            totalWeight += r.getWeight();
        }
        return totalWeight;
    }

    public void exportCSV(List<ReportsProduct> dataForExport) throws IOException {
        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
        String csvFile = "C:\\csv\\report" + timeNow.format(formater) + ".csv";
        FileWriter writer = new FileWriter(csvFile);
        //for header
        CsvExport.writeLine(writer, Arrays.asList("Id", "Date", "Line", "Filler", "Product", "Weight"));
        for (ReportsProduct r : dataForExport) {

            List<String> list = new ArrayList<>();
            list.add(String.valueOf(r.getId()));
            list.add(r.getDate().toString());
            list.add(String.valueOf(r.getLine()));
            list.add(String.valueOf(r.getFiller()));
            list.add(r.getProduct());
            list.add(String.valueOf(r.getWeight()));
            CsvExport.writeLine(writer, list);

        }
        writer.flush();
        writer.close();

    }
}
