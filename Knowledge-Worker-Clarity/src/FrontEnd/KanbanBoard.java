/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 *
 * @author ryan
 */
public class KanbanBoard {

    private LocalDateTime currentTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public KanbanBoard(LocalDateTime currentTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.currentTime = currentTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }



    public boolean checkCompleted(LocalDateTime currentTime, LocalDateTime startTime, LocalDateTime endTime) {
        if (currentTime.isAfter(startTime) && currentTime.isAfter(endTime)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkToday(LocalDateTime currentTime, LocalDateTime startTime, LocalDateTime endTime) {
        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkTomorrow(LocalDateTime currentTime, LocalDateTime startTime, LocalDateTime endTime) {
        
         Duration duration = Duration.between(currentTime, startTime);
        
        if (currentTime.isBefore(startTime) && currentTime.isBefore(endTime) && duration.toDays() >= 1 && duration.toDays() < 2) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkWeek(LocalDateTime currentTime, LocalDateTime startTime, LocalDateTime endTime) {
        
         Duration duration = Duration.between(currentTime, startTime);
        
        if (currentTime.isBefore(startTime) && currentTime.isBefore(endTime) && duration.toDays() >= 2 && duration.toDays() < 7) {
            return true;
        } else {
            return false;
        }
    }
    
    

}
