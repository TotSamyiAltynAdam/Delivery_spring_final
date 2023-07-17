package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.ConditionDTO;
import kz.yeldos.delivery.service.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/condition")
public class ConditionRestController {
    private final ConditionService conditionService;
    @GetMapping
    public List<ConditionDTO> conditionList(){
        return conditionService.getConditions();
    }
    @GetMapping(value="{id}")
    public ConditionDTO getCondition(@PathVariable(name="id") Long id){
        return conditionService.getCondition(id);
    }
    @PostMapping
    public ConditionDTO addCondition(@RequestBody ConditionDTO conditionDTO){
        return conditionService.addCondition(conditionDTO);
    }
    @PutMapping
    public ConditionDTO updateCondition(@RequestBody ConditionDTO conditionDTO){
        return conditionService.updateCondition(conditionDTO);
    }
}
