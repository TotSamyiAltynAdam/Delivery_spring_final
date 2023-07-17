package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.Additional_blockDTO;
import kz.yeldos.delivery.model.Additional_block;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Additional_blockMapper {
    Additional_blockDTO toDto(Additional_block additionalBlock);
    Additional_block toModel(Additional_blockDTO additionalBlockDTO);
    List<Additional_blockDTO> toDtoList(List<Additional_block> additionalBlockList);
    List<Additional_block> toModelList(List<Additional_blockDTO> additionalBlockDTOList);
}
