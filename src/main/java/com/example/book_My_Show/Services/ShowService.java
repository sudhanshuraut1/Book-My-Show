package com.example.book_My_Show.Services;

import com.example.book_My_Show.Converters.MovieConverter;
import com.example.book_My_Show.Converters.ShowConverter;
import com.example.book_My_Show.Entities.*;
import com.example.book_My_Show.EntryDtos.ShowEntryDto;
import com.example.book_My_Show.Genres.SeatType;
import com.example.book_My_Show.Repositories.MovieRepository;
import com.example.book_My_Show.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    public String Addshow(ShowEntryDto showEntryDto){

        // create showentity
        ShowEntity showEntity = ShowConverter.showDtoToEntity(showEntryDto);
        int movieId = showEntryDto.getMovieId();
        int theatreId = showEntryDto.getTheatreId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();

        TheatreEntity theatreEntity = theatreRepository.findById(showEntryDto.getTheatreId()).get();

        // setting attributes of foreign key

        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheatreEntity(theatreEntity);

        // pending attributes are  listshowseatEntity;

        List<ShowSeatEntity> showSeatEntityList = createShowSeatEntity(showEntryDto,showEntity);

         showEntity.setListOfShowSeats(showSeatEntityList);

         // need to update parent Entities(Multiple)
           List <ShowEntity> showEntityList = movieEntity.getShowEntityList();
           showEntityList.add(showEntity);
           movieEntity.setShowEntityList(showEntityList);

           movieRepository.save(movieEntity);

           List<ShowEntity> showEntityList1 = theatreEntity.getShowEntityList();
           showEntityList1.add(showEntity);
           theatreEntity.setShowEntityList(showEntityList1);
           theatreRepository.save(theatreEntity);

           return " the show has been added successfully";
    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity){

        // goal is to create showSeatEntity
        // need to set its attributes

        TheatreEntity theatreEntity = showEntity.getTheatreEntity();

        List<TheatreSeatEntity> theatreSeatEntityList = theatreEntity.getTheatreSeatEntityList();

        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();

        for (TheatreSeatEntity theatreSeatEntity : theatreSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theatreSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theatreSeatEntity.getSeatType());

            if(theatreSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
            else
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity); // parent : foreign key for show entity

            showSeatEntityList.add(showSeatEntity);
        }
          return showSeatEntityList;
    }

}
