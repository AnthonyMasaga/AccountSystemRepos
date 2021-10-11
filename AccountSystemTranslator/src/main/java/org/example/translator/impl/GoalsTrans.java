package org.example.translator.impl;


import org.example.domain.dto.AccountTypeDto;
import org.example.domain.dto.GoalsDto;
import org.example.domain.dto.MilesDto;
import org.example.domain.persistence.AccountType;
import org.example.domain.persistence.Goals;

import java.util.List;
public interface GoalsTrans {
    List<GoalsDto> getGoals();
    GoalsDto create(GoalsDto Goals);
    GoalsDto save(GoalsDto Goals);

    void someMethod();

    //Goals getAccountTypeByDbEntityByMnemonic(String name);
    void delete(Goals goals);

}