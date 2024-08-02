package com.example.beejo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="show")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Show {
    @Id
    private String _id;
    private String title;
    private String synopsis;
    private String poster;
    private String banner;
    private Double rentPrice;
    private Double buyPrice;
    private String section;
    private Boolean isHero;
}
