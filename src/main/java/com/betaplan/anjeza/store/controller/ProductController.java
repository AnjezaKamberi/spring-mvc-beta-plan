package com.betaplan.anjeza.store.controller;

import com.betaplan.anjeza.store.model.Product;
import com.betaplan.anjeza.store.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/product")
public class ProductController {

//    @Autowired
//    private ProductService service;

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all-products")
    public String showAllProducts(Model model) {
        List<Product> products = service.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/new")
    public String addNewProduct(@ModelAttribute Product product) {
        return "product";
    }

    @PostMapping("/product/create")
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product";
        } else {
            service.doAnActionOnProduct(product);
            return "redirect:/all-products";
        }
    }

    @GetMapping("/product/edit/{id}")
    public String editExistingProduct(@PathVariable Integer id, Model model) {
        Product product = service.getProductById(id);
        model.addAttribute("product", product);
        return "updateProduct";
    }

    @PutMapping("/product/update/{id}")
    public String updateProduct(@PathVariable Integer id, @Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "updateProduct";
        } else {
            service.doAnActionOnProduct(product);
            return "redirect:/all-products";
        }
    }

    //    @DeleteMapping("/product/delete/{id}")
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        service.deleteProductById(id);
        return "redirect:/all-products";
    }

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable Integer id, Model model) {
        model.addAttribute("product", service.getProductById(id));
        return "product-details";
    }

}
