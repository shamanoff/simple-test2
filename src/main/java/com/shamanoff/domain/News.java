package com.shamanoff.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity(name = "news")
public class News {

    @Id
    private Long id;

    private String title;

    private String link;

}
