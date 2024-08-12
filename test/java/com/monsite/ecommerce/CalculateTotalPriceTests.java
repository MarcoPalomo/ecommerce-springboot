package test.java.com.monsite.ecommerce;

public class CalculateTotalPriceTests {
    
@Test
void calculateTotalPrice_multipleItems_returnsSumOfPrices() {
    // Arrange
    List<CartItem> cartItems = Arrays.asList(
        new CartItem(new Product("Product1", new BigDecimal("10.00")), 2),
        new CartItem(new Product("Product2", new BigDecimal("15.50")), 1)
    );
    
    // Act
    BigDecimal total = cartService.calculateTotalPrice(cartItems);
    
    // Assert
    assertEquals(new BigDecimal("35.50"), total);
}
}