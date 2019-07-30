package utils;

public class Constant {

    public static final String ONLINER_URL = "https://www.onliner.by";
    public static final String CSS_SELECTOR_LOGIN_BTN_ON_MAIN_PAGE = ".auth-bar__item--text";
    public static final String CSS_SELECTOR_INPUT_EMAIL = "input.auth-input[type=text]";
    public static final String CSS_SELECTOR_INPUT_PASSWORD = "input.auth-input[type=password]";
    public static final String CSS_SELECTOR_SUBMIT_BTN = "button.auth-button[type=submit]";
    public static final String XPATH_OPEN_CATALOG_BTN = "//a[@href='https://catalog.onliner.by/']";
    public static final String XPATH_GLOBAL_CATEGORY_BLOCK = "//div[@class=\"catalog-navigation-list__category\" and @style=\"display: block;\"]";
    public static final String XPATH_PRODUCT = "//a[@class=\"schema-product__button button button_orange\"]";
    public static final String XPATH_CATALOG_PRODUCT_NAME = "//span[@data-bind='html: product.extended_name || product.full_name']";
    public static final String XPATH_CART_PRODUCT_NAME = "//span[@data-bind='html: $data.positionItem.product.full_name']";
    public static final String CLASSNAME_GLOBAL_CATEGORY = "catalog-navigation-classifier__item";
    public static final String CLASSNAME_ASIDE_CATEGORY = "catalog-navigation-list__aside-item";
    public static final String CLASSNAME_ASIDE_CATEGORY_ITEM = "catalog-navigation-list__aside-item_active";
    public static final String CLASSNAME_DROPDOWN_CATEGORY = "catalog-navigation-list__dropdown-item";
    public static final String CLASSNAME_OFFERS_LIST = "offers-list__button_basket";
    public static final String CLASSNAME_LIST_PRODUCTS_IN_CART = "cart-product";
    public static final String CLASSNAME_GROUPS_OF_PRODUCTS = "schema-product__group";
    public static final String ID_CART = "cart-desktop";
    public static final String EMAIL = "mailamazon@yandex.by";
    public static final String PASSWORD = "mailamazon1";
}