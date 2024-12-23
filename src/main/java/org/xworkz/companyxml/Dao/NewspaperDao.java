package org.xworkz.companyxml.Dao;
import org.xworkz.companyxml.Dto.NewsPaperDto;

public interface NewspaperDao {
    void insertNewsPaperDetails(NewsPaperDto newsPaperDto);
    void update(String paperName, int id);
    void delete(int id);
    void read(String paperName,int id );
    void getAllNewsPaper();
    NewsPaperDto getNewsPaperByDate(String date);
    NewsPaperDto getNewsPaperByLanguage(String language);

}
