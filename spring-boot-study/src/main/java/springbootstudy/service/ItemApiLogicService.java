package springbootstudy.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootstudy.interfaces.CrudInterface;
import springbootstudy.model.entity.Item;
import springbootstudy.model.network.Header;
import springbootstudy.model.network.request.ItemApiRequest;
import springbootstudy.model.network.response.ItemApiResponse;
import springbootstudy.repository.ItemRepository;
import springbootstudy.repository.PartnerRepository;

@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        ItemApiRequest req = request.getData();
        Item item = Item.builder()
            .status(req.getStatus())
            .name(req.getName())
            .title(req.getTitle())
            .content(req.getContent())
            .price(req.getPrice())
            .brandName(req.getBrandName())
            .registeredAt(LocalDateTime.now())
            .partner(partnerRepository.getById(req.getPartnerId()))
            .build();
        Item newItem = itemRepository.save(item);
        return response(newItem);
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        Optional<Item> selectedItem = itemRepository.findById(id);
        return selectedItem
            .map(item -> response(item))
            .orElseGet(() -> Header.ERROR("no data"));
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        ItemApiRequest req = request.getData();
        Optional<Item> selectedItem = itemRepository.findById(req.getId());
        return selectedItem
            .map(item -> {
                item.setStatus(req.getStatus())
                    .setName(req.getName())
                    .setTitle(req.getTitle())
                    .setContent(req.getContent())
                    .setPrice(req.getPrice())
                    .setBrandName(req.getBrandName())
                    .setRegisteredAt(req.getRegisteredAt())
                    .setUnregisteredAt(req.getUnregisteredAt());
                return item;
            })
            .map(item -> itemRepository.save(item))
            .map(updatedItem -> response(updatedItem))
            .orElseGet(() -> Header.ERROR("no data"));
    }

    @Override
    public Header delete(Long id) {
        Optional<Item> selectedItem = itemRepository.findById(id);
        return selectedItem
            .map(item -> {
                itemRepository.delete(item);
                return Header.OK();
            })
            .orElseGet(() -> Header.ERROR("no data"));
    }

    private Header<ItemApiResponse> response(Item item) {
        ItemApiResponse res = ItemApiResponse.builder()
            .id(item.getId())
            .status(item.getStatus())
            .name(item.getName())
            .title(item.getTitle())
            .content(item.getContent())
            .price(item.getPrice())
            .brandName(item.getBrandName())
            .registeredAt(item.getRegisteredAt())
            .unregisteredAt(item.getUnregisteredAt())
            .partnerId(item.getPartner().getId())
            .build();
        return Header.OK(res);
    }
}
