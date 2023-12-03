package team.shoppingmall.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import team.shoppingmall.convertor.PackProductConvertor;
import team.shoppingmall.domain.packproduct.dto.controller.FilterSearchRequestDTO;
import team.shoppingmall.domain.packproduct.dto.controller.FoundPackProductResponseDTO;
import team.shoppingmall.domain.packproduct.service.PackProductService;

import java.util.List;
import java.util.stream.Collectors;

import static team.shoppingmall.convertor.PackProductConvertor.convert;

@RestController
@RequestMapping("/pack-products")
@RequiredArgsConstructor
public class PackProductController {

    private final PackProductService packProductService;

    @GetMapping("/{id}")
    public FoundPackProductResponseDTO thePackProduct(@PathVariable Integer id) {
        return convert(packProductService.searchOne(id));
    }

    @GetMapping
    public List<FoundPackProductResponseDTO> packProducts(FilterSearchRequestDTO filterSearchRequestDTO) {
        return packProductService
                .searchAllByPaginationAndFilter(convert(filterSearchRequestDTO))
                .stream()
                .map(PackProductConvertor::convert)
                .collect(Collectors.toList());
    }
}
