@restController
@RequestMapping("/api")
class HelloController{
  @GetMapping("/hello")
  fun sayHello():String = "Hello"
}
