package com.digitus.board.filter;


import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		super.applyCustomConfiguration(builder);
		builder.addDecoratorPath("/*", "/decorator/decorator.jsp");
		builder.addDecoratorPath("/login", "/decorator/empty.jsp");
		builder.addDecoratorPath("/signup", "/decorator/empty.jsp");
		builder.addExcludedPath("/api**");
	}
	
}
