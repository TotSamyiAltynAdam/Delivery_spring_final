package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.Additional_blockDTO;
import kz.yeldos.delivery.mapper.Additional_blockMapper;
import kz.yeldos.delivery.repository.Additional_blockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Additional_blockService {
    private final Additional_blockRepository additionalBlockRepository;
    private final Additional_blockMapper additionalBlockMapper;
    public Additional_blockDTO getAdditionalBlock(Long id){
        return additionalBlockMapper.toDto(additionalBlockRepository.findById(id).orElse(null));
    }
    public List<Additional_blockDTO> getAdditionalBlocks(){
        return additionalBlockMapper.toDtoList(additionalBlockRepository.findAll());
    }
    public List<Additional_blockDTO> getAdditionalBlocksRelatedToTheParticularDish(Long dishId){
        return additionalBlockMapper.toDtoList(additionalBlockRepository.findAllByDishId(dishId));
    }
    public Additional_blockDTO addAdditionalBlock(Additional_blockDTO additionalBlockDTO){
        return additionalBlockMapper.toDto(additionalBlockRepository.save(additionalBlockMapper.toModel(additionalBlockDTO)));
    }
    public Additional_blockDTO updateAdditionalBlock(Additional_blockDTO additionalBlockDTO){
        return additionalBlockMapper.toDto(additionalBlockRepository.save(additionalBlockMapper.toModel(additionalBlockDTO)));
    }
    public void deleteAdditionalBlock(Long id){
        additionalBlockRepository.deleteById(id);
    }
    public void deleteAdditionalBlockByTakingIntoAccountDish(Long id){
        additionalBlockRepository.deleteAllByDishId(id);
    }
}
