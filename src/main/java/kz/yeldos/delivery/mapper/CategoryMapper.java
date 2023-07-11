package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.CategoryDTO;
import kz.yeldos.delivery.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toModel(CategoryDTO categoryDTO);
    List<CategoryDTO> toDTOList(List<Category> categoryList);
    List<Category> toModelList(List<CategoryDTO> categoryDTOList);

}
