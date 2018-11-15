package springfive.cms.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfive.cms.domain.exceptions.CategoryNotFoundException;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.repository.CategoryRepository;
import springfive.cms.domain.vo.CategoryRequest;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category update(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category create(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    public void delete(String id) {
        Category category = this.categoryRepository.findById(id).get();
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findOne(String id) {
        return this.categoryRepository.findById(id).get();
    }
}
