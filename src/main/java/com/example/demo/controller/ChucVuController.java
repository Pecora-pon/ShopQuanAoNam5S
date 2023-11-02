//package com.example.demo.controller;
//
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
//@Controller
//public class ChucVuController {
//    @Autowired
//    private ChucVuService chucVuService;
//    @RequestMapping("/chuc-vu")
//    public String getAll(Model model) {
//        List<ChucVu> chucVuList = chucVuService.getAll();
//        model.addAttribute("listChucVu",chucVuList);
//        model.addAttribute("cv",new ChucVu());
//        return "admin/chucvu";
//    }
//    @RequestMapping(value = "/chuc-vu-add",method = RequestMethod.POST)
//    public String addChucVu(@Valid @ModelAttribute("cv") ChucVu chucVu, BindingResult result,Model model){
//        if(result.hasErrors()){
//            return "admin/chucvu";
//        }
//        chucVuService.add(chucVu);
//        return "redirect:/chuc-vu";
//    }
//    @RequestMapping("/chuc-vu/delete/{chucVuID}")
//    public String delete(@PathVariable("chucVuID") Integer chucVuID){
//        chucVuService.delete(chucVuID);
//        return "redirect:/chuc-vu";
//    }
//    @RequestMapping("/chuc-vu-view-update/{chucVuID}")
//    public String viewUpdate(@PathVariable("chucVuID") Integer chucVuID,Model model){
//        ChucVu chucVu = chucVuService.detail(chucVuID);
//        List<ChucVu> chucVuList = chucVuService.getAll();
//        model.addAttribute("listChucVu",chucVuList);
//        model.addAttribute("cv",chucVu);
//        return "admin/chucvu-update";
//    }
//    @RequestMapping(value = "/chuc-vu/update/{chucVuID}",method = RequestMethod.POST)
//    public String update(@PathVariable("chucVuID") Integer chucVuID,ChucVu chucVu){
//        chucVuService.update(chucVuID,chucVu);
//        return "redirect:/chuc-vu";
//    }
//}
