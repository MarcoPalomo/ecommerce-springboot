package test.java.com.monsite.ecommerce.repository;

import java.com.monsite.ecommerce.model.Product;
import java.com.monsite.ecommerce.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.Optional;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByName_existingProduct_returnsProduct() {
        // Arrange
        Product product = new Product("Test Product", new BigDecimal("19.99"));
        productRepository.save(product);

        // Act
        Optional<Product> found = productRepository.findByName("Test Product");

        // Assert
        assertTrue(found.isPresent());
        assertEquals("Test Product", found.get().getName());
    }
}
