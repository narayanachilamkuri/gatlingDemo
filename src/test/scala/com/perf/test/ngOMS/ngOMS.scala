package com.perf.test.ngOMS
import com.perf.test.BasicSimulation
import io.gatling.app.Gatling
import io.gatling.core.config.{GatlingConfiguration, GatlingPropertiesBuilder}
import com.perf.test.ngOMS.simulations.CreateUsersSimulation
import com.perf.test.BasicSimulation

object ngOMS extends App {
  val props=new GatlingPropertiesBuilder()
    .resourcesDirectory(ngOMSPIDEpath.mavenResourcesDirectory.toString)
    .resultsDirectory(ngOMSPIDEpath.resultsDirectory.toString)
    .binariesDirectory(ngOMSPIDEpath.mavenBinariesDirectory.toString)
  //val simClass = classOf[BasicSimulation].getName
  val simClass = classOf[CreateUsersSimulation].getName
  //val simClass = classOf[BasicSimulation].getName
  //BasicSimulation
  props.simulationClass(simClass)
  //props.noReports()
  Gatling.fromMap(props.build)


}
