package org.xworkz.companyxml.Dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor@EqualsAndHashCode
@ToString
public class NewsPaperDto {
    private int id;
    private String paperName;
    private int noOfPages;
    private String language;
    private int price;
    private String editorName;
    private String date;
    private int noOfArticles;
}
