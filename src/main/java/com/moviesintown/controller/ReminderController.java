package com.moviesintown.controller;

import com.moviesintown.model.Reminder;
import com.moviesintown.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @RequestMapping("/reminders")
    public List<Reminder> getReminders(@RequestParam String userId) {
        return reminderService.getUserReminders(userId);
    }

//    @RequestMapping("/reminders/week")
//    public Set<Movie> getRemindersForTheWeek(@RequestParam String userId) {
//        return reminderService.getRemindersForTheWeek(userId);
//    }

    @RequestMapping(method= RequestMethod.POST, value="/reminder/{movieId}")
    public String addReminder(@PathVariable Integer movieId, @RequestParam String userId) throws ParseException {
        reminderService.addUserReminder(userId, movieId);
        return String.format("User %s is tracking movie %s", userId, movieId);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/reminder/{movieId}")
    public String removeReminder(@PathVariable Integer movieId, @RequestParam String userId) {
        reminderService.removeUserReminder(userId, movieId);
        return String.format("User %s is no longer tracking movie %s", userId, movieId);
    }
}
