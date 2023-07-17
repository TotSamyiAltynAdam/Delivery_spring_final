package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.ConditionDTO;
import kz.yeldos.delivery.mapper.ConditionMapper;
import kz.yeldos.delivery.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionService {
    private final ConditionRepository conditionRepository;
    private final ConditionMapper conditionMapper;

    public ConditionDTO getCondition(Long id){
        return conditionMapper.toDto(conditionRepository.findById(id).orElse(null));
    }
    public List<ConditionDTO> getConditions(){
        return conditionMapper.toDtoList(conditionRepository.findAll());
    }
    public ConditionDTO addCondition(ConditionDTO conditionDTO){
        return conditionMapper.toDto(conditionRepository.save(conditionMapper.toModel(conditionDTO)));
    }
    public ConditionDTO updateCondition(ConditionDTO conditionDTO){
        return conditionMapper.toDto(conditionRepository.save(conditionMapper.toModel(conditionDTO)));
    }
}
