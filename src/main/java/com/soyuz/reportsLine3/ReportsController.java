package com.soyuz.reportsLine3;

import com.soyuz.reportsLine3.DataClass.DataFromForm;
import com.soyuz.reportsLine3.Entity.ReportsProduct;
import com.soyuz.reportsLine3.repository.ReportsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ReportsController {

    private ReportsDataService service;
    private List<ReportsProduct> reportDataFiltred;
    private float totalWeight;

    @Autowired
    public void setReportsService(ReportsDataService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        model.addAttribute("dataFromForm", new DataFromForm());
        return "reports";
    }

    @RequestMapping(value = "/showReportData", method = RequestMethod.POST)
    public String getReport(@ModelAttribute DataFromForm dataFromForm, Model model) {
        reportDataFiltred = service.getReport(dataFromForm);
        totalWeight=service.getTotalWeight(reportDataFiltred);
        model.addAttribute("reportDataFiltred", reportDataFiltred);
        model.addAttribute("totalWeight", totalWeight);

        return "table";
    }

    @RequestMapping( value = "/exportCSV")
    public String exportData(Model model) throws IOException {
     service.exportCSV(reportDataFiltred);
     String messageSaveReport="Отчет сохранен по пути с:\\csv";
     model.addAttribute("reportDataFiltred", reportDataFiltred);
     model.addAttribute("messageSaveReport",messageSaveReport);
     model.addAttribute("totalWeight", totalWeight);
       return "table";
    }

}
