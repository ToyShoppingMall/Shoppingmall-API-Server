package team.shoppingmall.domain.packproduct;

import lombok.Getter;

@Getter
public class PackProduct {

    private Integer id;
    private String name;
    private Integer price;

    public PackProduct(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
