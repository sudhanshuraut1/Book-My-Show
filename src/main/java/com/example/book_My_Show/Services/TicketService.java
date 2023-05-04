package com.example.book_My_Show.Services;

import com.example.book_My_Show.Converters.TicketConverter;
import com.example.book_My_Show.Entities.ShowEntity;
import com.example.book_My_Show.Entities.ShowSeatEntity;
import com.example.book_My_Show.Entities.TicketEntity;
import com.example.book_My_Show.Entities.UserEntity;
import com.example.book_My_Show.EntryDtos.TicketEntryDto;
import com.example.book_My_Show.Repositories.ShowRepository;
import com.example.book_My_Show.Repositories.TicketRepository;
import com.example.book_My_Show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;
    public String addTicket(TicketEntryDto ticketEntryDto)throws Exception{

        //1. create ticketEntity from entryDto

        TicketEntity ticketEntity = TicketConverter.convertEntryTOEntity(ticketEntryDto);

        //Validation : Check if the requested seats are available or nt

        boolean isValidRequest = checkValidityOfRequestedSeats(ticketEntryDto);
        if(isValidRequest==false){
        throw new Exception("Requested Seats are not available");
        }

        //We assume that the reqSeats are valid

        //calculate the total amount
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
         List<ShowSeatEntity> seatEntityList = showEntity.getListOfShowSeats();
         List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

         int totalAmount =0;
         for(ShowSeatEntity showSeatEntity : seatEntityList){

             if (requestedSeats.contains(showSeatEntity.getSeatNo())){
                 totalAmount = totalAmount + showSeatEntity.getPrice();
                 showSeatEntity.setBooked(true);
                 showSeatEntity.setBookedAt(new Date());
             }
         }

         ticketEntity.setTotalAmount(totalAmount);

     //setting other required attributes for the ticket entity

        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheatreName(showEntity.getTheatreEntity().getName());

        // We need to set that string that talked about requested seats

       // String allotedSeats = getAllotedSeatsFromShowSeats(seatEntityList);


        //Setting the foreign key attributes
        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserID()).get();

        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        //Save the parent

        List<TicketEntity> ticketEntityList = showEntity.getListOfBookedTickets();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTickets(ticketEntityList);

        showRepository.save(showEntity);

        List<TicketEntity> ticketEntityList1 = userEntity.getBookedTickets();
        ticketEntityList1.add(ticketEntity);
        userEntity.setBookedTickets(ticketEntityList1);

        userRepository.save(userEntity);

        return "Ticket has been successfully added";
    }

  //  private String getAllotedSeatsFromShowSeats(List<>) =

    private boolean checkValidityOfRequestedSeats(TicketEntryDto ticketEntryDto){

        int showId = ticketEntryDto.getShowId();
        List<String> reqestedSeats = ticketEntryDto.getRequestedSeats();

        ShowEntity showEntity = showRepository.findById(showId).get();

        List<ShowSeatEntity> listOfseats = showEntity.getListOfShowSeats();

        //Iterating over the list of seats for that particular show

        for(ShowSeatEntity showSeatEntity : listOfseats){
            String seatNo = showSeatEntity.getSeatNo();

            if(reqestedSeats.contains(seatNo)){

                if(showSeatEntity.isBooked()==true){
                    return false; // since this seat cant be occupied
                }
            }

        }
        return true;
    }
}



