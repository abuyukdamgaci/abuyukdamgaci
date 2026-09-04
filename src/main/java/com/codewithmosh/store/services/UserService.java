package com.codewithmosh.store.services;

import com.codewithmosh.store.entities.Address;
import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.*;
import com.codewithmosh.store.repositories.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {
    private final ProductRepositoryJPA productRepositoryJPA;
    private UserRepository userRepository;
    private ProfileRepository profileRepository;
    private AddressRepository addressRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private EntityManager entityManager;

    @Transactional
    public void showEntityStates(){
        var user = User.builder().name("abu").email("abu@gmail.com").password("pass").build();

        if(entityManager.contains(user)){
            System.out.println("Persistent");
        }else{
            System.out.println("Transient / Detached");
        }

        userRepository.save(user);

        if(entityManager.contains(user)){
            System.out.println("Persistent");
        }else{
            System.out.println("Transient / Detached");
        }
    }

    @Transactional
    public void showRelatedEntities(){
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }


    public void showRelatedEntitiesForAddres(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());
    }

    public void persistRelated(){
        var user = User.builder().name("abdullah").email("abdullah@gmail.com").password("abuuuu").build();
        var addresss = Address.builder().street("street").zip("34567").state("state").city("istanbul").build();
        user.addAddress(addresss);
        userRepository.save(user);
//        addressRepository.save(addresss); ugly : user entity içinde cascade yaptık
    }

    public void deleteRelated(){
        userRepository.deleteById(9L);
    }

    @Transactional
    public void deleteRelatedChild(){
        var user = userRepository.findById(4L).orElseThrow();
        var address = user.getAddresses().stream().findFirst().orElse(null);
        user.removeAddress(address);
        userRepository.save(user);
    }

    public void createProductService(){
        var category = Category.builder().name("Category").build();
        var product = Product.builder().name("Product").description("Desc").price(BigDecimal.valueOf(534453)).category(category).build();
        productRepository.save(product);
    }

    @Transactional
    public void addNewProdcutCategory(){
        var category = categoryRepository.findById(1L).orElseThrow();
        var product = Product.builder().name("Product2").description("Desc2").price(BigDecimal.valueOf(534453)).category(category).build();
        productRepository.save(product);
    }

    @Transactional
    public void addProductsToWishListUser(){
        var user = userRepository.findById(5L).orElseThrow();
        var products = productRepository.findAll();
//        products.forEach(product -> user.addFavoriteProduct(product));
        products.forEach(user::addFavoriteProduct);
        userRepository.save(user);
    }

    public void deleteProduct(){
        productRepository.deleteById(4L);
    }

    @Transactional
    public void updateProductPrice(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10),1);
    }

    public void fetchProducts(){
        var products = productRepository.findByCategory(new Category((byte)1));
        products.forEach(System.out::println);
    }

    public void fetchUser(){
        var user = userRepository.findByEmail("abu@gmail.com").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers() {
        userRepository.findAll().forEach(user -> {
            System.out.println(user);
            user.getAddresses().forEach(System.out::println);

        });
    }

    @Transactional
    public void fetchUsersAddess() {
        userRepository.findAllWithAddresses().forEach(user -> {
            System.out.println(user);
            user.getAddresses().forEach(System.out::println);

        });
    }

    @Transactional
    public void findProductsByPrice(){
        var products = productRepository.findProductsByPrice(BigDecimal.valueOf(10),BigDecimal.valueOf(20));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchProfiles(){
        var userSummaryList = userRepository.findLoyalUsers(5);
        userSummaryList.forEach(userSummary -> {
            System.out.println(userSummary.getId() + " : " + userSummary.getEmail());});
    }

    @Transactional
    public void fetchProductsJpa(){
        var product = new Product();
        product.setName("new");

        var matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product, matcher);


        var products = productRepositoryJPA.findAll(example);
        products.forEach(product1 -> System.out.println(product1.getName()));

    }

    public void fetchProductByCriteria(){
        var products = productRepositoryJPA.findProductsByCriteria(null,BigDecimal.valueOf(1),BigDecimal.valueOf(100));
        products.forEach(System.out::println);
    }

    public void fetchProductsBySpecificaitons(String name, BigDecimal minPrice, BigDecimal maxPrice){
        Specification<Product> spec = null;
        if(name != null){
            Specification<Product> nameSpec = ProductSpec.hasName(name);
            // Eğer spec null ise ilk şartı atayın, null değilse .and() ile bağlayın
            spec = (spec == null) ? Specification.where(nameSpec) : spec.and(nameSpec);
        }

        if(minPrice != null){
            Specification<Product> priceSpec = ProductSpec.priceGreater(minPrice);
            spec = (spec == null) ? Specification.where(priceSpec) : spec.and(priceSpec);
        }

        if(maxPrice != null){
            Specification<Product> priceSpec = ProductSpec.priceGreater(maxPrice);
            spec = (spec == null) ? Specification.where(priceSpec) : spec.and(priceSpec);
        }

        productRepositoryJPA.findAll(spec).forEach(System.out::println);
    }

    public void fetchSortedProducts(){
        var sort = Sort.by("name").and(Sort.by("price").descending());
        productRepositoryJPA.findAll(sort).forEach(System.out::println);
    }

    public void fetchPaginatedProducts(int page, int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<Product> productPage = productRepositoryJPA.findAll(pageRequest);
        var products = productPage.getContent();
        products.forEach(System.out::println);

        var totalPages = productPage.getTotalPages();
        var totalElements = productPage.getTotalElements();
        System.out.println("TotalPages : " + totalPages);
        System.out.println("TotalElements : " + totalElements);
    }

}
