package springbootstudy.repository;

import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springbootstudy.SpringBootStudyApplicationTests;
import springbootstudy.model.entity.Item;

public class ItemRepositoryTest extends SpringBootStudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Transactional
    public void create() {
        Item item = new Item();
        item.setName("노트북");
        item.setPrice(1000000);
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);
        System.out.println("newItem : " + newItem);
    }

    @Test
    @Transactional
    public void read() {
        Optional<Item> item = itemRepository.findById(1L);
        item.ifPresent(selectedItem -> System.out.println("Item : " + selectedItem));
    }

    @Test
    @Transactional
    public void update() {
        Optional<Item> item = itemRepository.findById(1L);
        item.ifPresent(selectedItem -> {
            selectedItem.setPrice(2000000);
            selectedItem.setContent("업그레이드 삼성 노트북");

            itemRepository.save(selectedItem);
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<Item> item = itemRepository.findById(1L);
        item.ifPresent(selectedItem -> itemRepository.delete(selectedItem));
        Optional<Item> deletedItem = itemRepository.findById(1L);
        if (deletedItem.isPresent()) {
            System.out.println("데이터 삭제 실패 : " + deletedItem.get());
        } else {
            System.out.println("데이터 삭제 성공");
        }
    }
}
