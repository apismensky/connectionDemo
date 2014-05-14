package controllers

import play.mvc.Results._
import play.mvc.Result
import play.Logger
import play.db.jpa.{JPA, Transactional}

class HealthController {

  @Transactional
  def index(): Result = if (isHealthy) ok("good") else internalServerError("bad")

  def isHealthy = {
      try {
        // Change it to JPA.em() anf test will pass
        val em = JPA.em("default")
        val rs = em.createNativeQuery("select 'rs' from DUAL").getSingleResult.asInstanceOf[String]
        "rs" == rs
      }
      catch {
        case e: Exception => {
          Logger.error("Database connection check failed: ", e)
        }
        false
      }
    }

}

