package lk.ijse.stokemanagesystem.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString




public class ItemDto {

    private String code;
    private String description;
    private Double unitPrice;
    private int qtyOnHand;


}
