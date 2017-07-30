package com.moviesintown.service;

import com.moviesintown.model.Reminder;
import com.moviesintown.data.Movie;
import com.moviesintown.repository.MovieRepository;
import com.moviesintown.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Reminder> getUserReminders(String userId) {
        return reminderRepository.findByUserId(userId);
    }

//    public Set<Movie> getUserReminders(String userId, LocalDate startDate, LocalDate endDate) {
//        return reminderRepository.find(userId, startDate, endDate);
//    }
//
//    public Set<Movie> getRemindersForTheWeek(String userId) {
//        LocalDate sunday = LocalDate.now().with(DayOfWeek.SUNDAY);
//        LocalDate saturday = LocalDate.now().with(DayOfWeek.SATURDAY);
//        return reminderRepository.getUserReminders(userId, sunday, saturday);
//    }

    public void addUserReminder(String userId, Integer movieId) throws ParseException {
        Movie movie = movieRepository.getMovieById(movieId).orElseThrow(() -> new InvalidParameterException());
        Reminder reminder = new Reminder();
        reminder.setUserId(userId);
        reminder.setMovieId(movieId);
        reminder.setReleaseDate(movie.getReleaseDate());
        reminder.setMovieTitle(movie.getTitle());
        reminderRepository.save(reminder);
    }

    public void removeUserReminder(String userId, Integer movieId) {
        reminderRepository.deleteByUserIdAndMovieId(userId, movieId);
    }
}
