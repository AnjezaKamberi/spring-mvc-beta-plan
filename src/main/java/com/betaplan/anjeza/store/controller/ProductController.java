package com.betaplan.anjeza.store.controller;

import com.betaplan.anjeza.store.enums.Role;
import com.betaplan.anjeza.store.model.Product;
import com.betaplan.anjeza.store.model.Review;
import com.betaplan.anjeza.store.model.User;
import com.betaplan.anjeza.store.service.CategoryService;
import com.betaplan.anjeza.store.service.ProductService;
import com.betaplan.anjeza.store.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
//@RequestMapping("/product")
public class ProductController {

//    @Autowired
//    private ProductService service;

    private final CategoryService categoryService;
    private final ProductService service;
    private final UserService userService;

    public ProductController(CategoryService categoryService, ProductService service, UserService userService) {
        this.categoryService = categoryService;
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/all-products")
    public String showAllProducts(Model model) {

        List<Product> products = service.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/new")
    public String addNewProduct(Model model, HttpSession session) {
        // Check if the user is logged in (check if session contains loggedInUser)
        if (session.getAttribute("userId") == null || !isAdmin((Integer) session.getAttribute("userId"))) {
            return "redirect:/login-register";  // Redirect to login page if not logged in
        }

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "product";
    }

    @PostMapping("/product/create")
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult result, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (Objects.isNull(userId)) {
//        if (userId == null) {
            return "redirect:/login";  // Redirect to login page if not logged in
        }
        if (result.hasErrors()) {
            return "product";
        } else {
            User user = userService.findById(userId);
            product.setCreatedBy(user);
            service.doAnActionOnProduct(product);
            return "redirect:/all-products";
        }
    }

    @GetMapping("/product/edit/{id}")
    public String editExistingProduct(@PathVariable Integer id, Model model, HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";  // Redirect to login page if not logged in
        }

        Product product = service.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "updateProduct";
    }

    @PutMapping("/product/update/{id}")
    public String updateProduct(@PathVariable Integer id, @Valid @ModelAttribute Product product, BindingResult result, HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";  // Redirect to login page if not logged in
        }

        if (result.hasErrors()) {
            return "updateProduct";
        } else {
            service.doAnActionOnProduct(product);
            return "redirect:/all-products";
        }
    }

    //    @DeleteMapping("/product/delete/{id}")
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";  // Redirect to login page if not logged in
        }

        service.deleteProductById(id);
        return "redirect:/all-products";
    }

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable Integer id, Model model) {
        model.addAttribute("product", service.getProductById(id));
        return "product-details";
    }

    private boolean isAdmin(Integer userId) {

        User user = userService.findById(userId);

        return Objects.equals(Role.ADMIN, user.getRole());
    }


    @PostMapping("/product/{productId}/review/add")
    public String addReview(@PathVariable Integer productId, @ModelAttribute Review review, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null) {
            User user = userService.findById(userId);
            Product product = service.getProductById(productId);
            if (user != null && product != null) {
                review.setUser(user);
                review.setProduct(product);

            }
        }
        return "redirect:/all-products";
    }
}
