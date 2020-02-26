/*
 * Copyright 2020 The Spring Example Project
 * 
 * 화면의 구성을 설정하기 위한 Sitemesh 설정 클래스
 * AddDecoratorPath와 ExcludedPath로 Decorator적용 설정을 할 수 있다.
 * 
 * 아래에 구현된 decorator는 2가지 종류로 decorator.jsp와 empty.jsp페이지 이다.
 * 
 * by Davis.
 */


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
		builder.addDecoratorPath("/member/**", "/decorator/empty.jsp");
		builder.addDecoratorPath("/error/**", "/decorator/empty.jsp");
		builder.addExcludedPath("/api**");
	}
	
}
