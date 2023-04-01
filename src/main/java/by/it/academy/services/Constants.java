package by.it.academy.services;

public class Constants {

    public static final String ADMIN_PAGE = "/pages/adminPages/adminPage.jsp";
    public static final String PAGE_ERRORS_FIELDS = "/pages/errorsPages/errorField.jsp";

    public static final String USERS_PAGE = "/pages/user/userPage.jsp";
    public static final String ERROR_AUTHORIZATION = "/pages/errorsPages/authorization_error.jsp";
    public static final String ERROR_UNIQ_LOGIN = "/pages/errorsPages/errorNoUniqLogin.jsp";
    public static final String ERROR_LOGIN = "/pages/errorsPages/errorNoUniqLogin.jsp";
    public static final String PAGES_REGISTRATION_TRUE = "/pages/servicesPages/successfulRegistration.jsp";
    public static final String PAGES_ADD_PRODUCT = "/pages/products/addProducts.jsp";
    public static final String PRODUCTS_PAGE = "/pages/productsPages/allProducts.jsp";
    public static final String ALL_USERS_PAGE = "/pages/usersPages/allUsersPage.jsp";
    public static final String PRODUCT_ADD_TRUE_PAGE = "/pages/productsPages/successfullyAddProduct.jsp";
    public static final String USER_UPDATE_TRUE_PAGE = "/pages/usersPages/successfullyUpdatePasswordUser.jsp";
    public static final String PRODUCT_UPDATE_TRUE_PAGE = "/pages/servicesPages/successfullyUpdateProduct.jsp";
    public static final String DELETE_PRODUCT_PAGE = "/pages/productsPages/successfullyDeleteProduct.jsp";
    public static final String DELETE_USER_PAGE = "/pages/usersPages/successfullyDeleteUser.jsp";
    public static final String BRACKET = "')";
    public static final String QUOTATION_MARK = "'";
    public static final String DELETE_USER_FROM_CREDENTIALS = "delete from credentials where login='";
    public static final String DELETE_PRODUCT = "delete from detectors where model='";

    public static final String DELETE_USER_FROM_USERS = "delete from users where id_credentials in " +
            "(select id_credentials from credentials " +
            "where login='";

    public static final String NAME_ID_CREDENTIALS = "/pages/products/productsPages.jsp";
    public static final String SQL_NAME = "postgres";
    public static final String SQL_DRIVER_NAME = "org.postgresql.Driver";
    public static final String SQL_PASSWORD = "Qwety5";
    public static final String SQL_URL = "jdbc:postgresql://localhost:5432/jpaWeb";
    public static final String INSERT_CREDENTIALS = "INSERT INTO credentials (login, password) VALUES (?, ?)";
    public static final String INSERT_BRAND = "INSERT INTO brand (brand) VALUES (?)";
    public static final String INSERT_DETECTORS = "INSERT INTO detectors (model, specifications, guarantee, price, quantity) VALUES (?,?,?,?,?)";
    public static final String SELECT_CREDENTIALS = "SELECT * FROM credentials";
    public static final String SELECT_DETECTORS = "SELECT * FROM DETECTORS";
    public static final String SELECT_USERS = "SELECT users.id_credentials, users.name, users.surname, users.age, credentials.login, credentials.password FROM users, credentials WHERE credentials.id_credentials = users.id_credentials";
    public static final String INSERT_USERS = "INSERT INTO users (id_credentials, name, surname, age) VALUES (?, ?, ?, ?)";

    public static final String USERS_URL_READ = "/user/read";
    public static final String USERS_URL_CREATE_SERVLET = "/user/create";
    public static final String USERS_URL_CREATE = "/user_create";
    public static final String PRODUCT_URL_CREATE = "/product_create";
    public static final String PRODUCT_URL_DELETE = "/product_delete";

    public static final String USER_URL_UPDATE = "/select_user_update";
    public static final String PRODUCT_URL_UPDATE = "/select_product_update";
    public static final String PRODUCT_URL_READ = "/product_read";
    public static final String USER_URL_READ = "/user_read";
    public static final String USER_URL_DELETE = "/user_delete";
    public static final String USERS_URL_INPUT = "/user/input";
    public static final String PATH_ALL = "/user/*";

    public static final String SEPARATOR = ":";
    public static final String DOUBLE_QUOTES = "";
    public static final String PROJECT_NAME = "WebShop";
    public static final String PRODUCTS = "products";
    public static final String MODEL_TO_UPDATE = "modelToUpdate";
    public static final String PRICE_TO_UPDATE = "newPrice";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NEW_PASSPORT_TO_UPDATE = "newPassword";
    public static final String NAME = "firstName";
    public static final String SURNAME = "secondName";
    public static final String AGE = "age";

    public static final String USERS = "users";
    public static final String PRODUCT_ID = "id";
    public static final String PRODUCT_MODEL = "model";
    public static final String PRODUCT_SPECIFICATIONS = "specifications";
    public static final String PRODUCT_GUARANTEE = "guarantee";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_QUANTITY = "quantity";
    public static final String ADMIN_LOGIN = "komikov";
    public static final String ADMIN_PASSWORD = "Qwety5";
    public static final String USER_SERVICE = "userService";
    public static final String USER_REPOSITORY = "userRepository";
    public static final String PRODUCT_REPOSITORY = "productRepository";
    public static final String PRODUCT_SERVICE = "productService";
    public static final String LOGIN_TO_DELETE = "loginToDelete";
    public static final String LOGIN_TO_UPDATE = "loginToUpdate";
    public static final int NULL_VALUE = 0;
    public static final int NOT_NULL_VALUE = 1;
    public static final int NOT_UNIQ_LOGIN = 0;
    public static final int UNIQ_LOGIN = 1;
    public static final int NOT_VALIDATE_FIELD = 0;
    public static final int VALIDATE_FIELD = 1;
    public static final int EMPTY_FIELD = 0;
    public static final int NOT_EMPTY_FIELD = 1;

}
