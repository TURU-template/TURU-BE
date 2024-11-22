
@Controller
@RequestMapping("/login")
public class LoginController {

    public String displayLoginForm(Model model) {
       
       model.addAtrribute("LoginModel", new LoginModel());
        return "Login .html";

    }
}

@GetMaping("/")
public String displayLoginForm(Model model) {
    model.addAtrribute("LoginModel", new LoginModel());

    return"LoginForm.html";

}

@PosMapping("/processLogin") {
    public String processLogin(@Valid LoginModel loginModelodel, BindingResult Model model) {
        if (bindiqResult.hasErrors()) {
            model.addAtrribute("LoginModel", loginModel);
            return "loginForm.html"
        }
        model.addAtrribute("loginModel", loginModel);
        return "LoginResults.html";
    }
}