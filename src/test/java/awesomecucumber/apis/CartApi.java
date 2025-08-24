package awesomecucumber.apis;

import awesomecucumber.constants.Endpoint;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.HashMap;

public class CartApi {

    private Cookies cookies;

    public CartApi(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public Response addToCart(int productId, int quantity){
        Header header = new Header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Headers headers = new Headers(header);
        HashMap<String, Object> formparams = new HashMap<>();
        formparams.put("product_sku", "");
        formparams.put("product_id", productId);
        formparams.put("quantity", quantity);

        Response response = APiRequests.post(Endpoint.ADD_To_CART.url, headers, formparams, cookies); //making post request to add product to cart using ApiRequests class
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to add product " + productId + " to cart. Status code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies(); //fetching cookies from response and updating the cookies in CartApi class
        return response;
    }
}