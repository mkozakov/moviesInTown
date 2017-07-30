package com.moviesintown.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Reminder {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String userId;
    private Integer movieId;
    private String movieTitle;
    private Date releaseDate;
}
