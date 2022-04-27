package com.laptrinhjavaweb.springconfig;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class MySitemeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/trang-chu", "/decorators/web.jsp")
                .addDecoratorPath("/home", "/decorators/admin.jsp")
                .addExcludedPath("/decorators/*");
    }
}
