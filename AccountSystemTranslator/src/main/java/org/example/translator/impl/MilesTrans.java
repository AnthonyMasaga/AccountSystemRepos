package org.example.translator.impl;
import org.example.domain.dto.MilesDto;
import org.example.domain.persistence.Miles;

import java.util.Collection;
import java.util.List;
public interface MilesTrans {
    List<MilesDto> getMiles();
    MilesDto create(MilesDto Miles);
    MilesDto save(MilesDto Miles);

    void someMethod();

    void delete(Miles miles);
}
