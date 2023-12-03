package team.shoppingmall.domain.packproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AbstractFoundPackProductDTO {

    private Integer id;
    private String name;
    private Integer price;
}
