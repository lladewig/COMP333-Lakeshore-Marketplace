package com.marketplace.service.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.product.Product;
import com.marketplace.domain.product.ProductLogic;
import com.marketplace.service.link.Link;
import com.marketplace.service.partner.PartnerRepresentation;

public class ProductActivity {
	
	public ProductRepresentation getProductByID(int productID) {
		ProductLogic aLogic = new ProductLogic();
		Product product = aLogic.getProductByID(productID);
		
		ProductRepresentation aRes = buildResponse(product);
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
          
				
				Link getProd = new Link("getProduct", "http://localhost:8080/productservice/products/" + product.getproductID(), "null");
				Link getProdReviews = new Link("getReview", "http://localhost:8080/reviewservice/reviews?prodID=" + product.getproductID() + "&offset=0&limit=10", "null");
				Link getAllProd = new Link("getAllProducts", "http://localhost:8081/productservice/products?offset=0&limit=10", "null");
				Link order = new Link("orderProduct", "http://localhost:8081/orderservice/orders", "application/xml");
				ProductRepresentation aRes = buildResponse(product,getProd,getProdReviews,getAllProd,order);
				
				aResponses.add(aRes);
        }
		
		return aResponses;
	}
	
	public ProductRepresentation addProduct(ProductRequest aReq) {
		ProductLogic aLogic = new ProductLogic();
		Product product = aLogic.addProduct(aReq.getPartnerID(), aReq.getProductName(), aReq.getproductDescription(), aReq.getproductCost());
		
		ProductRepresentation aRes = buildResponse(product);
		return aRes;
	}
	
	public ProductRepresentation deleteProduct(int productID) {
		ProductLogic aLogic = new ProductLogic();
		Product product = aLogic.deleteProduct(productID);
		
		ProductRepresentation aRes = buildResponse(product);
		return aRes;
	}

	private ProductRepresentation buildResponse(Product product, Link...links) {
		ProductRepresentation aRes = new ProductRepresentation();
		PartnerRepresentation pRes = new PartnerRepresentation();
		
		pRes.setPartnerID(product.getpartner().getpartnerID());
		pRes.setPartnerName(product.getpartner().getpartnerName());
		pRes.setPartnerType(product.getpartner().getpartnerType());
		pRes.setPartnerDetails(product.getpartner().getpartnerDetails());	
		
		aRes.setProductID(product.getproductID());
		aRes.setPartner(pRes);
		aRes.setProductName(product.getproductName());
		aRes.setProductDescription(product.getproductDescription());
		aRes.setProductCost(product.getproductCost());
		aRes.setLinks(links);
		return aRes;
	}
	
	
}
