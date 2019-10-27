package com.marketplace.service.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.product.Product;
import com.marketplace.domain.product.ProductLogic;

public class ProductActivity {
	
	public ProductRepresentation getProductByID(int productID) {
		ProductLogic aLogic = new ProductLogic();
		Product product = aLogic.getProductByID(productID);
		
		ProductRepresentation aRes = new ProductRepresentation();
		aRes.setProductID(product.getproductID());
		aRes.setPartner(product.getpartner());
		aRes.setProductName(product.getproductName());
		aRes.setProductDescription(product.getproductDescription());
		aRes.setProductCost(product.getproductCost());
		return aRes;
	}
	
	public List<ProductRepresentation> getAllProducts(int offset, int limit){
		ProductLogic aLogic = new ProductLogic();	
		List<Product> products = new ArrayList<Product>();
		List<ProductRepresentation> aResponses = new ArrayList<ProductRepresentation>();
		products = aLogic.getAllProducts(offset, limit);
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product product = (Product)it.next();
          
        ProductRepresentation aRes = new ProductRepresentation();
		aRes.setProductID(product.getproductID());
		aRes.setPartner(product.getpartner());
		aRes.setProductName(product.getproductName());
		aRes.setProductDescription(product.getproductDescription());
		aRes.setProductCost(product.getproductCost());
        aResponses.add(aRes);
        }
		
		return aResponses;
	}
	
	public ProductRepresentation addProduct(ProductRequest aReq) {
		ProductLogic aLogic = new ProductLogic();
		Product product = aLogic.addProduct(aReq.getpartner(), aReq.getProductName(), aReq.getproductDescription(), aReq.getproductCost());
		
		ProductRepresentation aRes = new ProductRepresentation();
		aRes.setProductID(product.getproductID());
		aRes.setPartner(product.getpartner());
		aRes.setProductName(product.getproductName());
		aRes.setProductDescription(product.getproductDescription());
		aRes.setProductCost(product.getproductCost());
		return aRes;
	}
	
	public ProductRepresentation deleteProduct(int productID) {
		ProductLogic aLogic = new ProductLogic();
		Product product = aLogic.deleteProduct(productID);
		
		ProductRepresentation aRes = new ProductRepresentation();
		aRes.setProductID(product.getproductID());
		aRes.setPartner(product.getpartner());
		aRes.setProductName(product.getproductName());
		aRes.setProductDescription(product.getproductDescription());
		aRes.setProductCost(product.getproductCost());
		return aRes;
	}

}
