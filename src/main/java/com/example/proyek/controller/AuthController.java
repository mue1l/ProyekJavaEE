package com.example.proyek.controller;

import com.example.proyek.model.User;
import com.example.proyek.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> list() {
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
        	User user = userService.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate(); // Menghapus sesi pengguna

        // Mengarahkan pengguna kembali ke halaman login
        return new RedirectView("/view-login");
    }

    @PostMapping("/register")
    public String add(@RequestBody User user) {
    	userService.saveUser(user);
    	return "view-login"; 
    }
  
    @RequestMapping("/login")
    public RedirectView loginUser(@ModelAttribute User user, HttpSession session, Model model) {
        try {
            String result = userService.loginUser(user, session);
            if ("admin-index".equals(result) || "mahasiswa-index".equals(result)) {
                User loggedInUser = (User) session.getAttribute("user");
                Integer userId = loggedInUser.getId();
                session.setAttribute("idUser", userId);
                return new RedirectView("/" + result);
            }
        } catch (NoSuchElementException e) {
            return new RedirectView("/login?error=1");
        }
        return new RedirectView("/login?error=1");
    }


}
