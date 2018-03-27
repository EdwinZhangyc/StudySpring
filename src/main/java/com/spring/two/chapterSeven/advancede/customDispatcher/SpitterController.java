package com.spring.two.chapterSeven.advancede.customDispatcher;

import com.spring.two.chapterSix.WebView.resolverJstl.Spitter;
import com.spring.two.chapterSix.WebView.resolverJstl.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/spittler")
public class SpitterController {

    private SpittleRepository spittleRepository;

    public SpitterController() {}

    @Autowired
    public SpitterController(SpittleRepository mockRepository) {
        this.spittleRepository = mockRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {

        //model.addAttribute("spitter",new Spitter());
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(

            //添加byte【】数组参数，为其添加@RequestPart注解，为了接受multipart形式的二进制数据
            @RequestPart("profilePicture") MultipartFile profilePicture,
            //校验Spitter
            @Valid Spitter spitter,
            RedirectAttributes model,
            Errors errors) {

        //如果校验失败，则重新返回表单
        if(errors.hasErrors()) return "registerForm";

        spittleRepository.save(spitter);
        //将spitter对象放入到flash中，就行传递参数
        model.addFlashAttribute(spitter);
        //将上传地文件写入到文件系统中
        try {
            profilePicture.transferTo(new File("/data/uploads" + profilePicture.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "redirect:/spitter/"+ spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(
        @PathVariable String username, Model model){
        /**
         *  校验会话中是否有key值为spitter的对象，如果有则放到模型中，
         *  没有则从数据库中查询得到spitter对象在放到模型中
         */
        if(!model.containsAttribute("spitter")){

        model.addAttribute(spittleRepository.findByUserName(username));
        }
        return "profile";
    }


}