package com.laptrinhjavaweb.springconfig;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class MySitemeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/quan-tri*", "/decorators/admin.jsp")
                .addDecoratorPath("/dang-nhap", "/decorators/login.jsp")
                .addDecoratorPath("/*", "/decorators/web.jsp")
                .addExcludedPath("/decorators/*");
    }
}
