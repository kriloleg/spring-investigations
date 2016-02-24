package com.kriloleg.inv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

    @Value("${data.messages.page.limit}")
    private int pageLimit;

    public int getPageLimit() {
        return pageLimit;
    }
}
