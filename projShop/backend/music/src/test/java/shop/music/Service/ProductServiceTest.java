package shop.music.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import shop.music.model.Product;
import shop.music.repository.ProductRepository;
import shop.music.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void whenGetProductById_thenProductShouldBeReturned() {
        Product product = new Product("Product", "image", 0.0f, "description", 5, "category");

        Mockito.when(productRepository.findById(0)).thenReturn(product);

        Product fromDb = productService.getProductById(0);

        assertThat(fromDb).isEqualTo(product);

        verify(productRepository, times(1)).findById(Mockito.anyInt());
    }

    @Test
    void whenGetAllProduct_thenProductListShouldBeReturned() {
        Product product1 = new Product("Product", "image", 0.0f, "description", 5, "category");
        Product product2 = new Product("Product", "image", 0.0f, "description", 5, "category");

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<Product> fromDb = productService.getAll();

        assertThat(fromDb).isEqualTo(products);

        verify(productRepository, times(1)).findAll();
    }
}
