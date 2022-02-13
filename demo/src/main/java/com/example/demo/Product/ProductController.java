package com.example.demo.Product;


import com.example.demo.Cart.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String viewHomePage(Model model){
        List<Product> listProducts = productService.listAll("");
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") int id, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(productService.find(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Item(productService.find(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        return "cart";
    }

    @PostMapping("/addNewProduct")
    @ResponseBody
    public ResponseTransfer postResponseController(@RequestBody Product newProduct) {
        productService.save(newProduct);
        return new ResponseTransfer("Thanks For Posting!!!");
    }

    @GetMapping("/search")
    public String viewSearchResult(Model model, @Param("keyWord") String keyWord){
        List<Product> listProducts = productService.listAll(keyWord);
        model.addAttribute("listProducts", listProducts);
        return "list-results";
    }

    /**@GetMapping
    public List<Product> getProduct(){

        return productService.getProduct();
    }*/

    private int exists(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getID() == id) {
                return i;
            }
        }
        return -1;
    }
}