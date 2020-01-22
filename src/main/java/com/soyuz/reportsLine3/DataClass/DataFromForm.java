package com.soyuz.reportsLine3.DataClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataFromForm {
    private int line;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    @Override
    public String toString() {
        return "dataFromForm{" +
                "line=" + line +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }

    public int getLine() {
        return line;
    }
    public void setLine(int line) {
        if (line==0) {line=1;}
        this.line = line;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getFinishDate() { return finishDate;  }

    public void setStartDate(String startDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        this.startDate = LocalDateTime.parse(startDate, dateTimeFormatter);

    }
    public void setFinishDate(String finishDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        this.finishDate = LocalDateTime.parse(finishDate, dateTimeFormatter);
    }
}

