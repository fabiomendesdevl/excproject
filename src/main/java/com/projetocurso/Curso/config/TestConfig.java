package com.projetocurso.Curso.config;

import com.projetocurso.Curso.entities.*;
import com.projetocurso.Curso.entities.enums.OrderStatus;
import com.projetocurso.Curso.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        // Criar usuários
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        // Salvar os usuários primeiro
        userRepository.saveAll(Arrays.asList(u1, u2));

        // Criar pedidos
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        // Salvar os pedidos
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // Criar categorias
        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        // Criar produtos
        Product p1 = new Product(null, "TV", "Top", 500.00, "");
        Product p2 = new Product(null, "Celular", "rox", 600.00, "");
        Product p3 = new Product(null, "Notebook", "essentials", 700.00, "");

        // Associar produtos às categorias (sincronizando ambos os lados)
        p1.getCategories().add(c2);
        c2.getProducts().add(p1);

        p2.getCategories().add(c1);
        c1.getProducts().add(p2);

        p2.getCategories().add(c3);
        c3.getProducts().add(p2);

        p3.getCategories().add(c3);
        c3.getProducts().add(p3);

        // Salvar categorias e produtos
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        // Criar itens de pedido
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
        OrderItem oi4 = new OrderItem(o3, p2, 2, p2.getPrice());

        // Salvar itens de pedido
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        // Criar pagamento e associar ao pedido
        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        // Salvar o pedido novamente para persistir o pagamento
        orderRepository.save(o1);
    }
}
