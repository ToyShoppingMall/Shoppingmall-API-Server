package team.shoppingmall.domain.packproduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.shoppingmall.convertor.PackProductConvertor;
import team.shoppingmall.domain.packproduct.dto.service.FilterSearchServiceDTO;
import team.shoppingmall.domain.packproduct.dto.service.FoundPackProductServiceDTO;
import team.shoppingmall.domain.packproduct.repository.PackProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static team.shoppingmall.convertor.PackProductConvertor.convert;

@Service
@RequiredArgsConstructor
public class PackProductServiceImpl implements PackProductService {

    private final PackProductRepository packProductRepository;

    @Override
    public FoundPackProductServiceDTO searchOne(Integer id) {
        return convert(
                packProductRepository
                        .findOneById(id)
                        .orElseThrow(NoSuchElementException::new)
        );
    }

    @Override
    public List<FoundPackProductServiceDTO> searchAllByPaginationAndFilter(FilterSearchServiceDTO filterSearchServiceDTO) {
        return packProductRepository
                .findAllByPaginationAndFilter(convert(filterSearchServiceDTO))
                .stream()
                .map(PackProductConvertor::convert)
                .collect(Collectors.toList());
    }
}
