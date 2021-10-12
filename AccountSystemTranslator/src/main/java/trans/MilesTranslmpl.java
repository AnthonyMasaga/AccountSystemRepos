package trans;


import org.example.domain.dto.MilesDto;
import org.example.domain.dto.UserDto;
import org.example.domain.persistence.Miles;
import org.example.domain.persistence.User;
import org.example.repository.persistence.MilesRepo;
import org.example.repository.persistence.UserRepo;
import org.example.translator.impl.MilesTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MilesTranslmpl implements MilesTrans {
   private final MilesRepo milesRepo;
   private UserRepo userRepo;

   @Autowired
   public MilesTranslmpl(MilesRepo milesRepo, UserRepo userRepo) {
      this.milesRepo = milesRepo;
      this.userRepo = userRepo;
   }


   @Override
   public List<MilesDto> getAllMiles() {
      List<MilesDto> themiles = new ArrayList<>();
      try {
         for (Miles miles: milesRepo.findAll()){
            themiles.add(new MilesDto(miles));
         }
      }catch (Exception e){
         throw new RuntimeException("Cannot get The miles",e);
      }
      return themiles;
   }

   @Override
   public MilesDto getMemberMiles(String email) {
      Miles miles;
      try {
         miles = milesRepo.getMemberMiles(email);
      }catch (Exception e){
         throw new RuntimeException("Cannot get The miles",e);
      }
      return new MilesDto(miles);
   }

   @Override
   public MilesDto addMiles(UserDto milesDto) {
      MilesDto miles = milesDto.getMilesDto();
      Miles milesTaken;
      try {
         User user= userRepo.getUserByEmail(milesDto.getEmail());
         milesTaken = miles.buildMiles(new UserDto(user));
         milesRepo.save(milesTaken);
      }catch (Exception e){
         throw new RuntimeException("Cannot add The miles",e);
      }
      return new MilesDto(milesTaken);
   }

   @Override
   public MilesDto deleteMiles(String email) {
      Miles miles;
      try {
         miles = milesRepo.deleteMilesForUser(email);
      }catch (Exception e){
         throw new RuntimeException("Cannot add The miles",e);
      }
      return null;
   }
}


