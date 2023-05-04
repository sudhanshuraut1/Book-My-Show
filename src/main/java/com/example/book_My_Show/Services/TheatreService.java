package com.example.book_My_Show.Services;

import com.example.book_My_Show.Converters.TheatreConverter;
import com.example.book_My_Show.Entities.TheatreEntity;
import com.example.book_My_Show.Entities.TheatreSeatEntity;
import com.example.book_My_Show.EntryDtos.TheatreEntryDto;
import com.example.book_My_Show.Genres.SeatType;
import com.example.book_My_Show.Repositories.TheatreRepository;
import com.example.book_My_Show.Repositories.TheatreSeatEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreSeatEntityRepo theatreSeatEntityRepo;
    @Autowired
    TheatreRepository theatreRepository;

    public String addTheatre(TheatreEntryDto theatreEntryDto) throws Exception{

        //Do some validations
        if(theatreEntryDto.getName()==null || theatreEntryDto.getAddress()==null){
            throw new Exception("Name and location should be valid");
        }

        TheatreEntity theatreEntity = TheatreConverter.convertDtotoEntity(theatreEntryDto);

        List<TheatreSeatEntity> theatreSeatEntityList = createTheatreSeats(theatreEntryDto,theatreEntity);

        theatreEntity.setTheatreSeatEntityList(theatreSeatEntityList);

        theatreRepository.save(theatreEntity);

         return "Theatre addded successfully";
    }

    private List<TheatreSeatEntity> createTheatreSeats(TheatreEntryDto theatreEntryDto,TheatreEntity theatreEntity){

        int noClassicSeats = theatreEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theatreEntryDto.getPremiumSeatsCount();

        List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();

        for(int count = 1;count <= noClassicSeats;count ++){

            // need to make new TheatreseatEntity
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder().seatType(SeatType.CLASSIC)
                    .seatNo(count +"C").theatreEntity(theatreEntity).build();

            theatreSeatEntityList.add(theatreSeatEntity);
        }

        for(int count = 1;count <= noPremiumSeats;count ++){

            // need to make new TheatreseatEntity
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder().seatType(SeatType.PREMIUM)
                    .seatNo(count +"P").theatreEntity(theatreEntity).build();

            theatreSeatEntityList.add(theatreSeatEntity);
        }
      // theatreSeatEntityRepo.saveAll(theatreSeatEntityList);

        return theatreSeatEntityList;

    }
}
