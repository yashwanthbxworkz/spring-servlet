package org.xworkz.companyxml.service;

import org.xworkz.companyxml.Dao.NewsPaperDaoImpl;
import org.xworkz.companyxml.Dao.NewspaperDao;
import org.xworkz.companyxml.Dto.NewsPaperDto;

public class NewspaperServiceImpl implements NewsPaperService{
    @Override
    public boolean insertNewsPaperDetails(NewsPaperDto newsPaperDto) {
        boolean isNewsPaperAdded=false;
        if(newsPaperDto !=null && newsPaperDto.getPaperName() !=null
                && !newsPaperDto.getPaperName().isEmpty()){
            NewspaperDao newsPaperDao=new NewsPaperDaoImpl();
            newsPaperDao.insertNewsPaperDetails(newsPaperDto);
        }else {
            System.out.println("Newspaper Name is Empty");
        }
        return isNewsPaperAdded;
    }

    @Override
    public void update(NewsPaperDto newsPaperDto) {
        if(newsPaperDto !=null && newsPaperDto.getPaperName() !=null
                && !newsPaperDto.getPaperName().isEmpty()){
            NewspaperDao newsPaperDao=new NewsPaperDaoImpl();
            newsPaperDao.update(newsPaperDto.getPaperName(),newsPaperDto.getId());
        }else {
            System.out.println("Newspaper Name is Empty");
        }

    }

    @Override
    public void delete(NewsPaperDto newsPaperDto) {
        if(newsPaperDto !=null && newsPaperDto.getPaperName() !=null
                && !newsPaperDto.getPaperName().isEmpty()){
            NewspaperDao newsPaperDao=new NewsPaperDaoImpl();
            newsPaperDao.delete(newsPaperDto.getId());
        }else {
            System.out.println("Newspaper Name is Empty");
        }

    }

    @Override
    public void read(NewsPaperDto newsPaperDto) {
        if(newsPaperDto !=null && newsPaperDto.getPaperName() !=null
                && !newsPaperDto.getPaperName().isEmpty()){
            NewspaperDao newsPaperDao=new NewsPaperDaoImpl();
            newsPaperDao.read(newsPaperDto.getPaperName(),newsPaperDto.getId());
        }else {
            System.out.println("Newspaper Name is Empty");
        }

    }

    @Override
    public void getAllNewsPaper(NewsPaperDto newsPaperDto) {
        if(newsPaperDto !=null && newsPaperDto.getPaperName() !=null
                && !newsPaperDto.getPaperName().isEmpty()) {
            NewspaperDao newsPaperDao = new NewsPaperDaoImpl();
            newsPaperDao.getAllNewsPaper();
        }

    }

    @Override
    public void getNewsPaperByDate(NewsPaperDto newsPaperDto) {
        if(newsPaperDto !=null && newsPaperDto.getPaperName() !=null
                && !newsPaperDto.getPaperName().isEmpty()){
            NewspaperDao newsPaperDao=new NewsPaperDaoImpl();
            newsPaperDao.getNewsPaperByDate(newsPaperDto.getDate());
        }else {
            System.out.println("Newspaper Name is Empty");
        }
    }

    @Override
    public void getNewsPaperByLanguage(NewsPaperDto newsPaperDto) {
        if(newsPaperDto !=null && newsPaperDto.getLanguage() !=null
                && !newsPaperDto.getLanguage().isEmpty()){
            NewspaperDao newsPaperDao=new NewsPaperDaoImpl();
            newsPaperDao.getNewsPaperByLanguage(newsPaperDto.getLanguage());
        }else {
            System.out.println("Newspaper Name is Empty");
        }


    }
}


