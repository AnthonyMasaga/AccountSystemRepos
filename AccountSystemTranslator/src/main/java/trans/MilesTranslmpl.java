package trans;


import org.example.domain.dto.MilesDto;
import org.example.domain.persistence.Miles;
import org.example.repository.persistence.MilesRepo;
import org.example.translator.impl.MilesTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MilesTranslmpl implements MilesTrans {
   private final MilesRepo milesRepo;

    @Autowired
     public MilesTranslmpl(MilesRepo milesRepo){
        this.milesRepo = milesRepo;
    }

    @Override
    public List<MilesDto> getMiles() {
        List<MilesDto> milesDto = new ArrayList<>();
        try {
            for (Miles miles : milesRepo.findAll()) {
                milesDto.add(new MilesDto(miles));
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot get customers from the db", e);
        }
        return milesDto;
    }

    @Override
    public MilesDto create(MilesDto Miles) {
        return null;
    }

    @Override
    public MilesDto save(MilesDto Miles) {
        return null;
    }

    @Override
    public void someMethod() {

    }

    @Override
    public void delete(Miles miles) {

    }

}
