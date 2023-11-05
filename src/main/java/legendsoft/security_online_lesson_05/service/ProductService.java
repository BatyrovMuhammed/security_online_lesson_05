package legendsoft.security_online_lesson_05.service;

import legendsoft.security_online_lesson_05.models.Product;
import legendsoft.security_online_lesson_05.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public Product findByIdProduct(Long id){
        return productRepository.findById(id).get();
    }

    public void deleteByIdProduct(Long id){
        productRepository.deleteById(id);
    }

}
