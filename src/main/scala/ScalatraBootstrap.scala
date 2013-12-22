import com.gastove.topshelf._
import com.gastove.topshelf.servlets.{SpiritsServlet, TopShelfServlet}
import com.gastove.topshelf.conf.database.InitializeDatabase
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle with InitializeDatabase {
  override def init(context: ServletContext) {
    configureDB()
    context.mount(new TopShelfServlet, "/*")
    context.mount(new SpiritsServlet, "/spirits/*")
  }

  override def destroy(context: ServletContext) {
    closeDBConnection()
  }

}
