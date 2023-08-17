package com.study.design_pattern._01_creational_patterns._04_builder._02_after;

import com.study.design_pattern._01_creational_patterns._04_builder._01_before.TourPlan;

import java.time.LocalDate;

public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;
    
    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }
    
    public TourPlan cancunTrip() {
        return tourPlanBuilder.title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2022, 12, 3))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(0, "바베큐")
                .getPlan();
    }
}
