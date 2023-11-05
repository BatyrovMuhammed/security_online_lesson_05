package legendsoft.security_online_lesson_05.api;

import legendsoft.security_online_lesson_05.models.Product;
import legendsoft.security_online_lesson_05.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/")
    public String findAll(Model model) {
        model.addAttribute("allProduct", productService.findAllProduct());
        return "mainPage";
    }

    @RequestMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "innerPage";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product")Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView updateProduct(@PathVariable(name = "id")Long id){
        ModelAndView view = new ModelAndView("edit_product");
        Product product = productService.findByIdProduct(id);
        view.addObject("product", product);
        return view;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id")Long id){
        productService.deleteByIdProduct(id);
        return ("redirect:/");
    }



}
