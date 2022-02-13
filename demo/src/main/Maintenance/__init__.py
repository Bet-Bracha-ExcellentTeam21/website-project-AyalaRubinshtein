import json
import requests


def add_product(product_name, product_class, price, path_picture, details):
    product = {"product_name": product_name,
               "product_class": product_class,
               "price": price,
               "path_picture": path_picture,
               "details": details}
    response = requests.post("http://127.0.0.1:8080/addProduct", data=product)
    print(response)



if __name__ == "__main__":
    add_product("jewelry", "je", "900", "/img", "some..")
