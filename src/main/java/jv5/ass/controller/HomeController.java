/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv5.ass.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jv5.ass.cart.Cart;
import jv5.ass.entity.Admin;
import jv5.ass.entity.Customer;
import jv5.ass.entity.Item;
import jv5.ass.entity.Product;
import jv5.ass.repository.AdminRepository;
import jv5.ass.repository.CustomerRepository;
import jv5.ass.repository.ProductRepository;
import jv5.ass.service.ProductService;
import jv5.ass.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hotua
 */
@Controller
public class HomeController {
    
    @Autowired
    private ProductRepository ProductRepo;
    @Autowired
    private ProductService ProductService;
    
    @Autowired
    private CustomerRepository CustomerRepo;
     
    @Autowired
    private AdminRepository AdminRepo;
    
    Cart cart = new Cart();
    int page = 1;
    int Fpage = 1;
    int Bpage = 1;
    
    
    //homepage-------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = {"","/","home"})
    public String homepage(ModelMap model){
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(1, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", 1);
        return "homepage";
    }
    
    @RequestMapping(value="/buy", params = "add")
    public String addToCart(HttpSession session, ModelMap model, @RequestParam("hiddenKey") int masp, @RequestParam("hiddenName") String tensp,
            @RequestParam("hiddenPrice") int gia, @RequestParam("hiddenType") boolean loai, @RequestParam("hiddenUrl") String anh,
            @RequestParam("txtNumber") int quan){
        String destination = "homepage";
        if(session.getAttribute("CurrentUser")==null){
            destination = "login";
        }else{
            Product sp = new Product(masp, tensp, loai, gia, anh);
            Item item = new Item(sp, quan);
            cart.addProduct(item, quan);
            //
            List<Product> list = new ArrayList<>();
            list = ProductService.listPaging(page, 6, 2);
            model.addAttribute("ProductList", list);
        }
        return destination;
    }
    
    
    @RequestMapping(value="paging", params="1")
    public String page1(ModelMap model){
        page=1;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(page, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", page);
        return "homepage";
    }
    
    @RequestMapping(value="paging", params="2")
    public String page2(ModelMap model){
        page=2;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(page, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", page);
        return "homepage";
    }
    
    @RequestMapping(value="paging", params="3")
    public String page3(ModelMap model){
        page=3;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(page, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", page);
        return "homepage";
    }
    
    @RequestMapping(value="paging", params="4")
    public String page4(ModelMap model){
        page=4;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(page, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", page);
        return "homepage";
    }
    
    @RequestMapping(value="paging", params="5")
    public String page5(ModelMap model){
        page=5;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(page, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", page);
        return "homepage";
    }
    
    @RequestMapping(value="paging", params="6")
    public String page6(ModelMap model){
        page=6;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(page, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", page);
        return "homepage";
    }
    
    
    //food-------------------------------------------------------------------------------------------------------------------
    @RequestMapping("fastfood")
    public String fastfood(ModelMap model){
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(1, 6, 1);
        model.addAttribute("ProductList", list);
        model.addAttribute("Fhighlight", 1);
        return "fastfood";
    }
    
    @RequestMapping(value="/Fbuy", params = "add")
    public String FaddToCart(HttpSession session, ModelMap model, @RequestParam("hiddenKey") int masp, @RequestParam("hiddenName") String tensp,
            @RequestParam("hiddenPrice") int gia, @RequestParam("hiddenType") boolean loai, @RequestParam("hiddenUrl") String anh,
            @RequestParam("txtNumber") int quan){
        String destination = "fastfood";
        if(session.getAttribute("CurrentUser")==null){
            destination = "login";
        }else{
            Product sp = new Product(masp, tensp, loai, gia, anh);
            Item item = new Item(sp, quan);
            cart.addProduct(item, quan);
            //
            List<Product> list = new ArrayList<>();
            list = ProductService.listPaging(Fpage, 6, 1);
            model.addAttribute("ProductList", list);
        }
        return destination;
    }

    @RequestMapping(value="Fpaging", params="1")
    public String Fpage1(ModelMap model){
        Fpage=1;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(Fpage, 6, 1);
        model.addAttribute("ProductList", list);
        model.addAttribute("Fhighlight", Fpage);
        return "fastfood";
    }
    
    
    @RequestMapping(value="Fpaging", params="2")
    public String Fpage2(ModelMap model){
        Fpage=2;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(Fpage, 6, 1);
        model.addAttribute("ProductList", list);
        model.addAttribute("Fhighlight", Fpage);
        return "fastfood";
    }
    
    @RequestMapping(value="Fpaging", params="3")
    public String Fpage3(ModelMap model){
        Fpage=3;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(Fpage, 6, 1);
        model.addAttribute("ProductList", list);
        model.addAttribute("Fhighlight", Fpage);
        return "fastfood";
    }
    
    //beverage-------------------------------------------------------------------------------------------------------------------
    @RequestMapping("beverage")
    public String beverage(ModelMap model){
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(1, 6, 0);
        model.addAttribute("ProductList", list);
        model.addAttribute("Bhighlight", 1);
        return "beverage";
    }
    
    @RequestMapping(value="/Bbuy", params = "add")
    public String BaddToCart(HttpSession session, ModelMap model, @RequestParam("hiddenKey") int masp, @RequestParam("hiddenName") String tensp,
            @RequestParam("hiddenPrice") int gia, @RequestParam("hiddenType") boolean loai, @RequestParam("hiddenUrl") String anh,
            @RequestParam("txtNumber") int quan){
        String destination = "beverage";
        if(session.getAttribute("CurrentUser")==null){
            destination = "login";
        }else{
            Product sp = new Product(masp, tensp, loai, gia, anh);
            Item item = new Item(sp, quan);
            cart.addProduct(item, quan);
            //
            List<Product> list = new ArrayList<>();
            list = ProductService.listPaging(Bpage, 6, 0);
            model.addAttribute("ProductList", list);
        }
        return destination;
    }

    @RequestMapping(value="Bpaging", params="1")
    public String Bpage1(ModelMap model){
        Bpage=1;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(Bpage, 6, 0);
        model.addAttribute("ProductList", list);
        model.addAttribute("Bhighlight", Bpage);
        return "beverage";
    }
    
    
    @RequestMapping(value="Bpaging", params="2")
    public String Bpage2(ModelMap model){
        Bpage=2;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(Bpage, 6, 0);
        model.addAttribute("ProductList", list);
        model.addAttribute("Bhighlight", Bpage);
        return "beverage";
    }
    
    @RequestMapping(value="Bpaging", params="3")
    public String Bpage3(ModelMap model){
        Bpage=3;
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(Bpage, 6, 0);
        model.addAttribute("ProductList", list);
        model.addAttribute("Bhighlight", Bpage);
        return "beverage";
    }
    
    //cart-------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/cart")
    public String cart(ModelMap model){
        model.addAttribute("cartList", cart);
        return "cart";
    }
    
    @RequestMapping(value="/ItemDel", params = "delete")
    public String deleteCart(ModelMap model, @RequestParam("hiddenDel") int masp){
        cart.removeProduct(masp);
        model.addAttribute("cartList", cart);
        return "cart";
    }
    
    @RequestMapping(value="/ItemDel", params = "update")
    public String updateCart(ModelMap model, @RequestParam("hiddenDel") int masp, @RequestParam("quantity") int quan){
        cart.updateQuantity(masp, quan);
        model.addAttribute("cartList", cart);
        return "cart";
    }
    
    //search-------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value="/Search", params = "search")
    public String searchRes(ModelMap model, @RequestParam("txtSearch") String keywords){
        List<Product> list = ProductRepo.findAllByTensp("%"+keywords+"%");
        model.addAttribute("ResultSet", list);
        return "search";
    }
    
    @RequestMapping(value="/Sbuy", params = "add")
    public String SaddToCart(HttpSession session, ModelMap model, @RequestParam("hiddenKey") int masp, @RequestParam("hiddenName") String tensp,
            @RequestParam("hiddenPrice") int gia, @RequestParam("hiddenType") boolean loai, @RequestParam("hiddenUrl") String anh,
            @RequestParam("txtNumber") int quan){
        String destination = "homepage";
        if(session.getAttribute("CurrentUser")==null){
            destination = "login";
        }else{
            Product sp = new Product(masp, tensp, loai, gia, anh);
            Item item = new Item(sp, quan);
            cart.addProduct(item, quan);
            //
            List<Product> list = new ArrayList<>();
            list = ProductService.listPaging(1, 6, 2);
            model.addAttribute("ProductList", list);
            model.addAttribute("highlight", 1);
        }
        return destination;
    }
    
    
    //login---------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
    
    @RequestMapping(value="/signin", params="login")
    public String signin(ModelMap model, HttpSession session, @RequestParam("txtLogName") String user,
            @RequestParam("txtLogPass") String pass){
        String destination = "homepage";
        Customer cm = CustomerRepo.findByUsername(user);
        if(user.equals("")||pass.equals("")){
            model.addAttribute("error", "Both username and password must be filled");
            session.invalidate();
            destination = "login";
        }else if(cm==null) {
        	model.addAttribute("error", "Incorrect username!");
            session.invalidate();
            destination = "login";
        }
        
        else if(user.equals(cm.getUsername())&&pass.equals(cm.getPass())){
            String name[] = cm.getTenkh().split(" ");
            if(name.length>=2){
                session.setAttribute("USER", name[name.length-2]+" "+name[name.length-1]);
            }else{
                session.setAttribute("USER", cm.getTenkh());
            }
            session.setAttribute("CurrentUser", cm);
        }else{
            model.addAttribute("error", "Incorrect passwords!");
            session.invalidate();
            destination = "login";
        }
        //
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(1, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", 1);
        return destination;
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session, ModelMap model){
        session.invalidate();
        //
        List<Product> list = new ArrayList<>();
        list = ProductService.listPaging(1, 6, 2);
        model.addAttribute("ProductList", list);
        model.addAttribute("highlight", 1);
        return "homepage";
    }
    
    //Update user info-------------------------------------------------------------------------------------
    
    @RequestMapping("/customerInfo")
    public String csInfo(ModelMap model, HttpSession session){
        Customer cm = (Customer) session.getAttribute("CurrentUser");
        model.addAttribute("cs", cm);
        return "customerInfo";
    }
    
    @RequestMapping(value="/updateInfo", params="update")
    public String update(HttpSession session, @RequestParam("txtmakh") int makh, @RequestParam("txttenkh") String tenkh, @RequestParam("rdSex") boolean sex,
            @RequestParam("txttentk") String user, @RequestParam("txtmatkhau") String pass, @RequestParam("txttel") String tel,
            @RequestParam("txtdiachi") String addr, ModelMap model){
        Customer kh = (Customer) session.getAttribute("CurrentUser");
        if(tenkh.equals("")||user.equals("")||tel.equals("")||addr.equals("")) {
        	model.addAttribute("error", "All textboxes must be filled!");
        }else if(user.length()<6) {
        	model.addAttribute("error", "Username must have at least 6 characters!");
//        }else if(tel.matches("0[0-9]{9-10}")) {
//        	model.addAttribute("error", "Invalid phone number!");
        }else if(kh.getUsername().equals(user)){
            Customer cm = new Customer(makh, tenkh, user, pass, sex, tel, addr);
            CustomerRepo.save(cm);
            session.setAttribute("CurrentUser", cm); 
        }else if(CustomerRepo.findByUsername(user)==null){
            Customer cm = new Customer(makh, tenkh, user, pass, sex, tel, addr);
            CustomerRepo.save(cm);
            session.setAttribute("CurrentUser", cm); 
        }else{
            model.addAttribute("error", "Username is unavailable!");
        }
        return "customerInfo";
    }
    
    @RequestMapping("/updatepass")
    public String updatePass(){
        return "updatepass";
    }
    
    @RequestMapping(value="/changepass", params="update")
    public String changePass(ModelMap model, HttpSession session, @RequestParam("txtpasscu") String oldpass,
            @RequestParam("txtpassmoi") String newpass, @RequestParam("txtxacnhan") String confirm){
    	String des = "customerInfo";
        Customer cm = (Customer) session.getAttribute("CurrentUser");
        if(oldpass.equals("")||newpass.equals("")||confirm.equals("")) {
        	model.addAttribute("error", "All textboxes must be filled!");
            des = "updatepass";
        }else if(newpass.length()<6) {
        	model.addAttribute("error", "Password must have at least 6 characters!");
            des = "updatepass";
        }else if(oldpass.equals(cm.getPass())){
            if(newpass.equals(confirm)){
                cm = new Customer(cm.getMakh(), cm.getTenkh(), cm.getUsername(), newpass, cm.getSex(), cm.getTel(), cm.getAdd());
                CustomerRepo.save(cm);
                session.setAttribute("CurrentUser", cm);
            }else{
                model.addAttribute("error", "Confirming password incorrectly!");
                des = "updatepass";
            }
        }else{
        	des = "updatepass";
            model.addAttribute("error", "Incorrect password!");
        }
        return des;
    }
    
    //register----------------------------------------------------------------------------------------
    @RequestMapping("/register")
    public String regigterPage(){
        return "register";
    }
    
    @RequestMapping(value="signup", params="submit")
    public String register(ModelMap model, HttpSession session, @RequestParam("txtRegUser") String user, @RequestParam("txtRegPass") String pass,
            @RequestParam("txtRegRepass") String repass, @RequestParam("txtRegName") String uname){
        String destination = "homepage";
        if(CustomerRepo.findByUsername(user)==null){
            if(pass.equals(repass)){
                Customer cm = new Customer(uname, user, pass, Boolean.TRUE);
                CustomerRepo.save(cm);
                //
                String name[] = cm.getTenkh().split(" ");
                if(name.length>=2){
                    session.setAttribute("USER", name[name.length-2]+" "+name[name.length-1]);
                }else{
                    session.setAttribute("USER", cm.getTenkh());
                }
                session.setAttribute("CurrentUser", cm);
                //
                List<Product> list = new ArrayList<>();
                list = ProductService.listPaging(1, 6, 2);
                model.addAttribute("ProductList", list);
                model.addAttribute("highlight", 1);
            }else{
                model.addAttribute("error", "Xác nhận mật khẩu sai!");
                destination = "register";
            }
        }else{
            model.addAttribute("error", "Tên tài khoản đã tồn tại!");
            destination = "register";
        }
        return destination;
    }
    
    //product manage---------------------------------------------------------------------------------------------------
    @RequestMapping("/productManage")
    public String productManagePage(ModelMap model, HttpServletRequest req, HttpSession session){
        String des = "productManage";
        if(session.getAttribute("ad")==null){
            des = "adminLogin";
        }else{
            List<Product> list = ProductRepo.findAll();
            model.addAttribute("pList", list);
            Product p = ProductRepo.findAllByMasp(1);//sp dau tien, can chinh lai
            req.setAttribute("chosenP", p);
        }
        return des;
    }
    
    @RequestMapping(value="/sorting", params="sort")
    public String sortProduct(ModelMap model, HttpServletRequest req, HttpSession session,
            @RequestParam("order") boolean order, @RequestParam("flow") boolean flow, @RequestParam("type") int t){
        String des = "productManage";
        boolean type;
        if(session.getAttribute("ad")==null){
            des = "adminLogin";
        }else{
            switch (t) {
                case 1:
                    {
                        type = true;
                        List<Product> list = ProductService.sorting1(order, flow, type);
                        model.addAttribute("pList", list);
                        Product p = ProductRepo.findAllByMasp(1);//sp dau tien, can chinh lai
                        req.setAttribute("chosenP", p);
                        break;
                    }
                case 2:
                    {
                        type = false;
                        List<Product> list = ProductService.sorting1(order, flow, type);
                        model.addAttribute("pList", list);
                        Product p = ProductRepo.findAllByMasp(1);//sp dau tien, can chinh lai
                        req.setAttribute("chosenP", p);
                        break;
                    }
                default:
                    {
                        List<Product> list = ProductService.sorting2(order, flow);
                        model.addAttribute("pList", list);
                        Product p = ProductRepo.findAllByMasp(1);//sp dau tien, can chinh lai
                        req.setAttribute("chosenP", p);
                        break;
                    }
            }
        }
        return des;
    }
    
    @RequestMapping(value="/productList", params="choose")
    public String chooseProduct(@RequestParam("txtId") int masp, HttpServletRequest req, ModelMap model){
        Product p = ProductRepo.findAllByMasp(masp);
        req.setAttribute("chosenP", p);
        //
        List<Product> list = ProductRepo.findAll();
        model.addAttribute("pList", list);
        return "productManage";
    }
    
    @RequestMapping(value="/PMform", params="add")
    public String addProduct(@RequestParam("txtsp") String tensp, @RequestParam("rdtype") boolean loaisp,
            @RequestParam("txtprice") String gia, @RequestParam("txturl") String anh, @RequestParam("txtid") int masp,
            ModelMap model, HttpServletRequest req){
    	
    	String regPrice = "[0-9]+";
    	
    	if(tensp.equals("")||gia.equals("")) {
    		model.addAttribute("error", "Product name and price must be filled");
            req.setAttribute("chosenP", ProductRepo.findAllByMasp(masp));//sp dau tien, can chinh lai
            
    	}else if(!gia.matches(regPrice)) {
    		model.addAttribute("error", "Do you even know what price is..?");
            req.setAttribute("chosenP", ProductRepo.findByTensp(tensp));//sp dau tien, can chinh lai
            
    	}else
        if(ProductRepo.findByTensp(tensp)==null){
        	int price = Integer.parseInt(gia);
            Product p = new Product(tensp, loaisp, price, anh);
            ProductRepo.save(p);
            req.setAttribute("chosenP", p);
            
        }else{
            model.addAttribute("error", "This product has already existed!");
            req.setAttribute("chosenP", ProductRepo.findByTensp(tensp));//sp dau tien, can chinh lai
        }
        //set list cho danh sach san pham ben phai
        List<Product> list = ProductRepo.findAll();
        model.addAttribute("pList", list);
        return "productManage";
    }
    
    @RequestMapping(value="/PMform", params="update")
    public String updateProduct(@RequestParam("txtsp") String tensp, @RequestParam("rdtype") boolean loaisp,
            @RequestParam("txtprice") String gia, @RequestParam("txturl") String anh, @RequestParam("txtid") int masp,
            ModelMap model, HttpServletRequest req){
    	
        String regPrice = "[0-9]+";
    	
    	if(tensp.equals("")||gia.equals("")) {
    		model.addAttribute("error", "Product name and price must be filled");
            req.setAttribute("chosenP", ProductRepo.findAllByMasp(masp));
            
    	}else if(!gia.matches(regPrice)) {
    		model.addAttribute("error", "Do you even know what price is..?");
            req.setAttribute("chosenP", ProductRepo.findByTensp(tensp));//sp dau tien, can chinh lai
            
    	}else {
    		Product p = ProductRepo.findByTensp(tensp);
    		int price = Integer.parseInt(gia);
    		if(p==null){
                Product sp = ProductRepo.findAllByMasp(masp);
                
                sp = new Product(sp.getMasp(), tensp, loaisp, price, anh);
                ProductRepo.save(sp);
                req.setAttribute("chosenP", sp);
            }else{
                if(p.getMasp()==masp){
                    p = new Product(p.getMasp(), tensp, loaisp, price, anh);
                    ProductRepo.save(p);
                    req.setAttribute("chosenP", p);
                }else{
                    model.addAttribute("error", "This product has already existed!");
                    req.setAttribute("chosenP", ProductRepo.findByTensp(tensp));//sp dau tien, can chinh lai
                }
            }
    	}
        
        //set list cho danh sach san pham ben phai
        List<Product> list = ProductRepo.findAll();
        model.addAttribute("pList", list);
        return "productManage";
    }
    
    @RequestMapping(value="/PMform", params="del")
    public String delProduct(@RequestParam("txtid") int masp, ModelMap model, HttpServletRequest req){
        Product sp = ProductRepo.findAllByMasp(masp);
        ProductRepo.delete(sp);
        //
        Product p = ProductRepo.findAllByMasp(1);//sp dau tien, can chinh lai
        req.setAttribute("chosenP", p);
        //set list cho danh sach san pham ben phai
        List<Product> list = ProductRepo.findAll();
        model.addAttribute("pList", list);
        return "productManage";
    }
    
    //customer manage---------------------------------------------------------------------------------------
    @RequestMapping("/customerManage")
    public String cManagePage(ModelMap model, HttpSession session){
        String des = "customerManage";
        if(session.getAttribute("ad")==null){
            des = "adminLogin";
        }else{
        List<Customer> list = CustomerRepo.findAll();
        model.addAttribute("CustomerList", list);
        }
        return des;
    }
    
    @RequestMapping(value="/CList", params="del")
    public String delCustomer(ModelMap model, @RequestParam("txtId") int makh){
        Customer cm = CustomerRepo.findByMakh(makh);
        CustomerRepo.delete(cm);
        //
        List<Customer> list = CustomerRepo.findAll();
        model.addAttribute("CustomerList", list);
        return "customerManage";
    }
    
    //manager login/out========================================================================================
    @RequestMapping("/adminLogin")
    public String aLogin(HttpSession session){
        session.invalidate();
        return "adminLogin";
    }
    
    @RequestMapping(value="/aLogin", params="login")
    public String login(@RequestParam("user") String user, @RequestParam("pass") String pass, ModelMap model,
            HttpServletRequest req, HttpSession session){
        String des = "productManage";
        Admin ad = AdminRepo.findByUsername(user);
        if(ad==null){
            req.setAttribute("error", "Incorrect username!");
            des = "adminLogin";
        }else if(!pass.equals(ad.getPass())){
            req.setAttribute("error", "Incorrect password!");
            des = "adminLogin";
        }else{
            session.setAttribute("ad", "1");
            //
            List<Product> list = ProductRepo.findAll();
            model.addAttribute("pList", list);
            Product p = ProductRepo.findAllByMasp(1);//sp dau tien, can chinh lai
            req.setAttribute("chosenP", p);
        }
        return des;
    }
}
