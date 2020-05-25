package com.commons.rest.api;

public interface IConstantsAPI {
	String DATE_FORMAT_FULL = "dd/MM/yyyy HH:mm:ss";
	String DATE_FORMAT_DATE = "dd/MM/yyyy";
	String DATE_FORMAT_SHORT = "dd/MM/yy";
	String DATE_FORMAT_HOUR = "hh:mm";
	String DATE_FORMAT_SQL = "yyyy-MM-dd";
	String DATE_FORMAT_SQL_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";

	String APPLICATION_JSON_UTF_8 = "application/json;charset=utf-8";
	String APPLICATION_XML_UTF_8 = "application/xml;charset=utf-8";

	String UTF_8 = "UTF-8";
	String ISO_8859_1 = "ISO-8859-1";
	String BLANK = "";
	String SPACE = " ";
	String SEMICOLON = ";";
	String COLON = ":";
	String DOT = ".";
	String COMMA = ",";
	String HIFEN = "-";
	String SLASH = "/";
	String BACKSLASH = "\\";
	
	String DEFAULT_PAGE = "0";
	String DEFAULT_SIZE = "5";

	// MONGODB
	String AND = "$and";
	String REGEX_CONTAINS = ".*%s.*";
	String CONTAINS = "contains";

	String GREATER_THAN = "gt";
	String GREATER_THAN_OR_EQUAL = "gte";
	String LESS_THAN = "lt";
	String LESS_THAN_OR_EQUAL = "lte";
	String EQ = "eq";
}

