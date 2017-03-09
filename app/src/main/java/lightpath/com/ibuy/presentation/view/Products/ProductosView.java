package lightpath.com.ibuy.presentation.view.Products;

/**
 * Created by LUIS on 05/03/2017.
 */

public interface ProductosView {
    void onLoadData();
    void onSelectedProduct();
    void onSelectedProductSuccess();
    void onSelectedProductError();

    void hideProgress();
    void showProgress();
    void showMessage(String mensaje );

    void navigateToDetailProduct(String name,String price,String image,String detail,String size,String colors);
    void navigateToPrincipal();

    void initializeComponents();
    void update_toolbar();
}
