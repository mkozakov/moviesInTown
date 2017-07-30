package com.moviesintown.repository;

import com.moviesintown.model.Reminder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReminderRepository extends CrudRepository<Reminder, Integer> {

    List<Reminder> findByUserId(String userId);

    @Transactional
    List<Reminder> deleteByUserIdAndMovieId(String userId, Integer movieId);

//
//    private static final Map<String, Set<Movie>> reminders = new HashMap<>();
//
//    public Set<Movie> getUserReminders(String userId) {
//        return reminders.get(userId);
//    }
//
//    public Set<Movie> getUserReminders(String userId, LocalDate startDate, LocalDate endDate) {
//        return reminders.get(userId)
//                .stream()
//                .filter((Movie movie) ->
//                        movie.getReleaseDate().isAfter(startDate) && movie.getReleaseDate().isBefore(endDate))
//                .collect(Collectors.toSet());
//    }
//
//    public void addUserReminder(String userId, Movie movie) {
//        reminders.putIfAbsent(userId, new HashSet<>());
//        reminders.get(userId).add(movie);
//    }
//
//    public void removeUserReminder(String userId, String movieId) {
//        Set<Movie> userReminders = reminders.get(userId);
//        if (userReminders == null) {
//            throw new InvalidParameterException("User " + userId + " doesn't exist");
//        }
//        userReminders.removeIf((Movie movie) -> movie.getId().equals(movieId));
//    }
}
