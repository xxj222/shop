package com.ayit.my.shop.utils.persistence;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity  implements Serializable {

    private Long id;
    private Date updated;
    private Date created;


}
