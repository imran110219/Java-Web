package com.sadman.thymeleaflayout.controller;

import com.sadman.thymeleaflayout.form.SignupForm;
import com.sadman.thymeleaflayout.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sadman.thymeleaflayout.model.Account;
import com.sadman.thymeleaflayout.service.AccountService;
import com.sadman.thymeleaflayout.utility.AjaxUtils;
import com.sadman.thymeleaflayout.utility.MessageHelper;

import javax.validation.Valid;

@Controller
class SignupController {

    private static final String SIGNUP_VIEW_NAME = "signup/signup";

    @Autowired
    private AccountService accountService;

    @GetMapping("signup")
    String signup(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
        model.addAttribute(new SignupForm());
        if (AjaxUtils.isAjaxRequest(requestedWith)) {
            return SIGNUP_VIEW_NAME.concat(" :: signupForm");
        }
        return SIGNUP_VIEW_NAME;
    }

    @PostMapping("signup")
    public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return SIGNUP_VIEW_NAME;
        }
        Account account = accountService.save(signupForm.createAccount());
        accountService.signin(account);
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, "signup.success");
        return "redirect:/";
    }
}
