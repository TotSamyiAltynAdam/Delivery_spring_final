package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.CategoryDTO;
import kz.yeldos.delivery.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value="/category")
public class CategoryRestController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> categoryList(){
        return categoryService.getCategories();
    }

    @GetMapping(value = "{id}")
    public CategoryDTO getCategory(@PathVariable(name="id") Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO category){
        return categoryService.addCategory(category);
    }

    @PutMapping
    public CategoryDTO updateCategory(@RequestBody CategoryDTO category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCategory(@PathVariable(name="id") Long id){
        categoryService.deleteCategory(id);
    }

}
