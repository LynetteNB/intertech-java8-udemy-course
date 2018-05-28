package com.acme.domain;

import com.acme.utils.MyDate;

public interface Rushable {
    boolean isRushable(MyDate orderDate, double amount);
}
