package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.CategoryDTO;
import kz.yeldos.delivery.mapper.CategoryMapper;
import kz.yeldos.delivery.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getCategories(){
        return categoryMapper.toDTOList(categoryRepository.findAll());
    }
    public CategoryDTO getCategory(Long id){
        return categoryMapper.toDTO(categoryRepository.findById(id).orElse(null));
    }

    public CategoryDTO addCategory(CategoryDTO category){
        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toModel(category)));
    }
    public CategoryDTO updateCategory(CategoryDTO category){
        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toModel(category)));
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
