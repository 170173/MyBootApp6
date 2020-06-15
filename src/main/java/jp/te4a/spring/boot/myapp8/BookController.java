
  package jp.te4a.spring.boot.myapp8;
  import org.springframework.beans.BeanUtils;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.ModelAttribute;
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestParam;

  @Controller
  @RequestMapping("books")
  public class BookController {
    @Autowired
    BookService bookService;
    
    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, BookForm form) {
      bookService.update(form);
      return "redirect:/books";
    }
    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
      bookService.delete(id);
      return "redirect:/books";
    }
    @PostMapping(path = "edit", params = "goToTop")
    String goToTop() {
      return "redirect:/books";
    }
  }

