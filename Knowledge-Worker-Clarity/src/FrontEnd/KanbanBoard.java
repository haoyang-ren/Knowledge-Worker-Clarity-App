/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author ryan
 */
public class KanbanBoard {

    private LocalDate currentTime;
    private LocalDate startTime;
    private LocalDate endTime;

    public KanbanBoard(LocalDate currentTime, LocalDate startTime, LocalDate endTime) {
        this.currentTime = currentTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean checkCompleted(LocalDate currentTime, LocalDate startTime, LocalDate endTime) {
        if (currentTime.isAfter(startTime) && currentTime.isAfter(endTime)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkToday(LocalDate currentTime, LocalDate startTime, LocalDate endTime) {
        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkTomorrow(LocalDate currentTime, LocalDate startTime, LocalDate endTime) {
        
         Period duration = Period.between(currentTime, startTime);
        
        if (currentTime.isBefore(startTime) && currentTime.isBefore(endTime) && duration.getDays() >= 1 && duration.getDays() < 2) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkWeek(LocalDate currentTime, LocalDate startTime, LocalDate endTime) {
        
         Period duration = Period.between(currentTime, startTime);
        
        if (currentTime.isBefore(startTime) && currentTime.isBefore(endTime) && duration.getDays() >= 2 && duration.getDays() < 7) {
            return true;
        } else {
            return false;
        }
    }
    
    

}
