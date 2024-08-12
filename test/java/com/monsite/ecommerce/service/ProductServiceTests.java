package test.java.com.monsite.ecommerce.service;

import com.monsite.ecommerce.model.Product;
import com.monsite.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProductById_existingProduct_returnsProduct() {
        // Arrange
        Long productId = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setName("Test Product");
        expectedProduct.setPrice(new BigDecimal("19.99"));
        
        when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));

        // Act
        Optional<Product> result = productService.getProductById(productId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(expectedProduct, result.get());
        verify(productRepository).findById(productId);
    }

    @Test
    void getProductById_nonExistingProduct_returnsEmpty() {
        // Arrange
        Long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act
        Optional<Product> result = productService.getProductById(productId);

        // Assert
        assertFalse(result.isPresent());
        verify(productRepository).findById(productId);
    }
}