package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.Additional_blockDTO;
import kz.yeldos.delivery.service.Additional_blockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/additionalBlock")
public class AdditionalBlockRestController {
    private final Additional_blockService additionalBlockService;
    @GetMapping
    public List<Additional_blockDTO> getAdditionalBlockList(){
        return additionalBlockService.getAdditionalBlocks();
    }
    @GetMapping(value="/dish/{id}")
    public List<Additional_blockDTO> getAdditionalBlockListRelatedToTheDish(@PathVariable(name="id") Long dishId){
        return additionalBlockService.getAdditionalBlocksRelatedToTheParticularDish(dishId);
    }

    @GetMapping(value = "{id}")
    public Additional_blockDTO getAdditionalBlock(@PathVariable(name="id") Long id){
        return additionalBlockService.getAdditionalBlock(id);
    }
    @PostMapping
    public Additional_blockDTO addAdditionalBlock(@RequestBody Additional_blockDTO additionalBlockDTO){
        return additionalBlockService.addAdditionalBlock(additionalBlockDTO);
    }
    @PutMapping
    public Additional_blockDTO updateAdditionalBlock(@RequestBody Additional_blockDTO additionalBlockDTO){
        return additionalBlockService.updateAdditionalBlock(additionalBlockDTO);
    }
    @DeleteMapping(value = "{id}")
    public void deleteAdditionalBlock(@PathVariable(name="id") Long id){
        additionalBlockService.deleteAdditionBlock(id);
    }
}
