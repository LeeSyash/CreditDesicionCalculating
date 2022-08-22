package com.moskot.testTask.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CurrencyExchangeDto {
    private String ccy;
    private String base_ccy;
    private String buy;
    private String sale;

    public CurrencyExchangeDto(String ccy, String base_ccy, String buy, String sale) {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
        this.buy = buy;
        this.sale = sale;
    }

    public CurrencyExchangeDto() {
    }

    public float getFloatBuy() {
        return Float.parseFloat(buy);
    }

    public float getFloatSale() {
        return Float.parseFloat(sale);
    }


}
