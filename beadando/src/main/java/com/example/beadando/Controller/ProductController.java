package com.example.beadando.Controller;

import com.example.beadando.Entity.ProductEntity;
import com.example.beadando.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(){
        return "homepage";
    }

    //listázás és nézet
    @GetMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/new")
    public String createProductForm(Model model){
        ProductEntity product = new ProductEntity();
        model.addAttribute("product", product);
        return "create_product";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") ProductEntity product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id,Model model) {
        model.addAttribute("product",productService.getProductById(id));
        return "edit_product";

    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id,
                                @ModelAttribute("product") ProductEntity product,
                                Model model){
        ProductEntity existingProduct = productService.getProductById(id);
        existingProduct.setId(id);
        existingProduct.setNev(product.getNev());
        existingProduct.setMarka(product.getMarka());
        existingProduct.setTipus(product.getTipus());
        existingProduct.setAr(product.getAr());

        productService.updateProduct(existingProduct);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
