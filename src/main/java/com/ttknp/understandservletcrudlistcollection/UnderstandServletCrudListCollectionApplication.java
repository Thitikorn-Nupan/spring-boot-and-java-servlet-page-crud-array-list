package com.ttknp.understandservletcrudlistcollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // have to use *** This will enable spring boot to scan @WebServlet as well as @WebListener.
public class UnderstandServletCrudListCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnderstandServletCrudListCollectionApplication.class, args);
    }


}
