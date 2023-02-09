package id.cogman.auditrail.mappers;

import id.cogman.auditrail.dtos.ProductRequest;
import id.cogman.auditrail.dtos.ProductUpdateRequest;
import id.cogman.auditrail.entities.Product;

public class ProductMapper {

  public static Product toEntity(ProductRequest request) {
    return Product.builder()
        .name(request.getName())
        .description(request.getDescription())
        .build();
  }

  public static Product toEntity(ProductUpdateRequest request) {
    return Product.builder()
        .id(request.getId())
        .name(request.getName())
        .description(request.getDescription())
        .build();
  }

  public static ProductUpdateRequest toUpdateRequest(String id, ProductRequest request) {
    return ProductUpdateRequest.builder()
        .id(id)
        .name(request.getName())
        .description(request.getDescription())
        .build();
  }

}
