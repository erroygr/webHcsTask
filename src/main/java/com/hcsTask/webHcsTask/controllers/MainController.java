package com.hcsTask.webHcsTask.controllers;

import com.hcsTask.webHcsTask.model.*;
import com.hcsTask.webHcsTask.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;



@Controller
public class MainController {

    @GetMapping("/")
    public String homeHcs(Model model) {
        model.addAttribute("title", "Главная страница");
        return "homeHcs";
    }
    @Autowired
    private UserTableRepository userTableRepository;
    @Autowired
    private MasterTableRepository masterTableRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    // save uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://Users//Egor//Desktop//webHcsTask//src//main//resources//picture//";

    // ПОКАЗАТЬ ВСЕ ЗАЯВКИ
    @GetMapping("/view-request")
    public String viewRequestMain(Model model) {
        Iterable<Request> requests = requestRepository.findAll();
        model.addAttribute("requests",requests);
        return "request/view-request";
    }

    // ПОКАЗАТЬ ДОБАВЛЕНИЕ ЗАЯВКИ
    @GetMapping("/view-request/add")
    public String addRequestMain(Model model) {
        Iterable<UserTable> userTables =  userTableRepository.findAll();
        model.addAttribute("userTables",userTables);

        Iterable<Category> categories =  categoryRepository.findAll();
        model.addAttribute("categories",categories);
        return "request/create-request";
    }

    //ОТПРАВКА ДАННХ ДОБАВЛЕНИЕ ДЛЯ ЗАЯВКИ
    @PostMapping("/view-request/add")
    public String addPostRequestMain(@RequestParam String user,
                                     @RequestParam String categ,
                                     @RequestParam String requestDescription,
                                     Model model) {

        UserTable userTable = userTableRepository.findByUserLastName(user);
        Category category = categoryRepository.findByCategoryName(categ);

        Request request = new Request(userTable,
                null,
                category,
                null,
                requestDescription,
                "НОВАЯ");
        requestRepository.save(request);

        // редирект на страничку заявок от юзера, а не на весь список заявок
        return "redirect:/view-request";
    }

    // ПОКАЗ ДЕТАЛИ ЗАЯКИ
    @GetMapping("/view-request/{id}")
    public String viewRequestDetails(@PathVariable(value = "id") long id, Model model){
        if(!requestRepository.existsById(id)){
            return "redirect:/view-request";
        }
        Optional<Request> request = requestRepository.findById(id);
        ArrayList<Request> reports = new ArrayList<>();
        request.ifPresent(reports::add);
        model.addAttribute("request",reports);
        return "request/view-request-details";
    }

    // ПОКАЗ ДЕТАЛИ ЗАЯКИ ИЗМЕНИТЬ
    @GetMapping("/view-request/{id}/edite")
    public String requestEdit(@PathVariable(value = "id") long id, Model model){
        if(!requestRepository.existsById(id)){
            return "redirect:/view-request";
        }
        Optional<Request> request = requestRepository.findById(id);
        ArrayList<Request> reports = new ArrayList<>();
        request.ifPresent(reports::add);
        model.addAttribute("request",reports);
        return "request/view-request-edite";
    }

    // ОТПРАВИТЬ ДЕТАЛИ ЗАЯКИ ИЗМЕНИТЬ
    @PostMapping("/view-request/{id}/edite")
    public String updatePostRequestMain(@PathVariable(value = "id") long id,
                                        @RequestParam String user,
                                        @RequestParam String master,
                                        @RequestParam String category,
                                        @RequestParam String subCategory,
                                        @RequestParam String requestDescription,
                                        Model model) {

        Request request = requestRepository.findById(id).orElseThrow();
        request.setUser(userTableRepository.findByUserLastName(user));
        request.setMaster(null);
        request.setCategory(categoryRepository.findByCategoryName(category));
        request.setSubcategory(null);
        request.setRequestdescription(requestDescription);
        request.setRequeststatus("КОРРЕКТИРОВКИ ОТ ПОЛЬЗОВАТЕЛЯ");
        requestRepository.save(request);
        return "redirect:/view-request";
    }

    // УДАЛИТЬ ЗАЯВКУ
   @PostMapping("/view-request/{id}/remove")
    public String deletePostRequestMain(@PathVariable(value = "id") long id,
                                        Model model) {

        Request request = requestRepository.findById(id).orElseThrow();
       requestRepository.delete(request);
        return "redirect:/view-request";
    }











    // ДРУГОЕ
    @GetMapping("/view-userTable/add")
    public String addUserTableMain(Model model) {
        return "create-userTable";
    }

    @GetMapping("/view-masterTable/add")
    public String addMasterTableMain(Model model) {
        return "create-masterTable";
    }


    //ОТПРАВКА ДАННХ ДОБАВЛЕНИЕ НОВЫЙ ЮЗЕР
    @PostMapping("/view-userTable/add")
    public String addPostUserTableMain(@ModelAttribute UploadForm form,
                                       @RequestParam String userName,
                                       @RequestParam String userLastName,
                                       @RequestParam String userAddress,
                                       Model model) {

        UserTable userTable = new UserTable(userName,
                userLastName,
                userAddress);
        userTableRepository.save(userTable);

        return "redirect:/view-userTable";
    }

    //ОТПРАВКА ДАННХ ДОБАВЛЕНИЕ НОВЫЙ МАСТЕР
    @PostMapping("/view-masterTable/add")
    public String addPostMasterTableMain(@ModelAttribute UploadForm form,
                                         @RequestParam String masterName,
                                         @RequestParam String masterLastName,
                                         Model model) {

        MasterTable masterTable = new MasterTable(masterName,
                masterLastName);
        masterTableRepository.save(masterTable);

        return "redirect:/view-masterTable";
    }

    // ПОКАЗАТЬ ВСЕЗ ЮЗЕРОВ
    @GetMapping("/view-userTable")
    public String viewUserTableMain(Model model) {
        Iterable<UserTable> userTables = userTableRepository.findAll();
        model.addAttribute("userTables",userTables);
        return "view-userTable";
    }

    // ПОКАЗАТЬ ВСЕХ МАСТЕРОВ
    @GetMapping("/view-masterTable")
    public String viewMasterTableMain(Model model) {
        Iterable<MasterTable> masterTables = masterTableRepository.findAll();
        model.addAttribute("masterTables",masterTables);
        return "view-masterTable";
    }

}