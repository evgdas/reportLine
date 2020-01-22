package com.soyuz.reportsLine3.repository;

import com.soyuz.reportsLine3.Entity.ReportsProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReportsRepository extends CrudRepository <ReportsProduct, Long> {
    List<ReportsProduct> findAll ();
    List<ReportsProduct> findAllByDateGreaterThanEqualAndDateLessThanEqualAndLineEquals (
            LocalDateTime startDate,
            LocalDateTime finishDate,
            int line);
      @Query("SELECT SUM(weight) FROM ReportsProduct")
      public Float selectTotalsWeight();

}
