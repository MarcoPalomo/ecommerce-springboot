package test.java.com.monsite.ecommerce;

public class InterractionControllersServicesTests {

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void createOrder_validInput_returnsCreatedOrder() throws Exception {
        // Arrange
        OrderDto orderDto = new OrderDto(/* ... */);
        Order createdOrder = new Order(/* ... */);
        when(orderService.createOrder(any(OrderDto.class))).thenReturn(createdOrder);

        // Act & Assert
        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(orderDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }
}
}