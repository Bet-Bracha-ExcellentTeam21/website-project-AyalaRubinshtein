package com.example.demo.Cart;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.example.demo.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
    private final ProductService productService;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

  @RequestMapping(value = "cart", method = RequestMethod.GET)
    public String index() {
        return "cart";
    }

  @RequestMapping(value = "/shoppingCart/{id}", method = RequestMethod.GET)
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
      return "redirect:cart";
  }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:/cart/index";
    }

    private int exists(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getID() == id) {
                return i;
            }
        }
        return -1;
    }

}