package org.xworkz.companyxml;

import org.xworkz.companyxml.Dao.NewsPaperDaoImpl;
import org.xworkz.companyxml.Dao.NewspaperDao;
import org.xworkz.companyxml.Dto.NewsPaperDto;
import org.xworkz.companyxml.service.NewsPaperService;
import org.xworkz.companyxml.service.NewspaperServiceImpl;

public class Runner {
 public static void main(String[] args) {
   NewsPaperService newsPaperService = new NewspaperServiceImpl();
   NewsPaperDto dto = new NewsPaperDto();
   dto.setId(1);
   dto.setDate("19-10-2024");
   dto.setLanguage("English");
   dto.setPrice(6);
   dto.setEditorName("Varun");
   dto.setNoOfArticles(4);
   dto.setPaperName("Times of India");
   dto.setNoOfPages(3);
   //newsPaperService.insertNewsPaperDetails(dto);

   NewsPaperDto dto1 = new NewsPaperDto();
   dto1.setId(2);
   dto1.setDate("20-10-2024");
   dto1.setLanguage("hindi");
   dto1.setPrice(6);
   dto1.setEditorName("Yashu");
   dto1.setPaperName("English Paper");
   dto1.setNoOfArticles(54);
   dto1.setNoOfPages(5);
   //
    //newsPaperService.insertNewsPaperDetails(dto1);
   newsPaperService.read(dto);




 }



}


