package id.cogman.auditrail.controllers;

import id.cogman.auditrail.dtos.ProductRequest;
import id.cogman.auditrail.entities.Product;
import id.cogman.auditrail.mappers.ProductMapper;
import id.cogman.auditrail.services.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public Product findById(@PathVariable("id") String id) {
    return productService.findById(id);
  }

  @PostMapping
  public Product create(@RequestBody ProductRequest request) {
    return productService.create(request);
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable("id") String id, @RequestBody ProductRequest request) {
    return productService.update(ProductMapper.toUpdateRequest(id, request));
  }

  @DeleteMapping("/{id}")
  public void update(@PathVariable("id") String id) {
    productService.delete(id);
  }

}
