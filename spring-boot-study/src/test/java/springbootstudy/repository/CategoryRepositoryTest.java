package springbootstudy.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springbootstudy.SpringBootStudyApplicationTests;
import springbootstudy.model.entity.Category;

public class CategoryRepositoryTest extends SpringBootStudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "admin";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        assertNotNull(newCategory);
        assertEquals(newCategory.getType(), type);
        assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read() {
        Optional<Category> selectedCategory = categoryRepository.findByType("COMPUTER");

        selectedCategory.ifPresent(category -> {
            System.out.println(category.getId());
            System.out.println(category.getType());
            System.out.println(category.getTitle());
        });
    }
}
