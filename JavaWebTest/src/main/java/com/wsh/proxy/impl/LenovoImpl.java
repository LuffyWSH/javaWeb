package com.wsh.proxy.impl;

import com.wsh.proxy.Computer;

public class LenovoImpl implements Computer {
    @Override
    public void show() {
        System.out.println("LenovoImpl展示电脑");
    }

    @Override
    public String sale(double money) {
        System.out.println("LenovoImpl商店有一台电脑，价格是"+money);
        return "LenovoImpl商店卖出去一台电脑";
    }
}
