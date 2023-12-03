package team.shoppingmall.domain.packproduct.repository;

import org.springframework.stereotype.Repository;
import team.shoppingmall.domain.packproduct.PackProduct;
import team.shoppingmall.domain.packproduct.dto.repository.FilterSearchRepositoryDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryRepository implements PackProductRepository {

    private static Map<Integer, PackProduct> entities = Map.of(
            1, new PackProduct(1, "곰 인형", 2000),
            2, new PackProduct(2, "토끼 인형", 3000),
            3, new PackProduct(3, "기린 인형", 4000),
            4, new PackProduct(4, "강아지 인형", 5000),
            5, new PackProduct(5, "판다 인형", 6000)
    );

    @Override
    public Optional<PackProduct> findOneById(Integer id) {
        return Optional.of(entities.get(id));
    }

    @Override
    public List<PackProduct> findAllByPaginationAndFilter(FilterSearchRepositoryDTO filterSearchRepositoryDTO) {
        String nameCondition = filterSearchRepositoryDTO.getName();
        Integer price = filterSearchRepositoryDTO.getPrice();
        List<PackProduct> found = new LinkedList<>();

        for (PackProduct entity : entities.values())
            if (entity.getName().contains(nameCondition) || entity.getPrice().equals(price))
                found.add(entity);
        return found;
    }
}
