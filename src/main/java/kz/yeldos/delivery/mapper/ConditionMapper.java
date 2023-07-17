package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.ConditionDTO;
import kz.yeldos.delivery.model.Condition;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConditionMapper {
    ConditionDTO toDto(Condition condition);
    Condition toModel(ConditionDTO conditionDTO);
    List<Condition> toModelList(List<ConditionDTO> conditionDTOList);
    List<ConditionDTO> toDtoList(List<Condition> conditionList);
}
