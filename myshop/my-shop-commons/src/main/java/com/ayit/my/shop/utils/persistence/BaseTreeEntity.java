package com.ayit.my.shop.utils.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseTreeEntity extends BaseEntity {

    private Long parentId;
    @JsonProperty(value = "isParent")
    private boolean isParent;

}
