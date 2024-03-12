package com.turkcell.bootcamp.e_commerce.core.services.constants;

public class Messages {
    public static class BusinessErrors {
        public static final String SAME_PRODUCT_NAME_ERROR = "sameProductNameError";
    }

    public static class ValidationErrors {
        public static final String PRODUCT_NAME_NOT_NULL = "productNameNotNull";
        public static final String PRODUCT_NAME_SIZE = "productNameSize";
        public static final String PRODUCT_STOCK_NOT_NULL = "productStockNotNull";
        public static final String PRODUCT_UNIT_PRICE_NOT_NULL = "productUnitPriceNotNull";
        public static final String PRODUCT_CATEGORY_NOT_NULL = "productCategoryIdNotNull";
        public static final String VALIDATION_NOT_BLANK = "validation.notBlank";
        public static final String VALIDATION_LENGTH = "validation.length";
    }
}
