package dev.azemoning.starter.presenter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatalogPresenter {

    @GetMapping("/catalog")
    public String showCatalog(Model model) {
        List<String> catalogs = new ArrayList<>();
        catalogs.add("Mie Ayam");
        catalogs.add("Bakso");
        catalogs.add("Nasi Goreng");
        catalogs.add("Soto Ayam");
        model.addAttribute("catalogs", catalogs);
        return "catalog";
    }
}
