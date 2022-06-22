package ru.netology.productmanager;
import ru.netology.domain.Product;

public class CartRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        for (Product product1 : findAll()) ;
        int lenght = products.length + 1;
        Product[] tmp = new Product[lenght];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndexProduct = tmp.length - 1;
        tmp[lastIndexProduct] = product;
        products = tmp;
    }


    public Product[] findAll() {
        return products;
    }

    public Product[] findById(int findId) {
        Product[] result = new Product[0];
        for (Product product : findAll()) {
            if (product.getId() == findId) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(findAll(), 0, tmp, 0, result.length);
                int rightIndex = 0;
                tmp[rightIndex] = product;
                result = tmp;
                return result;
            }
        }
        return null;
    }


    public void removeById(int id) {
        //int findId;
        int lenght = products.length - 1;
        Product[] tmp2 = new Product[lenght];
        int indexFirst = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp2[indexFirst] = product;
                indexFirst++;
            }
            products = tmp2;
        }

    }
}