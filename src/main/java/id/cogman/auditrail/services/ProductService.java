package id.cogman.auditrail.services;

import id.cogman.auditrail.dtos.ProductRequest;
import id.cogman.auditrail.dtos.ProductUpdateRequest;
import id.cogman.auditrail.entities.Product;
import id.cogman.auditrail.mappers.ProductMapper;
import id.cogman.auditrail.repositories.ProductRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(String id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product not found"));
  }

  public Product create(ProductRequest request) {
    return productRepository.save(ProductMapper.toEntity(request));
  }

  public Product update(ProductUpdateRequest request) {
    productRepository.findById(request.getId())
        .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    return productRepository.save(ProductMapper.toEntity(request));
  }

  public void delete(String id) {
    productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    productRepository.deleteById(id);
  }

}
