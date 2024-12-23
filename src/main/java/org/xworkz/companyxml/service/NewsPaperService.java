package org.xworkz.companyxml.service;

import org.xworkz.companyxml.Dto.NewsPaperDto;

public interface NewsPaperService {
    boolean insertNewsPaperDetails(NewsPaperDto newsPaperDto);
    void update(NewsPaperDto newsPaperDto);
    void delete(NewsPaperDto newsPaperDto);
    void read(NewsPaperDto newsPaperDto );
    void getAllNewsPaper(NewsPaperDto newsPaperDto);
    void getNewsPaperByDate(NewsPaperDto newsPaperDto);
    void getNewsPaperByLanguage(NewsPaperDto newsPaperDto);
}
